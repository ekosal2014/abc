package com.product.sale.dao.daoimpl;

import java.util.ArrayList;
import java.util.List;


import javax.servlet.http.HttpServletRequest;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.product.sale.dao.dao.CategoryDao;
import com.product.sale.model.Category;
import com.product.sale.model.Users;

@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unused")
	@Override
	public Boolean CategoryAdd(Category category,HttpServletRequest request) {
		// TODO Auto-generated method stub
		Session session = null;
		try{			
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			Users user = (Users) request.getSession().getAttribute("user");
			Category categorys = (Category) session.createCriteria(Category.class)
											.add(Restrictions.eq("cateName", category.getCateName()))
											.add(Restrictions.eq("user", user)).uniqueResult();
			
			if (categorys != null){
				return false;
			}				
			category.setSts("0");
			category.setCateParents(0);
			session.save(category);		
			session.getTransaction().commit();
     		return true;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			//session.close();
		}
		return null;
	}

	/*private Users getAllPrincipal(HttpServletRequest request){
		Users user = new Users();
		try{		
			user = (Users) request.getAttribute("user");
		}catch( Exception e){
			e.printStackTrace();
		}
		return user;
	}*/

	@Override
	@SuppressWarnings("unchecked")
	public List<Category> ListCategory(Users user) {
		// TODO Auto-generated method stub
		Session session = null;
		try{
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			//Query query = session.createQuery("FROM CategoryUser where");		
			List<Category> list = session.createCriteria(Category.class)
											 .add(Restrictions.eq("user", user))
											 .list();
			session.getTransaction().commit();
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			session.close();
		}	
		return null;
	}

	@Override
	public Boolean CategoryDelete(int id, HttpServletRequest request) {
		// TODO Auto-generated method stub
		Session session = null;
		try{
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			Users user = (Users) request.getSession().getAttribute("user");
			Query query = session.createQuery("Delete from CategoryUser WHERE (cateId = :cid or cateParents = :pid) and U_ID = :uid");
			query.setParameter("cid", id);
			query.setParameter("pid",id);
			query.setParameter("uid", user.getuId());
			if (query.executeUpdate()>0){
				session.getTransaction().commit();
				return true;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return false;
	}

	@Override
	public Boolean CategoryUpdate(ArrayList<Category> list, HttpServletRequest request) {
		// TODO Auto-generated method stub
		Session session = null;
		try{
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			for( Category category : list ){
				Category categorydb = (Category)session.get(Category.class, category.getCateId());
				if (categorydb != null){
					categorydb.setCateParents(category.getCateParents());
					categorydb.setSts("1");
					session.saveOrUpdate(categorydb);
				}
			}
			session.getTransaction().commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean CategoryRemove(int id, HttpServletRequest request) {
		// TODO Auto-generated method stub
		Session session = null;
		try{
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			Category categorydb = (Category)session.get(Category.class, id);
			if (categorydb != null){
				categorydb.setSts("0");
				session.saveOrUpdate(categorydb);
			}
			session.getTransaction().commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean CategoryUpdateName(Category category, HttpServletRequest request) {
		// TODO Auto-generated method stub
		Session session = null;
		try{
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			Category categorydb = (Category)session.get(Category.class, category.getCateId());
			if (categorydb != null){
				categorydb.setCateName(category.getCateName().trim());
				session.saveOrUpdate(categorydb);
			}
			session.getTransaction().commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	
}
