package in.gokul.UserTest;

import static org.junit.Assert.*;

import org.junit.Test;

import in.gokul.services.UserServices;

public class LoginTest {

	/**
	 * This test case method checks with correct Details which is stored in the database 
	 */
	@Test
	public void testLoginWithCorrectDetails() {
		String userName="gokul";
		String password="12345678";
		boolean isValid=UserServices.login(userName, password);
		assertTrue(isValid);
		
	}
	
	/**
	 * This test case method checks with Incorrect Details which is not stored in the database 
	 */
	@Test
	public void testLoginWithInCorrectDetails() {
		String userName="kiruba";
		String password="12345678";
		boolean isValid=UserServices.login(userName, password);
		assertFalse(isValid);
		
	}
	

}
