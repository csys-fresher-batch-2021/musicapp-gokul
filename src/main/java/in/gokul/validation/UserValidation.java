package in.gokul.validation;

public class UserValidation {
	private UserValidation()
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
		if (Validation.stringValidator(userName) && (length <= 6) && (length >= 4)) {
			isValid = true;
		}

		return isValid;
	}
}
