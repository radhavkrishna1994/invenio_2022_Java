package com.spring.restcontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.bean.User;


@RestController
public class HelloRestController {

	@RequestMapping("/hello")
	public String sayHello()
	{
		return "Hello! This is a RestController";
	}
	
	@RequestMapping("/user")
	public User userConfiguration()
	{
		return new User("sam", "sam@gmail.com", "87777");
	}
	
	@RequestMapping("/userlist")
	public List<User> userConfigurationList()
	{
		List<User> userList=new ArrayList<>();
		userList.add(new User("sam", "sam@gmail.com", "777772"));
		userList.add(new User("peter", "peter@gmail.com", "7877772"));
		userList.add(new User("smith", "smith@gmail.com", "98654"));
		return userList;
	}
	
}
