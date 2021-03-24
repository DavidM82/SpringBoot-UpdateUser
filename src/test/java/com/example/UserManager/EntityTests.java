package com.example.UserManager;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.example.UserManager.entities.User;

public class EntityTests {

	@Test
	public void WhenSetPassword_CheckGetPassword() {
		User test = new User();
		test.setPassword("testing");
		
		assertEquals(test.getPassword(), "testing");
	}
	
	@Test
	public void WhenSetName_CheckGetName() {
		User test = new User();
		test.setName("Tom");
		
		assertEquals(test.getName(), "Tom");
	}
	
	@Test
	public void WhenSetEmail_CheckGetEmail() {
		User test = new User();
		test.setEmail("test@test.com");
		
		assertEquals(test.getEmail(), "test@test.com");
	}
	
	@Test
	public void WhenSetId_CheckGetId() {
		User test = new User();
		test.setId(5);
		
		assertEquals(test.getId(), 5);
	}
}
