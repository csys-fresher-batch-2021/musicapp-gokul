package in.gokul.services;

import in.gokul.dao.NewUserRegistrationDao;
import in.gokul.model.User;
import in.gokul.validation.UserValidator;

public class NewUserRegistrationService {
	private NewUserRegistrationService()
	{
		
	}

	/**
	 * this method creates the object for NewUserRegistrationDao
	 * 
	 * @param user
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static boolean addUser(User user) {
		NewUserRegistrationDao dao = new NewUserRegistrationDao();
        return dao.addNewUser(user);

	}

	/**
	 * this method checks for the given details are valid before registering into
	 * the database
	 * 
	 * @param userName
	 * @param emailId
	 * @param mobileNumber
	 * @param password
	 * @param gender
	 * @param age
	 * @return
	 */
	public static boolean isValidDetails(String userName, String emailId, String mobileNumber, String password,
			String gender, int age) {

		boolean validDetails = false;
		boolean isValidUser = UserValidator.isValidUserName(userName)
				&& (UserValidator.isValidUserNamePattern(userName));
		boolean isValidPassword = UserValidator.isValidPassword(password);
		boolean isValidEmail = UserValidator.isValidEmail(emailId);
		boolean isValidAge = UserValidator.isValidAge(age);
		boolean isValidMobileNum = UserValidator.isValidMobileNum(mobileNumber);
		boolean isValidGender=UserValidator.isValidGender(gender);

		if ((isValidAge) && (isValidEmail) && (isValidMobileNum) && (isValidPassword) && (isValidUser)&&(isValidGender)) {
			validDetails = true;
		}
		return validDetails;

	}

}
