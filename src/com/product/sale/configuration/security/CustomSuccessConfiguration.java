package com.product.sale.configuration.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.product.sale.model.Users;
import com.product.sale.service.service.UserService;

@Component
public class CustomSuccessConfiguration  extends SimpleUrlAuthenticationSuccessHandler{

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Autowired
	SessionRegistry sessionRegistry;
	
	@Autowired
	private UserService userService;
	
	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {

		String targetURL = determineTargetURL(authentication);
		setSessionUtils(request, response, authentication);

		if(response.isCommitted()){
			System.out.println("CANNOT REDIRECT");
			return;
		}
		redirectStrategy.sendRedirect(request, response, targetURL);
	}
	
	protected String determineTargetURL(Authentication authentication){
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		
		List<String> roles = new ArrayList<String>();
		
		for(GrantedAuthority authority : authorities){
			System.out.println("Hello = "+ authority.getAuthority());
			roles.add(authority.getAuthority());
		}
		if(roles.contains("ROLE_USER")){
			return "/user/";
		}else if(roles.contains("ROLE_ADMIN")){
			return "/admin/";
		}else{
			return "/access_denied";
		}
		
	}

	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}
	
    public void setSessionUtils(HttpServletRequest request, HttpServletResponse response, Authentication authentication){
    	Object principal = authentication.getPrincipal();
		HttpSession session = request.getSession();
		if (principal instanceof UserDetails){
			Users user = userService.findByEmail(((UserDetails)principal).getUsername() );
			user.setuPassWord(null);
			session.setAttribute("user", user);
			session.setMaxInactiveInterval(60*60);
		}
    }
}
