package org.agenciaportal.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.agenciaportal.authentication.SecurityService;
import org.agenciaportal.dao.ProductDao;
import org.agenciaportal.dao.ProductOrderDao;
import org.agenciaportal.dao.ProductTypeDao;
import org.agenciaportal.entity.Order;
import org.agenciaportal.entity.Product;
import org.agenciaportal.exceptions.NoOrderFoundException;
import org.agenciaportal.exceptions.ProductOutOfStockException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
//Enable Hibernate Transaction.
@Transactional
//Need to use RedirectAttributes
@EnableWebMvc
public class ProductController {
	
	public static Logger logger = Logger.getLogger(MainController.class);
	
	@Autowired
    private ProductDao produtoDAO;
	@Autowired
    private ProductOrderDao viagemOrderDAO;
	@Autowired
    private SecurityService securityService;
	@Autowired
    private ProductOrderDao orderDAO;
	@Autowired
	private ProductTypeDao productTypeDao; 
	
	@InitBinder // fazer com que o Spring reconheça o validador
	public void myInitBinder(WebDataBinder dataBinder) {
		
        
		Object target = dataBinder.getTarget();
		if (target == null) {
			return;
		}
		if (logger.isDebugEnabled())
			logger.debug("Target =" + target);

		//if (target.getClass() == Account.class)
		//	dataBinder.setValidator(OrderValidator);

	}
	
	
	// Product List page.
    @RequestMapping({ "/viagensList/{typeId}" })
    public String listViagensHandler(HttpServletRequest request, Model model, @PathVariable("typeId") Long typeId) {
        model.addAttribute("list",produtoDAO.getAllProductsByType(typeId));
        model.addAttribute("isAdmin", request.isUserInRole("ADMIN"));
        return "/viagensList";
    }
    
    // Product List page.
    @RequestMapping({ "/viagens/{alias}" })
    public String listViagensHandler(HttpServletRequest request, Model model, @PathVariable("alias") String alias) {
        model.addAttribute("list",produtoDAO.getAllProductsByAlias(alias));
        model.addAttribute("productType", productTypeDao.getByAlias(alias));
        model.addAttribute("isAdmin", request.isUserInRole("ADMIN"));
        return "/viagensList";
    }
    
    @RequestMapping({ "/buyProduct" })
    public String buyProduct(HttpServletRequest request, Model model, //
            @RequestParam(value = "code", defaultValue = "") String code,
    		@RequestParam(value = "productType" , defaultValue = "") String productType) {
    	if(code.isEmpty())
    	{
    		return "redirect:/viagensList";
    	}
    	
        Product product = null;
        if (code != null && code.length() > 0) {
            product = produtoDAO.findProduct(code);
        }
        if (product != null) {
        	if(product.getQuantity() == 0)
        	{	
				logger.error("Product out of stock having code "+code);
        		throw new ProductOutOfStockException();
        	}
        	model.addAttribute("product",product);
        }
        model.addAttribute("isAdmin", request.isUserInRole("ADMIN"));
        return "/confirmation";
    }
    
    @RequestMapping(value = { "/purchase" }, method = RequestMethod.POST)
    // Avoid UnexpectedRollbackException
    @Transactional(propagation = Propagation.NEVER)
    public String purchaseProduct(HttpServletRequest request, Model model, @Validated Product product, RedirectAttributes redirectAttributes) {
    	String code = request.getParameter("code");
    	String productType = request.getParameter("type");
    	int quantity =Integer.parseInt( request.getParameter("quantity"));
    	@SuppressWarnings("deprecation")
		Long godate = Date.parse(request.getParameter("goDate"));
    	@SuppressWarnings("deprecation")
		Long backdate = Date.parse(request.getParameter("backDate"));
    	Date ida = new Date(godate);
    	Date volta = new Date(backdate);
    	
    	ArrayList<String> erros = new ArrayList<>();
    	if(ida.before(new Date())) {
    		erros.add("Data de ida não pode ser menor que a data atual.");
    	} else if(ida.after(volta)) {
    		erros.add("Data de ida não pode ser menor que a data de volta.");
    	}
    	
    	if(erros.size() > 0) {
    		redirectAttributes.addFlashAttribute("erros", erros);
    		redirectAttributes.addAttribute("code", product.getCode());
    		model.addAttribute("erros", erros);
    		model.addAttribute("product",product);
    		return "redirect:/buyProduct";
    	}
    	
    	Order order = viagemOrderDAO.saveOrder(code, productType, quantity, ida, volta, securityService.findLoggedInUsername());
    	model.addAttribute("order",order);
    	 if(logger.isInfoEnabled())
    	        logger.info("Product purchased having code "+code+", quantity "+quantity);
    	model.addAttribute("isAdmin", request.isUserInRole("ADMIN"));
        return "/orderDetail";
    }
    
    @RequestMapping(value = { "/ultimasViagens" }, method = RequestMethod.GET)
    public String getOrderByUsername(HttpServletRequest request, Model model) {
    	List<Order> list = orderDAO.getOrdersByUserName(securityService.findLoggedInUsername());
    	if(list.isEmpty())
    		throw new NoOrderFoundException();
    	model.addAttribute("list",list);
    	model.addAttribute("isAdmin", request.isUserInRole("ADMIN"));
        return "/ultimasViagens";
    }
    
    // Deletar pacote by CODE
    @RequestMapping({ "admin/viagensAdm/{code}" })
    public String deletarPacote(HttpServletRequest request, Model model, @PathVariable("code") String code) throws Exception {
    	if (code == null){
    		throw new Exception("Pacote não existe");
    	}else{
    		produtoDAO.deleteProduct(code);
    	}
        
        model.addAttribute("list", produtoDAO.listProducts());
        
        return "redirect:/admin/viagensAdm";
    }
    
    // Deletar order by CODE
    @RequestMapping({ "admin/pedidosAdm/{id}" })
    public String deletarPedido(HttpServletRequest request, Model model, @PathVariable("id") int orderId) throws Exception {
    	if (orderId == 0){
    		throw new Exception("Pedido não existe");
    	}else{
    		viagemOrderDAO.deleteOrder(orderId);
    	}
        
        model.addAttribute("listOrder", viagemOrderDAO.listOrders());
        
        return "redirect:/admin/pedidosAdm";
    }
    
    // Controller do novo produto ADMIN
    @RequestMapping({ "admin/novoProdutoAdd" })
    public String novoProduto(HttpServletRequest request, Model model) {
    	
    	
    	produtoDAO.saveProduct(request.getParameter("code"), request.getParameter("name"), Long.parseLong(request.getParameter("price")), Integer.parseInt(request.getParameter("quantity")), Long.parseLong(request.getParameter("product_type_id")));
        
        model.addAttribute("listOrder", viagemOrderDAO.listOrders());
        
        return "/admin/novoProduto";
    }
    
    // Controller do Botão de para cadastrar novo tipo de produto
    @RequestMapping({ "admin/novoTipoProdutoAdd" })
    public String novoTipoProduto(HttpServletRequest request, Model model) {
    	
    	
    	produtoDAO.saveProductType(null, request.getParameter("alias"), request.getParameter("description"));
        
        //model.addAttribute("listType", productTypeDao.list());
        
        return "/admin/viagensAdm";
    }
    
}
