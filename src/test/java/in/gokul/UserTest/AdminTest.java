package in.gokul.UserTest;

import static org.junit.Assert.*;

import org.junit.Test;

import in.gokul.services.AdminLoginServices;
import in.gokul.validation.UserValidator;

public class AdminTest {
	/**
	 * This test case checks for valid Admin and loggs in or not with given correct
	 * details which are available in admin database
	 * 
	 * @throws UserException
	 */
	@Test
	public void testAdminLoginWithCorrectDetails() {
		String admin = "Ramkumar";
		String password = "Ram@123";
		boolean loggedIn = AdminLoginServices.adminLoginService(admin, password);
		assertTrue(loggedIn);

	}

	/**
	 * This test case checks for valid Admin and logs in or not with given incorrect
	 * details which are not available in admin database
	 * 
	 * @throws UserException
	 */
	@Test
	public void testAdminLoginWithInCorrectDetails() {
		String admin = "Ramkumar";
		String password = "siva@26";
		boolean loggedIn = AdminLoginServices.adminLoginService(admin, password);
		assertFalse(loggedIn);

	}

	/**
	 * this test case method checks for the specific admin available in the admin
	 * list or not with correct details
	 */
	@Test
	public void testIsAdminAvailableWithCorrectFormat() {
		String admin = "Ramkumar";
		boolean validAdmin = UserValidator.isValidUserName(admin);
		assertTrue(validAdmin);

	}

	/**
	 * this test case method checks for the specific admin available in the admin
	 * list or not with incorrect details
	 */
	@Test
	public void testIsAdminAvailableWithIncorrectFormat() {
		String admin = "siv";
		boolean validAdmin = UserValidator.isValidUserName(admin);
		assertFalse(validAdmin);

	}

}
