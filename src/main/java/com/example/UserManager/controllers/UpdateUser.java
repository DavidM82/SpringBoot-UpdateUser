package com.example.UserManager.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.UserManager.entities.User;
import com.example.UserManager.services.UserService;

@Controller
public class UpdateUser {

	@Autowired
	private UserService userService;
	
    Logger logger = LoggerFactory.getLogger(UserController.class);
    
    @GetMapping(value = "/updateuser/{userId}")
    public String getUser(@PathVariable("userId") int id, ModelMap model) {
    	
    	logger.info("Getting User: " + id);
    	User user = userService.GetUserById(id);
    	logger.info("Putting user in view...");
    	model.addAttribute("user", user);
    	
    	return "updateuser";
    }
    
    @PostMapping(value = "/updateuser")
    public String saveUser(ModelMap model, @RequestParam(value = "id") int id, @RequestParam(value = "name") String name, @RequestParam(value = "email") String email, @RequestParam(value = "password") String password) {
    	logger.info("Getting user information from form." + id );
    	    	
    	logger.info("Saving to a new User object...");
    	User user = new User();
    	user.setId(id); user.setName(name); user.setEmail(email); user.setPassword(password);
    	
    	logger.info("Updating user: " + user.getId());
    	
    	userService.UpdateUser(user);
    	
    	logger.info("User successfully updated");
    	return "index";
    }
}
