package com.product.sale.service.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.product.sale.forms.Message;
import com.product.sale.model.Menu;
import com.product.sale.model.Users;

public interface MenuService {
	public List<Menu> ListMenu(Users user);
	public Message MenuAdd(Menu menu,HttpServletRequest request);
	public Message MenuDelete(int id,HttpServletRequest request);
	public Message MenuRemove(int id,HttpServletRequest request);
	public Boolean MenuUpdate(ArrayList<Menu> list,HttpServletRequest request);
	public Boolean MenuUpdateName(Menu menu,HttpServletRequest request);
}
