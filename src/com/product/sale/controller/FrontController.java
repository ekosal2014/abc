package com.product.sale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FrontController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView saleHomePage(){
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/{user}/{temp}/", method = RequestMethod.GET)
	public ModelAndView saleNewFolder(@PathVariable("user") String user,@PathVariable("temp") String temp){
		System.out.println("User = "+ user + " Templete = " + temp);
		return new ModelAndView("index");
	}
}
