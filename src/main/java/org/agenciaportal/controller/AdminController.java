package org.agenciaportal.controller;

import javax.servlet.http.HttpServletRequest;

import org.agenciaportal.dao.AccountDao;
import org.agenciaportal.dao.ProductDao;
import org.agenciaportal.dao.ProductOrderDao;
import org.agenciaportal.dao.ProductTypeDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@Transactional
@EnableWebMvc
public class AdminController {
	
	public static Logger logger = Logger.getLogger(MainController.class);
	
	@Autowired
    private ProductDao viagensDAO;
	
	@Autowired
    private AccountDao accountDAO;
	
	@Autowired
	private ProductTypeDao productTypeDao; 
	
	@Autowired
	private ProductOrderDao productOrderDao;
	
	// HOME PAGE ADMIN
	@RequestMapping({ "admin/homeadmin" })
	public String adminHandler(HttpServletRequest request, Model model) {
		model.addAttribute("isAdmin", request.isUserInRole("ADMIN"));
		model.addAttribute("ListUsers", accountDAO.listUsers());
		model.addAttribute("qtdUsers", accountDAO.listUsers().size());
		model.addAttribute("qtdProducts", viagensDAO.listProducts().size());
		model.addAttribute("qtdOrders", productOrderDao.listOrders().size());
		return "admin/homeadmin";
	}
	
	// Users ADM LIST
	@RequestMapping({ "admin/usersAdm" })
	public String adminUsers(HttpServletRequest request, Model model) {
		model.addAttribute("isAdmin", request.isUserInRole("ADMIN"));
		model.addAttribute("ListUsers", accountDAO.listUsers());
		model.addAttribute("qtdUsers", accountDAO.listUsers().size());
		return "admin/usersAdm";
	}
	
	// Exibir VIEW de cadastrar Novo Produto
    @RequestMapping({ "admin/novoProduto" })
    public String adminProduto(HttpServletRequest request, Model model) {
        return "admin/novoProduto";
    }
    
    // Exibir VIEW de cadastrar novo tipo de produto
    @RequestMapping({ "admin/novoTipoProduto" })
    public String adminNovoTipoProduto(HttpServletRequest request, Model model) {
        return "admin/novoTipoProduto";
    }
    
    @RequestMapping(value = { "admin/{code}" }, method = RequestMethod.GET)
    public String adminEditarProduto(HttpServletRequest request, @PathVariable("code") String code, Model model) {
    	model.addAttribute("isAdmin", request.isUserInRole("ADMIN"));
    	model.addAttribute("editarProduto", viagensDAO.findProduct(code));
    	
        return "admin/editarProduto";
    }
	
	 // TODAS Viagens List page.
    @RequestMapping({ "admin/viagensAdm" })
    public String listViagensHandler(HttpServletRequest request, Model model) {
    	model.addAttribute("isAdmin", request.isUserInRole("ADMIN"));
        model.addAttribute("list", viagensDAO.listProducts());
        return "admin/viagensAdm";
    }
    
    
    // Viagens List POR ALIAS
    @RequestMapping({ "admin/{alias}" })
    public String listViagensAdm(Model model, @PathVariable("alias") String alias) {
        model.addAttribute("list",viagensDAO.getAllProductsByAlias(alias));
        model.addAttribute("productType", productTypeDao.getByAlias(alias));
        return "admin/viagensAdm";
    }
    
    // Pedidos List POR ALIAS
    @RequestMapping({ "admin/pedidosAdm" })
    public String listViagensAdm(HttpServletRequest request, Model model) {
    	model.addAttribute("isAdmin", request.isUserInRole("ADMIN"));
        model.addAttribute("listOrder", productOrderDao.listOrders());
        return "admin/pedidosAdm";
    }
    
    
}
