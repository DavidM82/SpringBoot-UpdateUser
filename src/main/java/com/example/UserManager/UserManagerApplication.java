package com.example.UserManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.example.UserManager.controllers.MainController;
import com.example.UserManager.entities.User;
import com.example.UserManager.services.UserService;
import com.example.UserManager.exceptions.UserNotFoundException;

@SpringBootApplication
@Import({
    MainController.class,
    UserNotFoundException.class,
    UserService.class,
    User.class
})
public class UserManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagerApplication.class, args);
	}

}
