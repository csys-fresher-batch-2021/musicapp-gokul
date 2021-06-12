package in.gokul.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.gokul.util.ConnectionUtil;

public class StyleDao {

	/**
	 * This method is used to retrieve image from database
	 * 
	 * @param imageName
	 * @return
	 */
	public byte[] retireveImage(String imageName) {
		Connection connection = null;
		Statement st = null;
		byte[] imgBytes = null;
		try {
			connection = ConnectionUtil.getConnection();
			st = connection.createStatement();
			ResultSet rs = st.executeQuery("SELECT image FROM  music_images WHERE image_name ='" + imageName + "'");
			if (rs != null) {
				while (rs.next()) {
					imgBytes = rs.getBytes(1);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(st, connection);
		}
		return imgBytes;

	}

	/**
	 * This method is used to retrieve song image from database
	 * 
	 * @param imageName
	 * @return
	 */
	public byte[] retireveSongImage(String songName) {
		Connection connection = null;
		Statement st = null;
		byte[] imgBytes = null;
		try {
			connection = ConnectionUtil.getConnection();
			st = connection.createStatement();
			ResultSet rs = st.executeQuery("SELECT song_image FROM  song_source WHERE song_name ='" + songName + "'");
			if (rs != null) {
				while (rs.next()) {
					imgBytes = rs.getBytes(1);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(st, connection);
		}
		return imgBytes;

	}

}
