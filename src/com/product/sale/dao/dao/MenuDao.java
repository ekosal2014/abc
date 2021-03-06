package com.product.sale.dao.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.product.sale.forms.Message;
import com.product.sale.model.Menu;
import com.product.sale.model.Users;

public interface MenuDao {
	public List<Menu> ListMenu(Users user);
	public List<Map> ListMenu();
	public Message MenuAdd(Menu menu,HttpServletRequest request);
	public Message MenuDelete(int id,HttpServletRequest request);
	public Message MenuRemove(int id,HttpServletRequest request);
	public Message MenuUpdate(ArrayList<Menu> list,HttpServletRequest request);
	public Message MenuUpdateName(Menu menu,HttpServletRequest request);
}
