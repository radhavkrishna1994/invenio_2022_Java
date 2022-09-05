package com.training.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
	
	@Value("${message}")
	private String message;

	public String getMessage() {
		return message;
	}
	
	

}
