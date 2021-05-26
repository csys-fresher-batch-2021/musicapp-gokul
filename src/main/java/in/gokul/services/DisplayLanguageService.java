package in.gokul.services;

import java.util.ArrayList;
import java.util.List;

import in.gokul.dao.DisplaylanguageDao;
import in.gokul.exception.ServicesException;
import in.gokul.model.Language;

public class DisplayLanguageService {
	/**
	 * This method creates the object for DisplayLanguagedao.
	 * @return
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
