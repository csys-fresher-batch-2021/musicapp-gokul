package in.gokul.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import in.gokul.model.Admin;

public class AdminServices {
	private AdminServices() {
//default constructor
	}

	private static final Map<String, ArrayList<Admin>> adminList = new HashMap<>();
	private static final ArrayList<Admin> adminDetails = new ArrayList<>();

	static {
		Admin admin1 = new Admin("Ram", "Ramss@26", "ram@gmail.com");
		adminDetails.add(admin1);
		adminList.put("Ram", adminDetails);
	}

	/**
	 * This method accepts adminName and password as input and checks that whether
	 * it is available in the adminList it returns true if exists otherwise return
	 * false
	 * 
	 * @param adminName
	 * @param password
	 * @return
	 * 
	 */
	public static boolean adminLogin(String adminName, String password) {
		boolean validAdmin = false;
		if (isAdminAvailable(adminName)) {
			for (String adminKey : adminList.keySet()) {
				ArrayList<Admin> adminDetails = adminList.get(adminKey);

				for (Admin info : adminDetails) {
					if (info.getPassword().equals(password)) {
						validAdmin = true;
					}
				}
			}
		}
		return validAdmin;
	}

	/**
	 * this method checks for adminUser is already available in the adminList
	 * returns true if exists else return false
	 * 
	 * @param adminName
	 * @return
	 */
	public static boolean isAdminAvailable(String adminName) {
		return adminList.containsKey(adminName);
	}
	public static void main(String[] args) {
		String admin="Ram";
		String password="Ramss@26";
		String email="ki@gmail.com";
		//System.out.println(admin(admin, password,email));
		//System.out.println(adminList.size());

			System.out.println(adminLogin(admin, password));
		
	}

}
