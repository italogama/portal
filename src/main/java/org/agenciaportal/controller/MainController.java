package org.agenciaportal.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;



@Controller
//Enable Hibernate Transaction.
@Transactional
//Need to use RedirectAttributes
@EnableWebMvc
public class MainController {

	public static Logger logger = Logger.getLogger(MainController.class);
	
 
    // Request HOME without logon
    
    @RequestMapping({ "/home", "/" })
    public String testeHandler(HttpServletRequest request, Model model) {
    	model.addAttribute("isAdmin", request.isUserInRole("ADMIN"));
        return "home";
    }
    
}
