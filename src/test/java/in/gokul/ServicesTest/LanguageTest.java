
package in.gokul.ServicesTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import in.gokul.services.LanguageServices;
import in.gokul.validation.Validation;

import org.junit.Test;





public class LanguageTest {

	/**
	 * Checks that if the language is available or not If available return true else
	 * false
	 */
	@Test
	public void isAvailableLanguageTest() {

		String language = "Tamil";
		String available = "false";
		if (LanguageServices.isLanguageAvailable(language)) {
			available = "true";
		} 
		assertEquals( "true",available);

	}

	/**
	 * checks for displaying available languages
	 */
	@Test
	public void displayAvailableLanguageTest() {
		LanguageServices.displayAvailableLanguages();
	

	}

	/**
	 * gets the total languages Count
	 */
	@Test
	public void TotalLanguagesCount() {
		int languagesCount =LanguageServices.totalLanguagesCount();
		assertEquals(3,languagesCount);

	}

	/**
	 * checks for valid String by giving correct details
	 *
	 */
	@Test
	public void ValidationwithCorrectDetails() {
		String language = "Tamil";
		boolean valid = Validation.stringValidator(language);
		System.out.println(valid);
		assertTrue(valid);

	}

	/**
	 * sending input as null and checking for valid string
	 */
	@Test
	public void stringValidationWithIncorrectDetails() {
		String language = null;
		boolean valid = Validation.stringValidator(language);
		assertFalse(valid);
		
	}

}
