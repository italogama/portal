package org.agenciaportal.controller;

import javax.servlet.http.HttpServletRequest;

import org.agenciaportal.dao.ProductTypeDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.google.gson.GsonBuilder;



@Controller
//Enable Hibernate Transaction.
@Transactional
//Need to use RedirectAttributes
@EnableWebMvc
public class MainController {

	public static Logger logger = Logger.getLogger(MainController.class);
	
	 @Autowired
	 private ProductTypeDao productDAO;
 
    // Request HOME without logon
    
    @RequestMapping({ "/home", "/" })
    public String testeHandler(HttpServletRequest request, Model model) {
    	model.addAttribute("isAdmin", request.isUserInRole("ADMIN"));
        return "home";
    }
    
    @RequestMapping(value = "/menu", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String listarMenu() {
    	return new GsonBuilder().create().toJson(productDAO.list());
    }
    
    @RequestMapping({ "/profile" })
    public String profilePage(HttpServletRequest request, Model model) {
    	model.addAttribute("isAdmin", request.isUserInRole("ADMIN"));
        return "/profile";
    }
}
