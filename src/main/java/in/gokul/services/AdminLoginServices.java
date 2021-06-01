package in.gokul.services;

import in.gokul.dao.AdminLoginDao;

import in.gokul.model.Admin;

public class AdminLoginServices {

	private AdminLoginServices() {

	}

	public static boolean adminLoginService(String admin, String password) {
		boolean validAdmin = false;
		Admin admin1 = new Admin(admin, password);
		Admin adminDetail = AdminLoginDao.adminLogin(admin1);
		if (adminDetail.getPassword().equals(password)) {
			validAdmin = true;
		}
		return validAdmin;
	}

}
