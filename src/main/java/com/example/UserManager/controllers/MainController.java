package com.example.UserManager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.UserManager.entities.User;
import com.example.UserManager.services.UserService;

@Controller
public class MainController {
	
	@Autowired
	UserService userservice;
	
	 @GetMapping(value="/")
     public String showIndexPage(ModelMap model, 
    		 @RequestParam(value="name", required=false, defaultValue="World") String name){
	     model.addAttribute("name", name);    
		 return "index";
     }

	 @GetMapping(value="/login")
	 public String showLoginPage(ModelMap model) {
		 return "login";
	 }
	 
	 @PostMapping(value="/login")
	 public String LogIn(ModelMap model, @RequestParam(value="username") String name, @RequestParam(value="password") String password) {
		 
		 if (userservice.authUser(name, password)) {
			 return "success";
		 }
		 return "failure";
	 }
	 
	 @GetMapping(value="/logout")
	 public String logOutUser() {
		 userservice.logOutUser();
		 return "index";
	 }
}

