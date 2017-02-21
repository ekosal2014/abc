package com.product.sale.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.product.sale.model.Menu;
import com.product.sale.model.Users;
import com.product.sale.service.service.MenuService;
import com.product.sale.service.service.UserService;

@RestController(value = "/admin")
public class AdminRestController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	MenuService menuService;
   
	@RequestMapping(value="/admin/userlist/",method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Map<String,Object>> ListUser(){
		List<Map> list = userService.listUser();
		if (list.isEmpty()){
			//return new ResponseEntity<List<Users>>(HttpStatus.NO_CONTENT);
		}	
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("list", list);
		return new ResponseEntity<Map<String, Object>>(data, HttpStatus.OK);
	}
	
	@RequestMapping(value="/admin/categorylist/",method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Map<String,Object>> ListMenu(HttpServletRequest request){
		List<Map> list = menuService.ListMenu();
		if (list.isEmpty()){
			//return new ResponseEntity<List<Users>>(HttpStatus.NO_CONTENT);
		}	
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("list", list);
		return new ResponseEntity<Map<String, Object>>(data, HttpStatus.OK);
	}	
	
	@RequestMapping(value="/admin/categoryeditlist/",method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Map<String,Object>> ListEditCategory(HttpServletRequest request){
		List<Map> list = menuService.ListMenu();
		if (list.isEmpty()){
			//return new ResponseEntity<List<Users>>(HttpStatus.NO_CONTENT);
		}	
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("list", list);
		return new ResponseEntity<Map<String, Object>>(data, HttpStatus.OK);
	}	
		
}
