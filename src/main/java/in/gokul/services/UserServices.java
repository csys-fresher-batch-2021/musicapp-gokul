package in.gokul.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import in.gokul.model.*;
import in.gokul.validation.UserValidator;

public class UserServices {

	private UserServices() {

	}

	private static final Map<String, ArrayList<User>> userList = new HashMap<>();
	private static final ArrayList<User> userDetails1 = new ArrayList<>();
	private static final ArrayList<User> userDetails2 = new ArrayList<>();
	static {

		User user1 = new User("kiruba", "kiruba@gmail.com", 1234569870, "34567890", "female", 21);
		User user2 = new User("gokul", "ramg@gmail.com", 1234567890, "12345678", "male", 21);

		userDetails1.add(user1);
		userDetails2.add(user2);
		userList.put("kiruba", userDetails1);
		userList.put("gokul", userDetails2);

	}

	/**
	 * this method checks that the user is already available or not if available
	 * returns true else returns false
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public static boolean isValidUser(String userName, String password) {
		boolean isValid = false;
		if (userList.containsKey(userName)) {
			ArrayList<User> userDetail = new ArrayList<>();
			userDetail = userList.get(userName);
			for (User info : userDetail) {
				if (info.getPassword().equals(password)) {
					isValid = true;
				}
			}

		}

		return isValid;
	}

	/**
	 * this method checks for user is available or not
	 * 
	 * @param userName
	 * @return
	 */
	public static boolean isUserAvailable(String userName) {
		return userList.containsKey(userName);
	}

	/**
	 * this login method accepts userName and passsword checks that username and
	 * password already exists in the userList
	 * 
	 * @param userName
	 * @param password
	 */
	public static boolean login(String userName, String password) {

		boolean loggedin = false;
		if (UserValidator.isValidUserName(userName) && isUserAvailable(userName) && isValidUser(userName, password)) {
			loggedin = true;
		}
		return loggedin;
	}


}