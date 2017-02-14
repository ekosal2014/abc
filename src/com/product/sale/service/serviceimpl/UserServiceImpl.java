package com.product.sale.service.serviceimpl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.product.sale.dao.dao.UserDao;
import com.product.sale.model.Users;
import com.product.sale.service.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	

	@Autowired
	private UserDao userDao;
	
	@Override
	public Boolean CreateUserInformation(Users users) {
		// TODO Auto-generated method stub
		return userDao.CreateUserInformation(users);
	}

	@Override
	public Users SearchUserInformationById(Integer uId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean UpdateUserInformation(Users users,HttpServletRequest request) {
		// TODO Auto-generated method stub
		return userDao.UpdateUserInformation(users,request);
	}

	@Override
	public Boolean DeleteUserInormation(Integer uId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users findByEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.findByEmail(email);
	}

	@Override
	public Users findByEmail(String email, String password) {
		// TODO Auto-generated method stub
		return userDao.findByEmail(email, password);
	}

	@Override
	public Boolean UpdateUserImage(Users users,HttpServletRequest request) {
		// TODO Auto-generated method stub
		return userDao.UpdateUserImage(users,request);
	}

	@Override
	public List<Map> listUser() {
		// TODO Auto-generated method stub
		return userDao.listUser();
	}

	

}
