package in.gokul.services;




import in.gokul.dao.DisplaylanguageDao;
import in.gokul.exception.ServicesException;
import in.gokul.model.Language;

import java.util.ArrayList;
import java.util.List;

public class LanguageServices {
	private LanguageServices() {

	}
	

	private static  List<Language> languageList = new ArrayList<>();

	static {
		Language language1 = new Language("Tamil");
	//	Language language2 = new Language("Hindi");
		Language language3 = new Language("English");
		languageList.add(language1);
		//languageList.add(language2);
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
	/**
	 * This method calls the displaylanguage dao 
	 */
	public static List<Language> displayLanguages()
	{
		List<Language>list=new ArrayList<>();
		try {
			DisplaylanguageDao dao=new DisplaylanguageDao();
			list=dao.getAllLanguage();
		
		} catch ( ServicesException e) {
			throw new ServicesException("Cannot call AddLanguageDAO");
		}

	     
	
	return list;
	}

	}

	


