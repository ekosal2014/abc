package com.product.sale.dao.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import com.product.sale.model.Category;
import com.product.sale.model.Users;

public interface CategoryDao {
	public List<Category> ListCategory(Users user);
	public Boolean CategoryAdd(Category category,HttpServletRequest requesst);
	public Boolean CategoryDelete(int id,HttpServletRequest request);
	public Boolean CategoryRemove(int id,HttpServletRequest request);
	public Boolean CategoryUpdate(ArrayList<Category> list,HttpServletRequest request);
	public Boolean CategoryUpdateName(Category category,HttpServletRequest request);
}
