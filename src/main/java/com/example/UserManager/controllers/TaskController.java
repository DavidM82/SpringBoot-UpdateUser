package com.example.UserManager.controllers;

import java.text.ParseException;
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
import com.example.UserManager.entities.User;
import com.example.UserManager.services.TaskService;
import com.example.UserManager.services.UserService;

@Controller
public class TaskController {

	Logger logger = LoggerFactory.getLogger(TaskController.class);
	
	@Autowired
	TaskService taskService;
	
	@Autowired
	UserService userService;
	
	@GetMapping(value="/tasks")
	public String showTasks(ModelMap model) {
		if (!userService.isLoggedIn()) {
			logger.info("User isn't logged in. Redirecting to log in page.");
			return "login";
		}
		logger.info("User is logged in, getting log in info");
		User user = userService.getLogIn();
		int id = user.getId();
		logger.info("Getting tasks of User with ID: " + id );
		Iterable<Task> tasks = taskService.getAllTasksById(id);
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
	
	@GetMapping(value="/deletetask/{taskid}")
	public String deleteTask(@PathVariable("taskid") int id) {
		logger.info("Deleting task id: " + id);
		taskService.deleteTask(id);
		return "deleted";
	}
	
	@PostMapping(value="/updatetask")
	public String updateTask(@RequestParam(value="startString") String startString, @RequestParam(value="endString") String endString,
							@RequestParam(value="name") String name, @RequestParam(value="description") String desc,
							@RequestParam(value="email") String email, @RequestParam(value="severity") int severity,
							@RequestParam(value="taskid") int id, @RequestParam(value="user") User user) {
		logger.info("Starting date: " + startString);
		logger.info("Ending date: " + endString);
		
		try {
			Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(startString);
			Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endString);
			Task task = new Task();
			task.setTaskid(id); task.setName(name); task.setDescription(desc); task.setEmail(email); task.setSeverity(severity); task.setUser(user); task.setStartDate(startDate); task.setEndDate(endDate);
			logger.info("Updating task...");
			taskService.updateTask(task);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "index";
	}
	
	@GetMapping(value="/newtask")
	public String newTask() {
		logger.info("Creating a new task...");
		return "newtask";
	}
	
	@PostMapping(value="/newtask")
	public String newTask(@RequestParam(value="startString") String startString, @RequestParam(value="endString") String endString,
						@RequestParam(value="name") String name, @RequestParam(value="desc") String desc, @RequestParam(value="email") String email,
						@RequestParam(value="severity") int severity) {
		logger.info("Starting date: " + startString);
		logger.info("Ending date: " + endString);
		
		try {
			Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(startString);
			Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endString);
			Task task = new Task();
			task.setName(name); task.setDescription(desc); task.setEmail(email); task.setSeverity(severity);
			task.setStartDate(startDate); task.setEndDate(endDate);
			task.setUser(userService.GetUserById(1));
			logger.info("Saving new Task...");
			taskService.saveTask(task);
			logger.info("Task saved.");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "index";
	}
}
