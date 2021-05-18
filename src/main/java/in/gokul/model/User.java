package in.gokul.model;

public class User {
	private String userName;
	private String emailId;
	private long mobileNumber;
	private String password;
	private String gender;
	private int age;

	@Override
	public String toString() {
		return "User [userName=" + userName + ", emailId=" + emailId + ", mobileNumber=" + mobileNumber + ", password="
				+ password + ", gender=" + gender + ", age=" + age + "]";
	}

	public User(String userName, String emailId, long mobileNumber, String password, String gender, int age) {
		this.userName = userName;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.gender = gender;
		this.age = age;

	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

}
