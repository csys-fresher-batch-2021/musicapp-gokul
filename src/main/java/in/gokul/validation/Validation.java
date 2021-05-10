package in.gokul.validation;

public class Validation {
	/**
	 * Accepts input language and checks whether the string is not null returns true
	 * if not null else return false
	 * 
	 * @param language
	 * @return
	 */
	public static boolean stringValidator(String language) {
		boolean isvalid = true;
		String specialCharacters = "!@#$%&*()'+,-./:;<=>?[]^_{}";
		try {
			
				if ((language == null )|| (language.trim().equals(" ")) || (language.contains(specialCharacters))) 
				{
					isvalid = false;
					System.out.println("helo");
				}
			
		} catch (Exception e) {
			isvalid=false;
			System.out.println(e.getMessage());
		}
		return isvalid;
	}
}
