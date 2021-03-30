package com.example.UserManager.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UserManager.entities.User;
import com.example.UserManager.exceptions.UserNotFoundException;
import com.example.UserManager.repositories.UserRepository;



@Service
public class UserService {
	
	@Autowired
	 private UserRepository userRepository;
	
	

    public Iterable<User> GetAllUsers()
    {
        return userRepository.findAll();
    }


    public User GetUserByName(String name) {
        User foundUser = userRepository.findByName(name);
        return foundUser;
    }
    
    public User GetUserById(int id) {
    	Optional<User> foundUser = Optional.ofNullable(userRepository.findByUserid(id));
    	
    	
    	//TODO: we need to decide how to handle a "Not Found" condition
    	
    	if (!foundUser.isPresent()) {
    		throw new UserNotFoundException();
    	}
    	
    	return(foundUser.get());
    }
    
    public boolean authUser(String name, String password) {
    	Optional<User> foundUser = Optional.ofNullable(userRepository.findByName(name));
    	if (foundUser.isEmpty()) {
    	
    		return false;
    	}
    	if (!foundUser.get().getPassword().equals(password)) {
    		return false;
    	}
    	
    	
    	return true;
    }
    
    public void UpdateUser(User usertoUpdate) {
    	userRepository.save(usertoUpdate);
    }


}
