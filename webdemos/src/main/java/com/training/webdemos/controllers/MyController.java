package com.training.webdemos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

	@ResponseBody
	@RequestMapping("/hello")  //http://localhost:8080/webdemos/hello
	public String sayHello()
	{
		return "This is my controller";
	}
}
