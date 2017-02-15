package com.product.sale.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.product.sale.model.Users;
import com.product.sale.service.service.UserService;

@RestController(value = "/admin")
public class AdminRestController {
	
	@Autowired
	UserService userService;
   
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
}
