package org.agenciaportal.controller;

import javax.servlet.http.HttpServletRequest;

import org.agenciaportal.dao.AccountDao;
import org.agenciaportal.dao.ProductDao;
import org.agenciaportal.dao.ProductOrderDao;
import org.agenciaportal.dao.ProductTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
// Enable Hibernate Transaction.
@Transactional
// Need to use RedirectAttributes
@EnableWebMvc
public class AdminController {

	@Autowired
    private ProductDao viagensDAO;
	
	@Autowired
    private AccountDao accountDAO;
	
	@Autowired
	private ProductTypeDao productTypeDao; 
	
	@Autowired
	private ProductOrderDao productOrderDao;
	

	@RequestMapping({ "admin/homeadmin" })
	public String adminHandler(HttpServletRequest request, Model model) {
		model.addAttribute("isAdmin", request.isUserInRole("ADMIN"));
		model.addAttribute("ListUsers", accountDAO.listUsers());
		model.addAttribute("qtdUsers", accountDAO.listUsers().size());
		model.addAttribute("qtdProducts", viagensDAO.listProducts().size());
		model.addAttribute("qtdOrders", productOrderDao.listOrders().size());
		return "admin/homeadmin";
	}
	
	@RequestMapping({ "admin/usersAdm" })
	public String adminUsers(HttpServletRequest request, Model model) {
		model.addAttribute("isAdmin", request.isUserInRole("ADMIN"));
		model.addAttribute("ListUsers", accountDAO.listUsers());
		model.addAttribute("qtdUsers", accountDAO.listUsers().size());
		return "admin/usersAdm";
	}

//	 // Product List page.
//    @RequestMapping({ "/viagensAdmList" })
//    public String listViagensHandler(Model model) {
//        model.addAttribute("produtosList", viagensDAO.listProducts());
//        return "admin/viagensAdmList";
//    }
    
    @RequestMapping({ "admin/{alias}" })
    public String listViagensAdm(Model model, @PathVariable("alias") String alias) {
        model.addAttribute("list",viagensDAO.getAllProductsByAlias(alias));
        model.addAttribute("productType", productTypeDao.getByAlias(alias));
        return "admin/viagensAdmList";
    }
}
