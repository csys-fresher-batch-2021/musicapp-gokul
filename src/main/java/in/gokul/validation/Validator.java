package in.gokul.validation;

public class Validator {
	private Validator() {

	}

	/**
	 * Accepts input language and checks whether the string is not null returns true
	 * if not null else return false
	 * 
	 * @param language
	 * @return
	 */
	public static boolean stringValidator(String input) {
		boolean isValidString = true;

		try {

			if ((input == null) || (input.trim().equals(""))) {
				isValidString = false;

			}
			String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
			String numbers = "0123456789";
			for (int i = 0; i < input.length(); i++) {
				char ch = input.charAt(i);
				if (specialCharactersString.contains(Character.toString(ch)) || numbers.contains(Character.toString(ch))) {
					isValidString = false;
					break;
				}
			}

		} catch (Exception e) {
			isValidString = false;

		}
		return isValidString;
	}
}
