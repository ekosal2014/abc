package com.product.sale.service.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.product.sale.model.Menu;
import com.product.sale.model.Users;

public interface MenuService {
	public List<Menu> ListMenu(Users user);
	public Boolean MenuAdd(Menu menu,HttpServletRequest request);
	public Boolean MenuDelete(int id,HttpServletRequest request);
	public Boolean MenuRemove(int id,HttpServletRequest request);
	public Boolean MenuUpdate(ArrayList<Menu> list,HttpServletRequest request);
	public Boolean MenuUpdateName(Menu menu,HttpServletRequest request);
}
