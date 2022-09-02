package com.training.webdemosjava;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

// in place of spring-servlet.xml
@ComponentScan("com.training.webdemosjava")
@EnableWebMvc
public class MyConfiguration extends WebMvcConfigurerAdapter {
	
	  @Override 
	  public void  configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		  configurer.enable(); }


}
