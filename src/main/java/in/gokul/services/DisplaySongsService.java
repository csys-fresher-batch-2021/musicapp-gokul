package in.gokul.services;

import java.util.List;

import in.gokul.dao.SongsDao;
import in.gokul.model.Song;

public class DisplaySongsService {
	private DisplaySongsService()
	{
		
	}
	public static List<Song> getAllSongsService()
	{
		SongsDao dao=new SongsDao();
		 		
		return dao.getAllLanguageSongs();

	}

	
}
