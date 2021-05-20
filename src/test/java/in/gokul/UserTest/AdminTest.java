package in.gokul.UserTest;

import static org.junit.Assert.*;

import org.junit.Test;


import in.gokul.services.AdminServices;

public class AdminTest {
/**
 * This test case checks for valid Admin and loggs in or not with given correct details which are 
 * available in admin database
 * @throws UserException 
 */
	@Test
	public void testAdminLoginWithCorrectDetails() {
		String admin="Ram";
		String password="Ramss@26";
		boolean loggedIn=AdminServices.adminLogin(admin, password);
		assertTrue(loggedIn);
	
	}
	/**
	 * This test case checks for valid Admin and logs in or not with given incorrect details which are not 
      * available in admin database
	 * @throws UserException 
	 */
	@Test
	public void testAdminLoginWithInCorrectDetails() {
		String admin="siva";
		String password="siva@26";
		boolean loggedIn=AdminServices.adminLogin(admin, password);
		assertFalse(loggedIn);
	
	}
	/**
	 * this test case method checks for the specific admin available in the admin list or not with correct details
	 */
	@Test
	public void testIsAdminAvailableWithCorrectFormat() {
		String admin="Ram";
	     boolean validAdmin=AdminServices.isAdminAvailable(admin);
		 assertTrue(validAdmin);
	
	}
	/**
	 * this test case method checks for the specific admin available in the admin list or not with incorrect details
	 */
	@Test
	public void testIsAdminAvailableWithIncorrectFormat() {
		String admin="siva";
	     boolean validAdmin=AdminServices.isAdminAvailable(admin);
		 assertFalse(validAdmin);
	
	}
	

}
