package org.agenciaportal.controller;

import javax.servlet.http.HttpServletRequest;

import org.agenciaportal.exceptions.AlreadyLoginException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
//Enable Hibernate Transaction.
@Transactional
//Need to use RedirectAttributes
@EnableWebMvc
public class LoginController {
	
	public static Logger logger = Logger.getLogger(MainController.class);
	
	@RequestMapping("/403")
    public String accessDenied(HttpServletRequest request) {
    	        logger.error("Acesso Negado URL ="+request.getRequestURL());
        return "/403";
    }
    
    // GET: Show Login Page
    @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
    public String login(HttpServletRequest request) {
    	if(request.getUserPrincipal() != null)
    		throw new AlreadyLoginException();
        return "login";
    }
}
