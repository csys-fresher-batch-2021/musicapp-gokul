package in.gokul.services;
import in.gokul.model.Languages;
import in.gokul.validation.Validation;

import java.util.ArrayList;
import java.util.List;



public class LanguageServices {
	private LanguageServices()
	{
		
	}

	private static final List <Languages> LanguageList= new ArrayList<>();

	static 
	{
		Languages language1=new Languages("Tamil");
		Languages language2=new Languages("Hindi");
		Languages language3=new Languages("English");
		LanguageList.add(language1);
		LanguageList.add(language2);
		LanguageList.add(language3);
		
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

  
    
          for (Languages languages : LanguageList) {
				
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
		
		return  LanguageList.size();

	}
	
	public static  List<Languages> getAllLanguages()
	{
		return LanguageList;
		
	}
	

}
