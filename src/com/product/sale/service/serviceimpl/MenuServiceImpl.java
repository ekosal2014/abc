package com.product.sale.service.serviceimpl;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.sale.dao.dao.MenuDao;
import com.product.sale.forms.Message;
import com.product.sale.model.Menu;
import com.product.sale.model.Users;
import com.product.sale.service.service.MenuService;

@Service("menuSerivce")
@Transactional
public class MenuServiceImpl implements MenuService{

	@Autowired 
	private MenuDao menuDao;
	
	@Override
	public List<Menu> ListMenu(Users user) {
		// TODO Auto-generated method stub
		return menuDao.ListMenu(user);
	}

	@Override
	public Message MenuAdd(Menu menu, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return menuDao.MenuAdd(menu, request);
	}

	@Override
	public Boolean MenuDelete(int id, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return menuDao.MenuDelete(id, request);
	}

	@Override
	public Boolean MenuRemove(int id, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return menuDao.MenuRemove(id, request);
	}

	@Override
	public Boolean MenuUpdate(ArrayList<Menu> list, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return menuDao.MenuUpdate(list, request);
	}

	@Override
	public Boolean MenuUpdateName(Menu menu, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return menuDao.MenuUpdateName(menu, request);
	}

}
