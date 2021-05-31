package in.gokul.UserTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import in.gokul.model.User;
import in.gokul.services.NewUserRegistrationService;

class RegistrationTest {
	/**
	 * this method test for valid user registration with valid details
	 * 
	 * @param userName
	 * @param emailId
	 * @param mobileNumber
	 * @param password
	 * @param gender
	 * @param age
	 * @throws IOException
	 */

	@ParameterizedTest
	@CsvSource("Bharath,bharath@gmail.com,7894567684,Bharath@35,male,21")
	void testNewUserRegistrationWithCorrectDetails(String userName, String emailId, Long mobileNumber, String password,
			String gender, int age) throws IOException {

		User user = new User(userName, emailId, mobileNumber, password, gender, age);
		boolean isAdded = false;
		try {
			if (NewUserRegistrationService.isValidDetails(userName, emailId, mobileNumber.toString(), password, gender,
					age)) {

				isAdded = NewUserRegistrationService.addUser(user);
				assertTrue(isAdded);

			}
		} catch (Exception e) {
			fail();

		}

	}

	/**
	 * this method checks for user registration with values which is not in correct
	 * format
	 * 
	 * @param userName
	 * @param emailId
	 * @param mobileNumber
	 * @param password
	 * @param gender
	 * @param age
	 * @throws IOException
	 */

	@ParameterizedTest
	@CsvSource({ "siv,siv@gmail.com,7894567686,Bharath@35,male,21", "ravi,ravi@gmail,7894567686,Bharath@35,male,21",
			"pavithra,pavi@gmail.com,4967554678,Pavi@123,female,26", "Elan,elan@gmail.com,7823567847,elan,male,21",
			"jeeva,jeeva@gmail.com,9867859478,Jeeva@43,male,2"

	})
	void testNewUserRegistrationWithIncorrectDetails(String userName, String emailId, Long mobileNumber,
			String password, String gender, int age) throws IOException {

		User user = new User(userName, emailId, mobileNumber, password, gender, age);
		boolean isAdded = false;
		try {
			if (NewUserRegistrationService.isValidDetails(userName, emailId, mobileNumber.toString(), password, gender,
					age)) {
				System.out.println("hivalidatio");

				isAdded = NewUserRegistrationService.addUser(user);
			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		}
		assertFalse(isAdded);
	}

}
