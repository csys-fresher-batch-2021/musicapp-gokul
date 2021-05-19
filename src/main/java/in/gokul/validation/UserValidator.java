package in.gokul.validation;

import java.util.regex.Pattern;

public class UserValidator {
	private UserValidator() {

	}

	/**
	 * this method returns true if userName length is greater than 4 and less than 6
	 * 
	 * @param userName
	 * @return
	 */
	public static boolean isValidUserName(String userName) {
		boolean isValid = false;
		if (Validator.stringValidator(userName) && isValidUserNamePattern(userName)) {
			isValid = true;
		}
		return isValid;
	}

	/**
	 * this method checks for user name is alphanumeric and must contain 4 to 8
	 * characters
	 * 
	 * @param userName
	 * @return
	 */
	public static boolean isValidUserNamePattern(String userName) {

		return Pattern.matches("[a-zA-Z0-9]{4,8}", userName);
	}

}
