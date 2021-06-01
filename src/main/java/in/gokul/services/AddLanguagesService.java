package in.gokul.services;

import in.gokul.dao.AddLanguageDao;
import in.gokul.exception.ServicesException;
import in.gokul.model.Language;

public class AddLanguagesService {
	private AddLanguagesService()
	{
		
	}
	public static boolean addLanguage(Language language) 
	{
		boolean added=false;
		try {
			AddLanguageDao dao=new AddLanguageDao();
			added=dao.addLanguage(language);
		
		} catch ( ServicesException e) {
			
			
			throw new ServicesException("Cannot call AddLanguageDAO");
		}

	       return added;
	}

}
