package com.example.UserManager.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.UserManager.entities.Task;
import com.example.UserManager.entities.User;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {

	@Query("SELECT t FROM Task t WHERE t.user = :user")
	public Iterable<Task> FindAllTasksByUserid(@Param("user") User user);
}
