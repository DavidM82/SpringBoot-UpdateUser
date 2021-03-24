package com.example.UserManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.example.UserManager.entities.User;
import com.example.UserManager.repositories.UserRepository;
import com.example.UserManager.services.UserService;

@DataJpaTest
public class UserServiceTests {

	@Autowired
	private TestEntityManager manager;
	
	@Autowired
	private UserService service;
	
	@Test
	public void whenGetUserByName_GetUser() {
		User test = new User();
		test.setName("default");
		test.setEmail("null@null.net");
		test.setPassword("root");
		
		manager.persist(test);
		manager.flush();
		
		User returned = service.GetUserByName(test.getName());
		
		assertEquals(returned.getName(), test.getName());
	}
	
	@Test
	public void WhenLogInCorrectly_GetTrue() {
		User test = new User();
		test.setName("test");
		test.setPassword("root");
		
		manager.persist(test);
		manager.flush();
		
		boolean result = service.authUser(test.getName(),test.getPassword());
		
		assertEquals(result, true);
	}
	
	@Test
	public void WhenLogInIncorrectly_GetFalse() {
		User test = new User();
		test.setName("test");
		test.setPassword("root");
		
		manager.persist(test);
		manager.flush();
		
		boolean result = service.authUser(test.getName(),test.getPassword() + "asdfjkl;asdfjkl;sdfa");
		
		assertEquals(result, false);
	}
}
