package in.gokul.validation;

import java.util.regex.Pattern;

import in.gokul.exception.ValidatorException;

public class LanguageValidator {
	private LanguageValidator() {

	}

	/**
	 * this method checks that string is null, empty and does it contains any
	 * integer values
	 * 
	 * @param language
	 * @return
	 */
	public static boolean isValidLanguage(String language) {
		boolean isvalid = true;

		try {

			if ((language == null) || (language.trim().equals("")) || (Pattern.matches("[0-9]+", language))) {
				isvalid = false;
		

			}

		} catch (ValidatorException e) {

			throw new ValidatorException(e.getMessage());

		}

		return isvalid;
	}

	/**
	 * this method checks for the input string contains length greater than 4.
	 * 
	 * @param input
	 * @return
	 */
	public static boolean validlengthforLanguage(String input) {
		return input.length() >= 4;

	}

}
