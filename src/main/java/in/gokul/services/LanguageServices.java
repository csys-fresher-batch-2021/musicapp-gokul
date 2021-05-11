package in.gokul.services;
import in.gokul.model.Language;
import in.gokul.validation.Validation;

import java.util.ArrayList;
import java.util.List;



public class LanguageServices {

	static List <Language> LanguageList= new ArrayList<Language>();

	static 
	{
		Language language1=new Language("Tamil");
		Language language2=new Language("Hindi");
		Language language3=new Language("English");
		LanguageList.add(language1);
		LanguageList.add(language2);
		LanguageList.add(language3);
		
	}
	
	/**
	 * it displays all the available languages
	 */
	public static void displayAvailableLanguages() {
		System.out.println("----Available Languages----");
		for (Language language : LanguageList) {
			System.out.println(language);
		}

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
		//	language = language.toUpperCase();
            System.out.println("hii");
         //   Language input=new Language; 
          for (Language languages : LanguageList) {
				
            if(language.equals(languages.getLanguage()))
            {
            	isAvailable=true;
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
		int songsCount = LanguageList.size();
		return songsCount;

	}
	
	public static  List<Language> getAllLanguages()
	{
		return LanguageList;
		
	}

}
