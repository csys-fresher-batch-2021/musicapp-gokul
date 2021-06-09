package in.gokul.services;

import java.util.List;
import java.util.Set;

import in.gokul.dao.PlaylistDao;
import in.gokul.dto.PlaylistDto;
import in.gokul.model.Playlist;

public class PlaylistServices {

	private PlaylistServices() {

	}

	/**
	 * this method calls the playlistDao and returns true if successfully added
	 * 
	 * @param list
	 * @return
	 */
	public static boolean addSongInPlaylist(Playlist list) {
		PlaylistDao dao = new PlaylistDao();
		return dao.addSongsInPlaylist(list);
	}

	/**
	 * this method returns list of type playlistdto
	 * 
	 * @param playlistname
	 * @return
	 */
	public static Set<PlaylistDto> getPlaylistSongs(PlaylistDto detail) {
		PlaylistDao dao = new PlaylistDao();
		return dao.getPlaylist(detail);
	}

	public static List<PlaylistDto> getAllPlaylist(String username) {
		PlaylistDao dao = new PlaylistDao();
		return dao.getAllPlaylist(username);
	}

	/**
	 * This method calls the dao which checks for the playlistname and song is
	 * already available
	 * 
	 * @param detail
	 * @return
	 */
	public static boolean isPlaylistAndSongAlreadyAVailable(PlaylistDto detail) {
		PlaylistDao dao = new PlaylistDao();
		return dao.isPlaylistAndSongAlreadyAvailable(detail);

	}

	/**
	 * this method calls the deletesongdao
	 * 
	 * @param list
	 * @return
	 */
	public static boolean deleteSongInPlaylist(Playlist list) {
		PlaylistDao dao = new PlaylistDao();
		return dao.deleteSongsInPlaylist(list);
	}

}
