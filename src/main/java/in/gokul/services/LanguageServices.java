package in.gokul.services;

import in.gokul.model.Languages;
import in.gokul.validation.Validation;

import java.util.ArrayList;
import java.util.List;

public class LanguageServices {
	private LanguageServices() {

	}

	private static final List<Languages>languageList = new ArrayList<>();

	static {
		Languages language1 = new Languages("Tamil");
		Languages language2 = new Languages("Hindi");
		Languages language3 = new Languages("English");
		languageList.add(language1);
		languageList.add(language2);
		languageList.add(language3);

	}

	/**
	 * accepts language as input checks for language available or not
	 * 
	 * @param language
	 * @return
	 */
	public static boolean isLanguageAvailable(String language) {
		boolean isAvailable = false;

		if (Validation.stringValidator(language)) {

			for (Languages languages :languageList) {

				if (language.equals(languages.getLanguage())) {
					isAvailable = true;
				}
			}

		}

		return isAvailable;
	}

	/**
	 * it returns the total number of languages count.
	 * 
	 * @return
	 */
	public static int totalLanguagesCount() {

		return languageList.size();

	}

	public static List<Languages> getAllLanguages() {
		return languageList;

	}

}
