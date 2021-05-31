package in.gokul.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.gokul.exception.ServicesException;

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

		return Pattern.matches("[a-zA-Z0-9]{4,12}", userName);
	}

	/**
	 * this method checks for password should be alphanumeric and contain special
	 * characters and 8 or more characters
	 * 
	 * @param password
	 * @return
	 */
	public static boolean isValidPassword(String password)

	{
		String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(password);
		return m.matches();
	}

	/**
	 * This method returns true if input email matches with regex pattern Regex
	 * pattern consists of Alphanumeric characters and @- symbol and string
	 * 
	 * @param email
	 * @return
	 */
	public static boolean isValidEmail(String email)  {
		Matcher matcher;
		try
		{
		String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9+.-]+\\.[a-z]+$";
		Pattern pattern = Pattern.compile(regex);
		 matcher = pattern.matcher(email);
		}catch(RuntimeException e)
		{
			throw new ServicesException(e.getMessage());
		}
		return matcher.matches();
	}

	/**
	 * Users age must be greater than 6
	 * 
	 * @param age
	 * @return
	 */
	public static boolean isValidAge(int age) {

		return age > 6 ? true : false;

	}

	/**
	 * this method checks for valid mobilenumber that should starts with 7,8,9 and must contains 10 digits
	 * @param mobileNum
	 * @return
	 */
	public static boolean isValidMobileNum(String mobileNum) {
		Pattern p = Pattern.compile("[7-9]+[0-9]{9}");
		Matcher m = p.matcher(mobileNum);

		return m.matches();
	}
	/**
	 * this method returns true if the passed parameter is male,female and other
	 * @param gender
	 * @return
	 */
  public static boolean isValidGender(String gender)
  {
	  boolean isValid=false;
	  if(gender.equalsIgnoreCase("male")||gender.equalsIgnoreCase("female")||gender.equalsIgnoreCase("other"))
     {
		  isValid=true;
	}
	  return isValid;
  }
}
