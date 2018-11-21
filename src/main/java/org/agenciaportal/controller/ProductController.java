package org.agenciaportal.controller;

import java.sql.Date;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
//Enable Hibernate Transaction.
@Transactional
//Need to use RedirectAttributes
@EnableWebMvc
public class ProductController {
	
	public static Logger logger = Logger.getLogger(MainController.class);
	
	@Autowired
    private ProductDao viagensDAO;
	@Autowired
    private ProductOrderDao viagemOrderDAO;
	@Autowired
    private SecurityService securityService;
	@Autowired
    private ProductOrderDao orderDAO;
	@Autowired
	private ProductTypeDao productTypeDao; 
	
	
	// Product List page.
    @RequestMapping({ "/viagensList/{typeId}" })
    public String listViagensHandler(HttpServletRequest request, Model model, @PathVariable("typeId") Long typeId) {
        model.addAttribute("list",viagensDAO.getAllProductsByType(typeId));
        model.addAttribute("isAdmin", request.isUserInRole("ADMIN"));
        return "/viagensList";
    }
    
    // Product List page.
    @RequestMapping({ "/viagens/{alias}" })
    public String listViagensHandler(HttpServletRequest request, Model model, @PathVariable("alias") String alias) {
        model.addAttribute("list",viagensDAO.getAllProductsByAlias(alias));
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
            product = viagensDAO.findProduct(code);
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
    public String purchaseProduct(HttpServletRequest request, Model model, @Validated Product product) {
    	String code = request.getParameter("code");
    	String productType = request.getParameter("type");
    	int quantity =Integer.parseInt( request.getParameter("quantity"));
    	@SuppressWarnings("deprecation")
		Long godate = Date.parse(request.getParameter("goDate"));
    	@SuppressWarnings("deprecation")
		Long backdate = Date.parse(request.getParameter("backDate"));
    	Date ida = new Date(godate);
    	Date volta = new Date(backdate);
    	
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
    		viagensDAO.deleteProduct(code);
    	}
        
        model.addAttribute("list", viagensDAO.listProducts());
        
        return "redirect:/admin/viagensAdm";
    }

}
