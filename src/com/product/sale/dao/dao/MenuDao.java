package com.product.sale.dao.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.product.sale.forms.Message;
import com.product.sale.model.Menu;
import com.product.sale.model.Users;

public interface MenuDao {
	public List<Menu> ListMenu(Users user);
	public Message MenuAdd(Menu menu,HttpServletRequest request);
	public Boolean MenuDelete(int id,HttpServletRequest request);
	public Boolean MenuRemove(int id,HttpServletRequest request);
	public Boolean MenuUpdate(ArrayList<Menu> list,HttpServletRequest request);
	public Boolean MenuUpdateName(Menu menu,HttpServletRequest request);
}
