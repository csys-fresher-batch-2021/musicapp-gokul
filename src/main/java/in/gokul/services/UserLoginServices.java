package in.gokul.services;

import in.gokul.dao.UserLoginDao;
import in.gokul.model.User;
import in.gokul.validation.UserValidator;

public class UserLoginServices {
	private UserLoginServices()
	{
		
	}

	/**
	 * this method calls the userloginDao with username as argument and checks for
	 * the correct password.
	 * 
	 * @param user
	 * @return
	 */
	public static boolean login(String userName, String password) {

		boolean validUser = false;
		if (UserValidator.isValidUserName(userName)) {

			User user = new User(userName, password);
			User userDetail = UserLoginDao.getUserDetailsByUserName(user);
			if (userDetail.getPassword().equals(user.getPassword())) {
				validUser = true;
			}
		}
		return validUser;
	}

}
