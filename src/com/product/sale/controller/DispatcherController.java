package com.product.sale.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.product.sale.model.Users;
import com.product.sale.service.service.UserService;

@Controller
public class DispatcherController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView dispatcherLogin(){
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String dispatcherLogOut(HttpServletRequest request, HttpServletResponse respone){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){
			new SecurityContextLogoutHandler().logout(request, respone, auth);
		}
		return "redirect:/";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView dispatcherRegister(){
		return new ModelAndView("register");
	}
	
	@RequestMapping(value="/register-step-1", method=RequestMethod.POST)	
	public @ResponseBody String dispatcherRegisterStep1(@ModelAttribute Users users){		
		return userService.CreateUserInformation(users) == false ? "False":"True";
		
	}
	
	@RequestMapping(value="/Access_Denied", method = RequestMethod.GET)
	public String dispatcherAccessDenied(){
		return "login";
	}
	
	
	
	
}
