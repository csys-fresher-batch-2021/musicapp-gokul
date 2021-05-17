package in.gokul.services;

import in.gokul.model.Language;

import java.util.ArrayList;
import java.util.List;

public class LanguageServices {
	private LanguageServices() {

	}

	private static final List<Language> languageList = new ArrayList<>();

	static {
		Language language1 = new Language("Tamil");
		Language language2 = new Language("Hindi");
		Language language3 = new Language("English");
		languageList.add(language1);
		languageList.add(language2);
		languageList.add(language3);

	}

	/**
	 * it returns the total number of languages count.
	 * 
	 * @return
	 */
	public static int totalLanguagesCount() {

		return languageList.size();

	}

	public static List<Language> getAllLanguages() {
		return languageList;

	}

}
