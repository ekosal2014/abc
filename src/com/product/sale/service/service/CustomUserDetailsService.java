package com.product.sale.service.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.product.sale.enums.UserSts;
import com.product.sale.model.Users;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserService userService;
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String uEmail) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users users = userService.findByEmail(uEmail);
		if (users == null){
			throw new UsernameNotFoundException("UserName Or Password not found.");
		}
		
		return new org.springframework.security.core.userdetails.User(users.getuEmail(), users.getuPassWord(), 
                users.getuSts().equals(UserSts.ACTIVE.getValue()) || users.getuSts().equals(UserSts.INACTIVE.getValue())? true : false, true, true, true, getGrantedAuthorities(users));
		
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(Users users){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();		
		String txt = users.getuTxt().equals("0") ? "USER" : "ADMIN";
		authorities.add(new SimpleGrantedAuthority("ROLE_"+txt));
		//zSystem.out.println("Authorities = "+ authorities);
		return authorities;
	}
}
