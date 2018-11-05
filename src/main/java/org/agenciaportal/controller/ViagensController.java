package org.agenciaportal.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.agenciaportal.authentication.SecurityService;
import org.agenciaportal.dao.ViagemDao;
import org.agenciaportal.dao.ViagemOrderDao;
import org.agenciaportal.entity.ViagemOrder;
import org.agenciaportal.entity.Viagens;
import org.agenciaportal.exceptions.NoOrderFoundException;
import org.agenciaportal.exceptions.ProductOutOfStockException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
//Enable Hibernate Transaction.
@Transactional
//Need to use RedirectAttributes
@EnableWebMvc
public class ViagensController {
	
	public static Logger logger = Logger.getLogger(MainController.class);
	
	@Autowired
    private ViagemDao viagensDAO;
	
	@Autowired
    private ViagemOrderDao viagemOrderDAO;
	
	@Autowired
    private SecurityService securityService;
	
	@Autowired
    private ViagemOrderDao orderDAO;
	
	// Product List page.
    @RequestMapping({ "/viagensList" })
    public String listViagensHandler(Model model
          ) {
        model.addAttribute("list",viagensDAO.getAllProducts());
        return "viagens/viagensList";
    }
    
    @RequestMapping({ "/buyProduct" })
    public String buyProduct(HttpServletRequest request, Model model, //
            @RequestParam(value = "code", defaultValue = "") String code) {
    	if(code.isEmpty())
    	{
    		return "redirect:viagens/viagensList";
    	}
    	
        Viagens product = null;
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
        return "viagens/confirmation";
    }
    
    @RequestMapping(value = { "/purchase" }, method = RequestMethod.POST)
    // Avoid UnexpectedRollbackException
    @Transactional(propagation = Propagation.NEVER)
    public String purchaseProduct(HttpServletRequest request, Model model) {
    	String code = request.getParameter("code");
    	int quantity =Integer.parseInt( request.getParameter("quantity"));
    	@SuppressWarnings("deprecation")
		Long godate = Date.parse(request.getParameter("goDate"));
    	@SuppressWarnings("deprecation")
		Long backdate = Date.parse(request.getParameter("backDate"));
    	Date x = new Date(godate);
    	Date x2 = new Date(backdate);
    	
    	ViagemOrder order = viagemOrderDAO.saveOrder(code, quantity, x, x2, securityService.findLoggedInUsername());
    	model.addAttribute("order",order);
    	 if(logger.isInfoEnabled())
    	        logger.info("Product purchased having code "+code+", quantity "+quantity);
        return "viagens/orderDetail";
    }
    
    @RequestMapping(value = { "/ultimasViagens" }, method = RequestMethod.GET)
    public String getOrderByUsername(HttpServletRequest request, Model model) {
    	List<ViagemOrder> list = orderDAO.getOrdersByUserName(securityService.findLoggedInUsername());
    	if(list.isEmpty())
    		throw new NoOrderFoundException();
    	model.addAttribute("list",list);
        return "viagens/ultimasViagens";
    }

}
