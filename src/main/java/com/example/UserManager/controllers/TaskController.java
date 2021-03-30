package com.example.UserManager.controllers;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.UserManager.entities.Task;
import com.example.UserManager.services.TaskService;

@Controller
public class TaskController {

	Logger logger = LoggerFactory.getLogger(TaskController.class);
	
	@Autowired
	TaskService taskService;
	
	@GetMapping(value="/tasks")
	public String showTasks(ModelMap model) {
		int userid = 1;
		logger.info("Getting tasks of User with ID: " + 1 );
		Iterable<Task> tasks = taskService.getAllTasksById(userid);
		//Iterable<Task> tasks = taskService.getAllTasks();
		logger.info("Tasks retrieved. Count: " + ((Collection<?>) tasks).size());
		model.addAttribute("tasks", tasks);
		
		return "tasks";
	}
}
