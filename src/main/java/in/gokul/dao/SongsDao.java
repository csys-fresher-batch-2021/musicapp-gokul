package in.gokul.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import in.gokul.exception.DbException;

import in.gokul.model.Song;
import in.gokul.util.ConnectionUtil;

public class SongsDao {
	/**
	 * This method fetches all the languages from the database musify and returns in 
	 * the form of list
	 * 
	 * @return
	 */
	public List<Song> getAllLanguageSongs() {
		List<Song> songsList = new ArrayList<>();
		String selectSQLQuery = "SELECT * FROM Songs";
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionUtil.getConnection();
			prepareStatement = connection.prepareStatement(selectSQLQuery);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				String songName=resultSet.getString("song_Name");
				String movieName = resultSet.getString("movie_Name");
				String languageName = resultSet.getString("language_name");

				Song input = new Song(songName, movieName, languageName);
				songsList.add(input);
			}
		} catch (DbException | SQLException e) {
			e.printStackTrace();
			throw new DbException("Can't get songs from database");
		} finally {
			ConnectionUtil.close(resultSet, prepareStatement, connection);
		}
		return songsList;
	}
	/**
	 * This dao method will get the connection and execute the query.
	 * @param songName
	 * @return
	 */
	public List<Song> getSongBySongName(Song songName)
	{
	
		List<Song>songList=new ArrayList<>();
		String query=" Select * from Songs where song_Name ilike '%"+songName.getSongName()+"%';";

		Connection con=null;
		PreparedStatement pst=null;
		ResultSet resultSet=null;
		Song input=null;
		try {
			con=ConnectionUtil.getConnection();
			pst=con.prepareStatement(query);
			
			resultSet=pst.executeQuery();
	
			while(resultSet.next())
			{
				String song=resultSet.getString("song_Name");
				String movie=resultSet.getString("movie_Name");
				String language=resultSet.getString("language_name");
			
				input = new Song(song, movie, language);
				songList.add(input);
				
			}
		
		} catch (SQLException e) {

			e.printStackTrace();
			throw new DbException(e.getMessage());
		}finally {
			ConnectionUtil.close(resultSet, pst, con);
		}
		
		
	
	return songList;
	}
	/**
	 * this method adds the song in the database
	 * @param list
	 * @return
	 */
	public boolean addSongs(Song list) {
		PreparedStatement pst = null;
		Connection connection = null;
		int result = 0;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "insert into songs(song_name,movie_Name,language_name,released_on) values (?,?,?,?)";
			pst = connection.prepareStatement(sql);

			pst.setString(1, list.getSongName());
			pst.setString(2, list.getMovieName());
			pst.setString(3, list.getLanguage());
			pst.setDate(4, list.getReleasedOn());

			result = pst.executeUpdate();

			return (result == 1);
		} catch (DbException | SQLException e) {
			e.printStackTrace();
			throw new DbException("Cannot add Songs into the songs database " + e.getMessage());

		}

		finally {
			ConnectionUtil.close(pst, connection);

		}

	}
	/**
	 * this method return true if song is already in the database
	 * @param detail
	 * @return
	 */
	public boolean isSongAlreadyAvailable(Song details) {

		String selectSQLQuery ="select exists ((select song_name movie_Name from songs where song_Name =? and movie_Name=?) )";
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		boolean isExists = false;
		try {
			connection = ConnectionUtil.getConnection();
			prepareStatement = connection.prepareStatement(selectSQLQuery);
			prepareStatement.setString(1, details.getSongName());
			prepareStatement.setString(2, details.getMovieName());
	
			
			
            resultSet = prepareStatement.executeQuery();
			if (resultSet.next()) {
				isExists = resultSet.getBoolean("exists");

			}
		} catch (DbException | SQLException e) {
			e.printStackTrace();
			throw new DbException("Can't check song from database ");
		} finally {
			ConnectionUtil.close(prepareStatement, connection);
		}
		return isExists;
	}
	public boolean deleteSong(Song details)
	{
		PreparedStatement pst = null;
		Connection connection = null;
		int result = 0;
		try {

			connection = ConnectionUtil.getConnection();
			String sql = "delete from songs where song_Name=? and movie_Name=?";
			pst = connection.prepareStatement(sql);

			
			pst.setString(1, details.getSongName());
			pst.setString(2, details.getMovieName());

			result = pst.executeUpdate();

			return (result == 1);
		} catch (DbException | SQLException e) {
			e.printStackTrace();
			throw new DbException("Cannot delete Songs from the database " + e.getMessage());

		}

		finally {
			ConnectionUtil.close(pst, connection);
		}

		
	}

}
