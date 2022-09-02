package com.training.webdemos.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {

	public String sayHello()
	{
		return "This is my controller";
	}
}
