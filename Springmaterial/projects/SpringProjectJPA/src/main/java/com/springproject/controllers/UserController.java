package com.springproject.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springproject.bean.User;

@Controller
public class UserController {
private List<String> cities;

@RequestMapping("/getList")
public String setList(Model model){
	cities=new ArrayList<>();
	cities.add("Mumbai");
	cities.add("Bangalore");
	cities.add("chennai");
	User user = new User();
//user.setCities(cities);
	model.addAttribute("user", user);
	return "user";
}

public List<String> getCities() {
	return cities;
}

public void setCities(List<String> cities) {
	this.cities = cities;
}


}
