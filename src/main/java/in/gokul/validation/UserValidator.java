package in.gokul.validation;

public class UserValidator {
	private UserValidator()
	{
		
	}
	/**
	 * this method returns true if userName length is greater than 4 and less than 6
	 * 
	 * @param userName
	 * @return
	 */
	public static boolean isValidUserName(String userName) {
		boolean isValid = false;
		int length = userName.length();
		if (Validator.stringValidator(userName) && (length <= 8) && (length >= 4)) {
			isValid = true;
		}

		return isValid;
	}
}
