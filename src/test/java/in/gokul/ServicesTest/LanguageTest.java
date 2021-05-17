
package in.gokul.ServicesTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import in.gokul.services.LanguageServices;
import in.gokul.validation.Validator;

import org.junit.Test;

public class LanguageTest {

	/**
	 * gets the total languages Count
	 */
	@Test
	public void totalLanguagesCount() {
		int languagesCount = LanguageServices.totalLanguagesCount();
		assertEquals(3, languagesCount);

	}

	/**
	 * checks for valid String by giving correct details
	 *
	 */
	@Test
	public void validationWithCorrectDetails() {
		String language = "Tamil";
		boolean valid = Validator.stringValidator(language);
		System.out.println(valid);
		assertTrue(valid);

	}

	/**
	 * sending input as null and checking for valid string
	 */
	@Test
	public void stringValidationWithIncorrectDetails() {
		String language = null;
		boolean valid = Validator.stringValidator(language);
		assertFalse(valid);

	}

}
