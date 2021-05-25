package in.gokul.services;

import in.gokul.dao.DeleteLanguageDao;
import in.gokul.exception.ServicesException;
import in.gokul.model.Language;

public class DeleteLanguageServices {
	private DeleteLanguageServices()
	{
		
	}

	/**
	 * this method create the object for addlanguageDao and passes the language as parameter
	 * @param language
	 * @return
	 */
		public static boolean deleteLanguage(Language language)
		{
			boolean deleted=false;
			try {
				DeleteLanguageDao dao=new DeleteLanguageDao();
				deleted=dao.deleteLanguage(language);
			
			} catch ( ServicesException e) {
				
				
				throw new ServicesException("Cannot call Delete LanguageDAO");
			}

		       return deleted;
		
		
		}
}
