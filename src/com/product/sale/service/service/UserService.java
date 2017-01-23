package com.product.sale.service.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.product.sale.model.Users;

public interface UserService {
	public Users findByEmail(String email);
	public Users findByEmail(String email,String password);
	public Boolean CreateUserInformation(Users users);
	public Users SearchUserInformationById(Integer uId);
	public Boolean UpdateUserInformation(Users users,HttpServletRequest request);
	public Boolean DeleteUserInormation(Integer uId);
	public Boolean UpdateUserImage(Users users,HttpServletRequest request);
	public List<Users> listUser();

}
