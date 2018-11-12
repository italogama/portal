package org.agenciaportal.controller;

import javax.servlet.http.HttpServletRequest;

import org.agenciaportal.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
// Enable Hibernate Transaction.
@Transactional
// Need to use RedirectAttributes
@EnableWebMvc
public class AdminController {

	@Autowired
    private ProductDao viagensDAO;
	
	

	@RequestMapping({ "/homeadmin" })
	public String adminHandler(HttpServletRequest request, Model model) {
		model.addAttribute("isAdmin", request.isUserInRole("ADMIN"));
		return "admin/homeadmin";
	}

	 // Product List page.
    @RequestMapping(value = "/viagensAdmList}")
    public String listViagensHandler(Model model, @RequestParam(value = "code", defaultValue = "") String code ) {
        model.addAttribute("code",viagensDAO.findProduct(code));
        return "admin/viagensAdmList";
    }
}