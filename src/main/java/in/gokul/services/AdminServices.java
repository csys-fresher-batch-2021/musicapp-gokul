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
	/**
	 * this method can add another admin in the admin list 
	 * Because of the admin addition it is made to be private
	 * @param adminName
	 * @param password
	 * @param email
	 * @return
	 */
  private static boolean addAdmin(String adminName, String password,String email)
	{
	  if(adminList.containsKey(adminName))
	  {
		Admin admin=new Admin(adminName, password,email);
	ArrayList<Admin> adminDetail=getNewArrayList();
	adminDetail.add(admin);
	adminList.put(adminName,adminDetail);
	  }
	return adminList.containsKey(adminName);
	
	}
  /**
   * this method return true  if new admin is added successfully in the adminList
   * otherwise it return false
   * @param adminName
   * @param password
   * @param emailId
   * @return
   */
  public static boolean admin(String adminName, String password,String emailId )
  {
	  return addAdmin(adminName, password,emailId);
	  
  }
  /**
	 * this method return new ArrayList 
	 * @return
	 */
	public static ArrayList<Admin> getNewArrayList()
	{
		return new ArrayList<>();
	}

}
