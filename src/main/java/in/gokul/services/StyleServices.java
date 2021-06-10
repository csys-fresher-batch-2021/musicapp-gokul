package in.gokul.services;

import in.gokul.dao.StyleDao;
import in.gokul.exception.DbException;
import in.gokul.exception.ServicesException;

public class StyleServices {
	private StyleServices()
	{
		
	}

	/**
	 * This method is used to retrieve image from database 
	 * @param countryName
	 * @return
	 */
	public static byte[] retireveImage(String imageName) {
		StyleDao dao = new StyleDao();
		byte[] image;
		try {
			image = dao.retireveImage(imageName);
		} catch (DbException e) {
			throw new ServicesException("unable to retireve image"+e.getMessage());

		}
		return image;
	}
}
