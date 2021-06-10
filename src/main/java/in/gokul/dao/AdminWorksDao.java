package in.gokul.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import in.gokul.exception.DbException;
import in.gokul.model.Language;
import in.gokul.util.ConnectionUtil;

public class AdminWorksDao {
	
	/**
	 * this method checks for the language already available in the database
	 * @param detail
	 * @return
	 */
	public boolean isLanguageAlreadyAvailable(Language detail) {

		String selectSQLQuery = "select exists( select language_name from language where language_name=?)";
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		boolean isExists = false;
		try {
			connection = ConnectionUtil.getConnection();
			prepareStatement = connection.prepareStatement(selectSQLQuery);
			prepareStatement.setString(1, detail.getLanguage().trim());
	

			resultSet = prepareStatement.executeQuery();
		
			if (resultSet.next()) {
				isExists = resultSet.getBoolean("exists");

			}
	
		} catch (DbException | SQLException e) {
			e.printStackTrace();
			throw new DbException("Can't check from language database");
		} finally {
			ConnectionUtil.close(prepareStatement, connection);
		}
		return isExists;
	}

}
