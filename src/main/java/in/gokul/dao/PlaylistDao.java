package in.gokul.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import in.gokul.dto.PlaylistDto;
import in.gokul.exception.DbException;

import in.gokul.model.Playlist;

import in.gokul.util.ConnectionUtil;

public class PlaylistDao {
	/**
	 * this dao adds the songs in the playlist
	 * 
	 * @param list
	 * @return
	 */
	public boolean addSongsInPlaylist(Playlist list) {
		PreparedStatement pst = null;
		Connection connection = null;
		int result = 0;
		try {

			connection = ConnectionUtil.getConnection();
			String sql = "insert into playlist(playlist_name,user_id,song_id,created_on) values (?,(Select user_Id from userDetail where user_Name=?),(Select song_Id from songs where song_Name=?),'%"
					+ java.time.LocalDate.now() + "%')";
			pst = connection.prepareStatement(sql);

			pst.setString(1, list.getPlaylistName());
			pst.setString(3, list.getSongName().toUpperCase());
			pst.setString(2, list.getUserName().trim());

			result = pst.executeUpdate();

			return (result == 1);
		} catch (DbException | SQLException e) {
			e.printStackTrace();
			throw new DbException("Cannot add Songs into the playlist database" + e.getMessage());

		}

		finally {
			ConnectionUtil.close(pst, connection);

		}

	}

	/**
	 * this dao returns all the songs from the different playlist
	 * 
	 * @param details
	 * @return
	 */
	public Set<PlaylistDto> getPlaylist(PlaylistDto details) {

		Set<PlaylistDto> playlist = new LinkedHashSet<>();
		String query = "Select s.song_Name,s.movie_Name,s.language_name,s.released_on,created_on,playlist_name from songs s inner join playlist p on p.song_id=s.song_Id inner join userDetail u on p.user_id= u.user_id where u.user_Name=?";

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet resultSet = null;
		PlaylistDto input = null;
		try {
			con = ConnectionUtil.getConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, details.getUserName().trim());
		    
			resultSet = pst.executeQuery();

			while (resultSet.next()) {
				String song = resultSet.getString("song_Name");
				String movie = resultSet.getString("movie_Name");
				String language = resultSet.getString("language_name");
				String name = resultSet.getString("playlist_name");
				Date releasedOn = resultSet.getDate("released_on");
				Date createdOn = resultSet.getDate("created_on");

				input = new PlaylistDto(name, song, movie, language, releasedOn, createdOn);

				playlist.add(input);
			}
		} catch (SQLException e) {

			e.printStackTrace();
			throw new DbException("playlist not available" + e.getMessage());
		} finally {
			ConnectionUtil.close(resultSet, pst, con);
		}

		return playlist;
	}

	/**
	 * this dao method returns all playlist which is available for the specific user
	 * 
	 * @param userName
	 * @return
	 */
	public List<PlaylistDto> getAllPlaylist(String userName) {
		List<PlaylistDto> list = new ArrayList<>();
		String selectSQLQuery = " SELECT playlist_name FROM playlist p, userDetail u"
				+ " where u.user_id=p.user_id and u.user_Name= ? group by(playlist_name) ";
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionUtil.getConnection();
			prepareStatement = connection.prepareStatement(selectSQLQuery);
			prepareStatement.setString(1, userName.trim());
			resultSet = prepareStatement.executeQuery();

			while (resultSet.next()) {
				String playlistName = resultSet.getString("playlist_name").trim();

				PlaylistDto input = new PlaylistDto(playlistName);
				list.add(input);
			}
		} catch (DbException | SQLException e) {
			e.printStackTrace();
			throw new DbException("Can't get playlist from database");
		} finally {
			ConnectionUtil.close(resultSet, prepareStatement, connection);
		}
		return list;
	}

	/**
	 * this dao method checks for song and playlist is already added by the user
	 * 
	 * @param detail
	 * @return
	 */
	public boolean isPlaylistAndSongAlreadyAvailable(PlaylistDto detail) {

		String selectSQLQuery = "select exists( select playlist_name, song_name, user_name from playlist p"
				+ " inner join songs s on s.song_id = p.song_id"
				+ " inner join userDetail u on u.user_id = p.user_id where u.user_name = ? and p.playlist_name = ?"
				+ " and s.song_name = ?)";
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		boolean isExists = false;
		try {
			connection = ConnectionUtil.getConnection();
			prepareStatement = connection.prepareStatement(selectSQLQuery);
			prepareStatement.setString(1, detail.getUserName().trim());
			prepareStatement.setString(2, detail.getPlaylistName().trim());
			prepareStatement.setString(3, detail.getSongName().trim());

			resultSet = prepareStatement.executeQuery();
			if (resultSet.next()) {
				isExists = resultSet.getBoolean("exists");

			}
		} catch (DbException | SQLException e) {
			e.printStackTrace();
			throw new DbException("Can't get playlist from database");
		} finally {
			ConnectionUtil.close(prepareStatement, connection);
		}
		return isExists;
	}

	/**
	 * this dao method deletes the song from playlist database
	 * 
	 * @param list
	 * @return
	 */
	public boolean deleteSongsInPlaylist(Playlist list) {
		PreparedStatement pst = null;
		Connection connection = null;
		int result = 0;
		try {

			connection = ConnectionUtil.getConnection();
			String sql = "delete from playlist where playlist_name = ? and song_id = (Select song_id from songs where song_name = ? and user_id = (Select user_id from userDetail where user_Name = ?))";
			pst = connection.prepareStatement(sql);

			pst.setString(1, list.getPlaylistName().trim());
			pst.setString(2, list.getSongName().toUpperCase());
			pst.setString(3, list.getUserName().trim());

			result = pst.executeUpdate();

			return (result == 1);
		} catch (DbException | SQLException e) {
			e.printStackTrace();
			throw new DbException("Cannot delete Songs from the playlist database" + e.getMessage());

		}

		finally {
			ConnectionUtil.close(pst, connection);
		}

	}

}
