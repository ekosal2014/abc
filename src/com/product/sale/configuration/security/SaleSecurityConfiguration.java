package com.product.sale.configuration.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SaleSecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsService;
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	CustomSuccessConfiguration customSuccessConfirguation;
	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService);
		auth.authenticationProvider(authenticaticationProvider());
	}
	
	/*@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
		auth.jdbcAuthentication().dataSource(dataSource)
		    .usersByUsernameQuery("SELECT U_EMAIL,U_PASSWORD,U_TXT,U_STS FROM tbl_user WHERE U_EMAIL=?")
		    .authoritiesByUsernameQuery("");
	}
	*/
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
		    .antMatchers("/").permitAll()
		    .antMatchers("/admin/**").access("hasRole('ADMIN')")
		    .antMatchers("/user/**").access("hasRole('USER')")
		    .and().formLogin().loginPage("/login")
		          .successHandler(customSuccessConfirguation)
		          .usernameParameter("uEmail").passwordParameter("uPassWord")		    
		    .and().exceptionHandling().accessDeniedPage("/Access_Denied")
		    .and()
		    	  .sessionManagement()
		    	  .sessionAuthenticationErrorUrl("/login")
		    	  .sessionFixation()
		    	  .changeSessionId()
		    	  .maximumSessions(10)
		    	  .maxSessionsPreventsLogin(true)
		    	  .expiredUrl("/login/maxSessions")
		    	  .sessionRegistry(sessionRegistryImpl()) // when login it create one session already
		    .and()
		    .and()
	            .logout()
	            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	            .logoutSuccessUrl("/")
	            .permitAll()
		    .and().csrf()
		          .disable();
		

	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){		
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticaticationProvider(){
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}
	
	@Bean(name="sessionRegistry")
    protected SessionRegistry sessionRegistryImpl()
    {
        return new SessionRegistryImpl();
    }
}
