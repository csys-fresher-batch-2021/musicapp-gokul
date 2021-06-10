package in.gokul.services;

import in.gokul.dao.AdminWorksDao;
import in.gokul.model.Language;

public class AdminServices {
	private AdminServices()
	{
		
	}
	/**
	 * this method checks for the language name is already available or not 
	 * @param language
	 * @return
	 */
	public static boolean isLanguageAlreadyAvailable(Language language)
	{
		AdminWorksDao dao = new AdminWorksDao();
		return dao.isLanguageAlreadyAvailable(language);
	}

}
