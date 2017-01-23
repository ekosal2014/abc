package com.product.sale.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.sale.dao.dao.CategoryDao;
import com.product.sale.model.Category;
import com.product.sale.model.Users;
import com.product.sale.service.service.CategoryService;

@Service("categorySerivce")
@Transactional
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public Boolean CategoryAdd(Category category, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return categoryDao.CategoryAdd(category, request);
	}

	@Override
	public List<Category> ListCategory(Users user) {
		// TODO Auto-generated method stub
		return categoryDao.ListCategory(user);
	}

	@Override
	public Boolean CategoryDelete(int id, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return categoryDao.CategoryDelete(id, request);
	}

	@Override
	public Boolean CategoryUpdate(ArrayList<Category> list, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return categoryDao.CategoryUpdate(list, request);
	}

	@Override
	public Boolean CategoryRemove(int id, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return categoryDao.CategoryRemove(id, request);
	}

	@Override
	public Boolean CategoryUpdateName(Category category, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return categoryDao.CategoryUpdateName(category, request);
	}


	
	
}
