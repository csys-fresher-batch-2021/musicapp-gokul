package in.gokul.UserTest;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import in.gokul.services.UserLoginServices;

class LoginTest {
	/**
	 * this testcase checks for login with correct details
	 * 
	 * @param userName
	 * @param password
	 */

	@Order(1)
	@ParameterizedTest
	@CsvSource({ "Kiruba,Kirubs@345", "gokul,Gokul@123" })
	void testForValidUsernameWithCorrectFormat(String userName, String password) {

		assertTrue(UserLoginServices.login(userName, password));

	}

	/**
	 * This method tests with incorrect string which is not valid
	 */

	@Order(2)
	@ParameterizedTest
	@CsvSource({ "Kiruba,Kiru123", "gokul,gk123" })
	void testForValidUsernameWithInCorrectFormat(String userName, String password) {

		System.out.println("Testcase:" + UserLoginServices.login(userName, password));
		assertFalse(UserLoginServices.login(userName, password));
	}
}
