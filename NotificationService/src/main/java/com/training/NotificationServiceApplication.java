package com.training;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RefreshScope
@RestController
@SpringBootApplication
public class NotificationServiceApplication  {

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}
	
	@Value("${message}")
	private String message;
	
	@GetMapping("/message")
	public String testMessage()
	{
		return message;
	}

}
