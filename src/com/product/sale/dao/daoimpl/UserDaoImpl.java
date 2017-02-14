package com.product.sale.dao.daoimpl;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.product.sale.dao.dao.UserDao;
import com.product.sale.enums.UserSts;
import com.product.sale.enums.UserType;
import com.product.sale.model.Users;
import com.product.sale.utils.StringUtils;

@Repository("userDao")
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Boolean CreateUserInformation(Users users) {
		// TODO Auto-generated method stub
		
		try{			
			if (users.getuTxt() == "" || users.getuTxt() == null) users.setuTxt(UserType.USER.getValue());
			if (users.getuSts() == "" || users.getuSts() == null) users.setuSts(UserSts.INACTIVE.getValue());
			users.setuPassWord(passwordEncoder.encode(users.getuPassWord()));
			users.setUlogindt(StringUtils.getCurrentDate());
			sessionFactory.getCurrentSession().save(users);
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Users SearchUserInformationById(Integer uId) {
		// TODO Auto-generated method stub
		try{
			return (Users) sessionFactory.getCurrentSession().get(Users.class, uId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
		
	}

	@Override
	public Boolean UpdateUserInformation(Users users,HttpServletRequest request) {
		// TODO Auto-generated method stub
		try{
			Users user = (Users)sessionFactory.getCurrentSession().get(Users.class, users.getuId());
			user.setuFirstName(users.getuFirstName());
			user.setuLastName(users.getuLastName());
			user.setuGender(users.getuGender());
			user.setuPhone(users.getuPhone());
			user.setuAddress(users.getuAddress());
			user.setuFaceBook(users.getuFaceBook());
			user.setuTwitter(users.getuTwitter());
			user.setuGooglePlus(users.getuGooglePlus());
			user.setuSkype(users.getuSkype());
			user.setuSts("1");
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			request.getSession().setAttribute("user", user);
			request.getSession().setMaxInactiveInterval(60*60);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean DeleteUserInormation(Integer uId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users findByEmail(String email) {
		// TODO Auto-generated method stub
		try{
		    Users users = (Users)sessionFactory.getCurrentSession().createCriteria(Users.class)
		    													.add(Restrictions.eq("uEmail", email))
		    													.uniqueResult();
		    return users;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Users findByEmail(String email, String password) {
		// TODO Auto-generated method stub
		try{
			System.out.println("kosa "+ email + " " + password);
		    Users users = (Users)sessionFactory.getCurrentSession().createCriteria(Users.class)
		    													.add(Restrictions.eq("uEmail", email))
		    													.add(Restrictions.eq("uPassWord", password))
		    													.uniqueResult();
		    return users;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean UpdateUserImage(Users users,HttpServletRequest request) {
		// TODO Auto-generated method stub
		try{
			Users user = (Users)sessionFactory.getCurrentSession().get(Users.class, users.getuId());
			user.setImageName(users.getImageName());
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			request.getSession().setAttribute("user", user);
			request.getSession().setMaxInactiveInterval(60*60);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Map> listUser() {
		Session session = null;
		try{
			
			session = sessionFactory.openSession();
			Query query = session.createQuery("SELECT new Map(u.uId as U_ID,u.uFirstName || ' ' || u.uLastName as Name  "+
											  ", u.uGender, u.uPhone as U_PHONE, u.uEmail as Email, trim(u.uAddress) as Address )"+
			                                  " FROM Users u ");
			List<Map> list = query.list();
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

}
