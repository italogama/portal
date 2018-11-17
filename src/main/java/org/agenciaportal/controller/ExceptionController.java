package org.agenciaportal.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.agenciaportal.exceptions.AlreadyLoginException;
import org.agenciaportal.exceptions.NoOrderFoundException;
import org.agenciaportal.exceptions.ProductOutOfStockException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(NoHandlerFoundException.class)
	public String pageNotFoundHandler(HttpServletRequest request,Model model, Exception ex)
	{
		System.out.println("requested url ="+request.getRequestURL());
		System.out.println("Exception ="+ex.getMessage());
		model.addAttribute("isAdmin", request.isUserInRole("ADMIN"));
		return "404";
	}
	
	@ExceptionHandler(ProductOutOfStockException.class)
	public String productOutOfStock(ProductOutOfStockException ex, HttpServletRequest request, Model model)
	{
		model.addAttribute("isAdmin", request.isUserInRole("ADMIN"));
		return "outOfStock";
	}
	
	@ExceptionHandler(NoOrderFoundException.class)
	public String noOrderFound(NoOrderFoundException ex, HttpServletRequest request, Model model)
	{
		model.addAttribute("isAdmin", request.isUserInRole("ADMIN"));
		return "noOrder";
	}
	
	@ExceptionHandler(AlreadyLoginException.class)
	public String AlreadyLogin(AlreadyLoginException ex)
	{
		return "redirect:/viagensList";
	}
	
	@ExceptionHandler(SQLException.class)
	public String internalServerProblem(SQLException ex, HttpServletRequest request, Model model)
	{
		model.addAttribute("isAdmin", request.isUserInRole("ADMIN"));
		return "serverError";
	}
}
