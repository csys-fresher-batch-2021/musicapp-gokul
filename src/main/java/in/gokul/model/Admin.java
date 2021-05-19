package in.gokul.model;

public class Admin {
	private String adminName;
	private String password;
	private String emailId;

	@Override
	public String toString() {
		return "Admin [adminName=" + adminName + ", password=" + password + "]";
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Admin(String adminName, String password, String emailId) {

		this.adminName = adminName;
		this.password = password;
		this.emailId = emailId;
	}

}
