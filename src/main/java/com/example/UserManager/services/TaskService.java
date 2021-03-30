package com.example.UserManager.services;

import java.util.Collection;
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
	
	public Task getTaskById(int id) {
		Optional<Task> foundTask = taskrepository.findById(id);
		
		if (foundTask.isPresent()) {
			return foundTask.get();
		}
		return new Task();
	}
	
	public void updateTask(Task task) {
		taskrepository.save(task);
	}
	
	public void saveTask(Task task) {
		Iterable<Task> tasks = taskrepository.findAll();
		task.setTaskid(((Collection<?>) tasks).size()+1);
		taskrepository.save(task);
	}
	
	public void deleteTask(int id) {
		taskrepository.deleteById(id);
	}
}
