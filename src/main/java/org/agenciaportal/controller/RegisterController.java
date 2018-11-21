package org.agenciaportal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.agenciaportal.authentication.SecurityService;
import org.agenciaportal.dao.AccountDao;
import org.agenciaportal.dao.RoleDao;
import org.agenciaportal.entity.Account;
import org.agenciaportal.entity.Role;
import org.agenciaportal.exceptions.AlreadyLoginException;
import org.agenciaportal.validator.AccountValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
// Enable Hibernate Transaction.
@Transactional
// Need to use RedirectAttributes
@EnableWebMvc
public class RegisterController {

	public static Logger logger = Logger.getLogger(MainController.class);

	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private RoleDao roleDao;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private AccountValidator accountValidator;

	@InitBinder // fazer com que o Spring reconheça o validador
	public void myInitBinder(WebDataBinder dataBinder) {
		
		// Metodo responsavel por adicionar a role no request do novo usuario
		CustomCollectionEditor rolesCollector = new CustomCollectionEditor(List.class) {
            @Override
            protected Object convertElement(Object element) {
                if (element instanceof String) {
                    Long id = Long.parseLong((String) element);

                    Role role = new Role();
                    role.setId(id);
                    return role;
                }
                throw new RuntimeException("Spring says: Não sei o que fazer com esse elemento: " + element);
            }
        };

        dataBinder.registerCustomEditor(List.class, "roles", rolesCollector);
        
		Object target = dataBinder.getTarget();
		if (target == null) {
			return;
		}
		if (logger.isDebugEnabled())
			logger.debug("Target =" + target);

		if (target.getClass() == Account.class)
			dataBinder.setValidator(accountValidator);

	}

	// GET: Show Sign Up Page
	@RequestMapping(value = { "/signUp" }, method = RequestMethod.GET)
	public String signUpForm(Model model, HttpServletRequest request) {
		if (request.getUserPrincipal() != null)
			throw new AlreadyLoginException();
		model.addAttribute("account", new Account());
		return "signUp";
	}

	@RequestMapping(value = { "/signUp" }, method = RequestMethod.POST)
	public String signUpFormProcess(@Validated Account account, BindingResult bindingResult,
			HttpServletRequest request) {
		if (request.getUserPrincipal() != null)
			throw new AlreadyLoginException();

		if (bindingResult.hasErrors()) {
			return "signUp";
		}
		String password = account.getPassword();
		accountDao.saveAccount(account);
		securityService.autologin(account.getUserName(), password);
		return "redirect:/home";
	}
	
	// Registro na seção ADMINISTRATIVA GET
	
	@RequestMapping(value = { "admin/novoUsuario" }, method = RequestMethod.GET)
	public String signUpFormAdm(Model model) {
		model.addAttribute("account", new Account());
		
		model.addAttribute("listRole", roleDao.findRoleAll());

		return "admin/novoUsuario";
	}
	
	// Registro na seção ADMINISTRATIVA POST
	@RequestMapping(value = { "admin/novoUsuario" }, method = RequestMethod.POST)
	public String signUpFormProcessAdm(@Validated Account account, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "admin/novoUsuario";
		}
		
		accountDao.saveAccountAdm(account);
		return "redirect:/admin/usersAdm";
	}
	
	// Deletar usuario by ID
    @RequestMapping({ "admin/usersAdm/{userId}" })
    public String deletarUsuario(HttpServletRequest request, Model model, @PathVariable("userId") Long userId) throws Exception {
    	if (userId == null){
    		throw new Exception("Usuário não existe");
    	}else{
    		accountDao.deleteUser(userId);
    	}
        
        model.addAttribute("list", accountDao.listUsers());
        
        return "redirect:/admin/usersAdm";
    }
}
