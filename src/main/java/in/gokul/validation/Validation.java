package in.gokul.validation;

public class Validation {
	private Validation() {

	}

	/**
	 * Accepts input language and checks whether the string is not null returns true
	 * if not null else return false
	 * 
	 * @param language
	 * @return
	 */
	public static boolean stringValidator(String language) {
		boolean isvalid = true;

		try {

			if ((language == null) || (language.trim().equals(""))) {
				isvalid = false;

			}

		} catch (Exception e) {
			isvalid = false;

		}
		return isvalid;
	}
}
