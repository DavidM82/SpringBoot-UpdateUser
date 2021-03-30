package com.example.UserManager.controllers;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping(value="/updatetask/{taskId}")
	public String updateTask(@PathVariable("taskId") int id, ModelMap model) {
		
		logger.info("Getting Task: " + id);
		Task task = taskService.getTaskById(id);
		logger.info("Inserting task into view...");
		model.addAttribute("task", task);
		
		String startdateString = task.getStartDate().toString();
		String enddateString = task.getEndDate().toString();
		
		model.addAttribute("startdate", startdateString);
		model.addAttribute("enddate", enddateString);
		
		return "updatetask";
	}
	
	@PostMapping(value="/updatetask")
	public String updateTask(@RequestParam(value="startString") String startString, @RequestParam(value="endString") String endString) {
		logger.info("Starting date: " + startString);
		logger.info("Ending date: " + endString);
		return "index";
	}
}
