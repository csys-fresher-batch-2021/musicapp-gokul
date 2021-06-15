package in.gokul.dao;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.gokul.dto.LikedSongsDto;
import in.gokul.dto.PlaySongsDto;
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
				String songName = resultSet.getString("song_Name");
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
	 * 
	 * @param songName
	 * @return
	 */
	public List<Song> getSongBySongName(Song songName) {

		List<Song> songList = new ArrayList<>();
		String query = " Select * from Songs where song_Name ilike '%" + songName.getSongName() + "%';";

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet resultSet = null;
		Song input = null;
		try {
			con = ConnectionUtil.getConnection();
			pst = con.prepareStatement(query);

			resultSet = pst.executeQuery();

			while (resultSet.next()) {
				String song = resultSet.getString("song_Name");
				String movie = resultSet.getString("movie_Name");
				String language = resultSet.getString("language_name");

				input = new Song(song, movie, language);
				songList.add(input);

			}

		} catch (SQLException e) {

			e.printStackTrace();
			throw new DbException(e.getMessage());
		} finally {
			ConnectionUtil.close(resultSet, pst, con);
		}

		return songList;
	}

	/**
	 * this method adds the song in the database
	 * 
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
	 * 
	 * @param detail
	 * @return
	 */
	public boolean isSongAlreadyAvailable(Song details) {

		String selectSQLQuery = "select exists ((select song_name movie_Name from songs where song_Name =? and movie_Name=?) )";
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

	/**
	 * this dao deletes the song from songs database
	 * 
	 * @param details
	 * @return
	 */
	public boolean deleteSong(Song details) {
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

	/**
	 * This method is used to retrieve image from database
	 * 
	 * @param imageName
	 * @return
	 */
	public byte[] getSong(String songName) {
		Connection connection = null;
		Statement st = null;
		byte[] songBytes = null;
		try {
			connection = ConnectionUtil.getConnection();
			st = connection.createStatement();
			ResultSet rs = st.executeQuery("SELECT song FROM  song_source WHERE song_name ='" + songName + "'");
			if (rs != null) {
				while (rs.next()) {
					songBytes = rs.getBytes(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(st, connection);
		}
		return songBytes;

	}

	/**
	 * This method is used to retrieve songSource and respective image from database
	 * 
	 * @param imageName
	 * @return
	 */
	public boolean addSongSourceAndImage(PlaySongsDto details) {
		Connection connection = null;
		PreparedStatement ps = null;
		int res = 0;

		String sql = "insert into song_source (song_name,song,song_image)values(?,?,?)";
		try {
			connection = ConnectionUtil.getConnection();
			File imageFile = new File("D:\\projectMusic\\" + details.getImageSource());
			File songFile = new File("D:\\projectMusic\\" + details.getSongSource());

			try (FileInputStream fis1 = new FileInputStream(songFile);
					FileInputStream fis2 = new FileInputStream(imageFile)) {
				ps = connection.prepareStatement(sql);
				ps.setString(1, details.getSongName());
				ps.setBinaryStream(2, fis1, songFile.length());
				ps.setBinaryStream(3, fis2, imageFile.length());

				res = ps.executeUpdate();
			}

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(ps, connection);

		}
		return (res == 1);

	}

	/**
	 * this method checks for user already liked a song.
	 * 
	 * @param details
	 * @return
	 */
	public boolean isUserAlreadyLiked(LikedSongsDto details) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		boolean isExists = false;
		String sql = "Select exists(Select song_name from liked_songs where user_name=?and song_name=?)";
		try {
			con = ConnectionUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, details.getUserName());
			pst.setString(2, details.getSongName());
			rst = pst.executeQuery();
			if (rst.next()) {
				isExists = rst.getBoolean("exists");

			}
			return isExists;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(rst, pst, con);
		}
		return isExists;
	}

	/**
	 * this dao method adds the liked songs in the database
	 * 
	 * @param details
	 * @return
	 */
	public boolean addLikedSongs(LikedSongsDto details) {
		Connection con = null;
		PreparedStatement pst = null;
		String sql = "insert into liked_songs (song_name,user_name) values (?,?)";
		int result = 0;
		try {
			con = ConnectionUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, details.getSongName());
			pst.setString(2, details.getUserName());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			ConnectionUtil.close(pst, con);

		}
		return (result == 1);
	}

	public List<Song> getTopSongs() {
		List<Song> list = new ArrayList<>();

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		String sql = "select s.song_name, (select count(*) likes from liked_songs l where s.song_name = l.song_name) likes_count, "
				+ "s.movie_name, s.language_name, s.released_on from songs s where song_name in (select song_name from liked_songs) "
				+ "order by likes_count desc limit 10;";

		try {
			con = ConnectionUtil.getConnection();
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			while (rst.next()) {
				String songName = rst.getString("song_name");
				String movieName = rst.getString("movie_name");
				String languageName = rst.getString("language_name");
				Date releasedOn = rst.getDate("released_On");
				Song song = new Song(songName, movieName, releasedOn, languageName);
				list.add(song);

			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException("Cannot get Songs from database" + e.getMessage());
		} finally {
			ConnectionUtil.close(rst, pst, con);
		}

		return list;
	}
}
