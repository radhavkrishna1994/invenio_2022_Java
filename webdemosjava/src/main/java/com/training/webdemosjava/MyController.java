package com.training.webdemosjava;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

	@ResponseBody
	@RequestMapping("/hello")  //http://localhost:8080/webdemos/hello
	public String sayHello()
	{
		return "This is my controller";
	}
	
	@RequestMapping("/login")  //http://localhost:8080/webdemos/login
	public String login()
	{
		return "login.jsp";
	}
	
	@RequestMapping("/home")  //http://localhost:8080/webdemos/hello1
	public String home(@RequestParam("name") String name,
			@RequestParam("email") String email,ModelMap map)
	{
		map.addAttribute("name", name);
		map.addAttribute("email", email);
		return "home.jsp";
	}
}
