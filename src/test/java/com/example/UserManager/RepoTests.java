package com.example.UserManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.example.UserManager.entities.User;
import com.example.UserManager.repositories.UserRepository;


@DataJpaTest
public class RepoTests {

	@Autowired
	private TestEntityManager manager;
	
	@Autowired
	private UserRepository repo;
	
	@Test
	public void whenFindByName_ReturnsUser() {
		User test = new User();
		test.setName("default");
		test.setEmail("null@null.net");
		test.setPassword("root");
		
		manager.persist(test);
		manager.flush();
		
		User found = repo.findByName(test.getName());
		
		assertEquals(found.getName(), test.getName());
	}
}
