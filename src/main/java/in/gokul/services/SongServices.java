package in.gokul.services;




import java.util.List;

import in.gokul.dao.SongsDao;
import in.gokul.model.Song;

public class SongServices {

	private SongServices()
	{
		
	}
	public static List<Song> searchSong(Song songName)
	{
	
		SongsDao dao=new SongsDao();
		return dao.getSongBySongName(songName);
	
	
		
	}
	
}
