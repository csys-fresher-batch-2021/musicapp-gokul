package in.gokul.services;

import in.gokul.dao.UserLoginDao;
import in.gokul.exception.ServicesException;
import in.gokul.model.User;
import in.gokul.validation.UserValidator;

public class UserLoginServices {
	private UserLoginServices() {

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

			try {
				if ((userDetail.getUserName().equals(user.getUserName()))
						&& (userDetail.getPassword().equals(user.getPassword()))) {
					validUser = true;
				}
			} catch (Exception e) {
				throw new ServicesException("invalid login credentials");

			}

		}
		return validUser;

	}

}
