package com.product.sale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("admin")
public class AdminController {
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView adminHomePage(){
		return new ModelAndView("admin/index");
	}
	
	@RequestMapping(value="/user", method = RequestMethod.GET)
	public ModelAndView adminUserPage(){
		return new ModelAndView("/admin/user");
	}
	
	@RequestMapping(value="/categetoryinfo", method = RequestMethod.GET)
	public ModelAndView adminCategoryPag(){
		return new ModelAndView("/admin/user");
	}
	
	@RequestMapping(value="/productinfo", method = RequestMethod.GET)
	public ModelAndView adminProductPag(){
		return new ModelAndView("/admin/user");
	}

}
