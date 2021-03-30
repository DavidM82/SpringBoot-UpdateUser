package com.example.UserManager.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UserManager.repositories.TaskRepository;
import com.example.UserManager.repositories.UserRepository;
import com.example.UserManager.entities.Task;
import com.example.UserManager.entities.User;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskrepository;

	@Autowired
	private UserService userService;
	
	public Iterable<Task> getAllTasksById(int userid){
		User user = userService.GetUserById(userid);
		
		return taskrepository.FindAllTasksByUserid(user);
	}
	
	public Iterable<Task> getAllTasks(){
		return taskrepository.findAll();
	}
}
