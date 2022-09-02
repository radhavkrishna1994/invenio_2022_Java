package com.springproject.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfiguration  extends WebSecurityConfigurerAdapter{
	
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.inMemoryAuthentication().withUser("tomcat").password("abcd").roles("users","admin");
	}
	
	protected void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests().antMatchers("/login").permitAll().antMatchers("/").access("hasRole('users')").and().formLogin();
	}

}
