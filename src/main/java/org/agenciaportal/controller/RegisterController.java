package org.agenciaportal.controller;

import javax.servlet.http.HttpServletRequest;

import org.agenciaportal.authentication.SecurityService;
import org.agenciaportal.dao.AccountDao;
import org.agenciaportal.entity.Account;
import org.agenciaportal.exceptions.AlreadyLoginException;
import org.agenciaportal.validator.AccountValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
	private SecurityService securityService;

	@Autowired
	private AccountValidator accountValidator;

	@InitBinder // fazer com que o Spring reconheça o validador
	public void myInitBinder(WebDataBinder dataBinder) {
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
		return "redirect:/viagens/viagensList";
	}
}
