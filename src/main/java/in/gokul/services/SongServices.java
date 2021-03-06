package in.gokul.services;

import java.util.List;

import in.gokul.dao.SongsDao;
import in.gokul.dto.LikedSongsDto;
import in.gokul.dto.SongsDto;
import in.gokul.exception.DbException;
import in.gokul.exception.ServicesException;
import in.gokul.model.Song;
import in.gokul.validation.LanguageValidator;
import in.gokul.validation.SongsValidator;
import in.gokul.validation.Validator;

public class SongServices {

	private SongServices() {

	}

	/**
	 * this service method calls the dao which returns songlist
	 * 
	 * @param songName
	 * @return
	 */
	public static List<Song> searchSong(Song songName) {

		SongsDao dao = new SongsDao();
		return dao.getSongBySongName(songName);
	}

	/**
	 * this method calls the addsong dao
	 * 
	 * @param detail
	 * @return
	 */
	public static boolean addSong(Song detail) {
		SongsDao dao = new SongsDao();
		return dao.addSongs(detail);

	}

	/**
	 * this method calls the dao which checks for the song is available or not
	 * 
	 * @param detail
	 * @return
	 */
	public static boolean isSongAvailable(Song details) {
		SongsDao dao = new SongsDao();
		return dao.isSongAlreadyAvailable(details);
	}

	/**
	 * this method calls the dao which deletes the song from database
	 * 
	 * @param details
	 * @return
	 */
	public static boolean deleteSong(Song details) {
		SongsDao dao = new SongsDao();
		return dao.deleteSong(details);
	}

	/**
	 * this method calls the validator class and returns boolean value
	 * 
	 * @param details
	 * @return
	 */

	public static boolean isValidDetails(Song details) {
		boolean isValidSongName = Validator.stringValidator(details.getSongName())
				&& SongsValidator.validlengthforSong(details.getSongName());
		boolean isValidLanguageName = (LanguageValidator.isValidLanguage(details.getLanguage()))
				&& (LanguageValidator.validlengthforLanguage(details.getLanguage()));
		boolean isValidMovieName = Validator.stringValidator(details.getMovieName());

		return isValidLanguageName && isValidMovieName && isValidSongName;
	}

	/**
	 * This method is used to retrieve song from database
	 * 
	 * @param countryName
	 * @return
	 */
	public static byte[] getSongSource(String songName) {
		SongsDao dao = new SongsDao();
		byte[] songSource;
		try {
			songSource = dao.getSong(songName);
		} catch (DbException e) {
			throw new ServicesException("unable to retireve songSource" + e.getMessage());

		}
		return songSource;
	}

	/**
	 * this method add the songsource and image source in the database
	 * 
	 * @param song
	 * @return
	 */
	public static boolean addSongSource(SongsDto song) {
		SongsDao dao = new SongsDao();

		return dao.addSongSourceAndImage(song);
	}

	/**
	 * this method checks for user already liked a song
	 * 
	 * @param details
	 * @return
	 */
	public static boolean isUserAlreadyLiked(LikedSongsDto details) {
		SongsDao dao = new SongsDao();
		return dao.isUserAlreadyLiked(details);

	}

	/**
	 * this method add the song and username in database
	 * 
	 * @param details
	 * @return
	 */
	public static boolean addLikedSongs(LikedSongsDto details) {
		SongsDao dao = new SongsDao();
		return dao.addLikedSongs(details);
	}

	/**
	 * this method get the list of top10 songs
	 * 
	 * @return
	 */
	public static List<Song> getTopSongs() {
		SongsDao dao = new SongsDao();
		return dao.getTopSongs();
	}
	/**
	 * this method returns true if song source is already available
	 * @param songSource
	 * @return
	 */
	public static boolean isSongSourceAvailable(String songSource)
	{
		SongsDao dao=new SongsDao();
		return dao.isSongSourceAvailable(songSource);
		
	}
	/**
	 * this method returns true is song available 
	 * @param songName
	 * @return
	 */
	public static boolean isSongAvailableInSongsDatabase(String songName)
	{
		SongsDao dao=new SongsDao();
		return dao.isSongAvailable(songName);
	}
}
