package in.gokul.services;



import in.gokul.dao.SongsDao;
import in.gokul.model.Song;

public class SongServices {

	private SongServices()
	{
		
	}
	public static Song searchSong(Song songName)
	{
		SongsDao dao=new SongsDao();
		Song searchedSong=dao.getSongBySongName(songName);
	
		return searchedSong;
		
	}
	
}
