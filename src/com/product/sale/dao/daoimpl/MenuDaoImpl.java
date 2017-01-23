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

import com.product.sale.dao.dao.MenuDao;
import com.product.sale.forms.Message;
import com.product.sale.model.Menu;
import com.product.sale.model.Users;

@Repository("menuDao")
public class MenuDaoImpl implements MenuDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Menu> ListMenu(Users user) {
		// TODO Auto-generated method stub
		Session session = null;
		try{
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			//Query query = session.createQuery("FROM MenuUser where");				
			List<Menu> list = session.createCriteria(Menu.class)
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
	public Message MenuAdd(Menu menu, HttpServletRequest request) {
		// TODO Auto-generated method stub
		Session session = null;
		Message msg = new Message();
		try{			
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			Users user = (Users) request.getSession().getAttribute("user");
			Menu menus = (Menu) session.createCriteria(Menu.class)
											.add(Restrictions.eq("menuName", menu.getMenuName()))
											.add(Restrictions.eq("user", user)).uniqueResult();
			
			if (menus != null){
				msg.setCode("0000");
				msg.setMsg("Menu Item Duplicated.");
				return msg;
			}				
			menu.setSts("0");
			menu.setMenuParents(0);
			session.save(menu);		
			session.getTransaction().commit();
			msg.setCode("0000");
			msg.setMsg("Menu Item Insert Completed");
     		return msg;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			//session.close();
		}
		msg.setCode("9999");
		msg.setMsg("Menu Item Insert failed");
		return null;
	}

	@Override
	public Message MenuDelete(int id, HttpServletRequest request) {
		// TODO Auto-generated method stub
		Session session = null;
		Message msg = new Message();
		try{
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			Users user = (Users) request.getSession().getAttribute("user");
			Query query = session.createQuery("Delete from Menu WHERE (menuId = :cid or menuParents = :pid) and U_ID = :uid");
			query.setParameter("cid", id);
			query.setParameter("pid",id);
			query.setParameter("uid", user.getuId());
			if (query.executeUpdate()>0){
				session.getTransaction().commit();
				msg.setCode("0000");
				msg.setMsg("Remove Item Completed");
				return msg;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		msg.setCode("9999");
		msg.setMsg("Remove Item Failed");
		return msg;
	}

	@Override
	public Message MenuRemove(int id, HttpServletRequest request) {
		// TODO Auto-generated method stub
		Session session = null;
		Message msg = new Message();
		try{
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			Menu menudb = (Menu)session.get(Menu.class, id);
			if (menudb != null){
				menudb.setSts("0");
				session.saveOrUpdate(menudb);
			}
			session.getTransaction().commit();
			msg.setCode("0000");
			msg.setMsg("Remove Item Completed");
			return msg;
		}catch(Exception e){
			e.printStackTrace();
		}
		msg.setCode("9999");
		msg.setMsg("Remove Item Failed");
		return msg;
	}

	@Override
	public Boolean MenuUpdate(ArrayList<Menu> list, HttpServletRequest request) {
		// TODO Auto-generated method stub
		Session session = null;
		try{
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			for( Menu menu : list ){
				Menu menudb = (Menu)session.get(Menu.class, menu.getMenuId());
				if (menudb != null){
					menudb.setMenuParents(menu.getMenuParents());
					menudb.setSts("1");
					session.saveOrUpdate(menudb);
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
	public Boolean MenuUpdateName(Menu menu, HttpServletRequest request) {
		// TODO Auto-generated method stub
		Session session = null;
		try{
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			Users user = (Users) request.getSession().getAttribute("user");
			Menu menudb = (Menu)session.get(Menu.class, menu.getMenuId());
			if (menudb != null){
				Menu menus = (Menu) session.createCriteria(Menu.class)
						.add(Restrictions.eq("menuName", menu.getMenuName()))
						.add(Restrictions.eq("user", user)).uniqueResult();

				if (menus != null){
				return false;
				}				
				menudb.setMenuName(menu.getMenuName().trim());
				session.saveOrUpdate(menudb);
			}else{
				return false;
			}
			session.getTransaction().commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

}
