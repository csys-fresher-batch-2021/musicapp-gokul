package in.gokul.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.gokul.model.Language;
import in.gokul.util.ConnectionUtil;
import in.gokul.exception.DbException;

public class DisplaylanguageDao {
	/**
	 * This method fetches all the languages from the database musify and returns in
	 * the form of list
	 * 
	 * @return
	 */
	public List<Language> getAllLanguage() {
		List<Language> languageList = new ArrayList<>();
		String selectSQLQuery = "SELECT * FROM Language";
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionUtil.getConnection();
			prepareStatement = connection.prepareStatement(selectSQLQuery);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				String topicName = resultSet.getString("language_name");

				Language input = new Language(topicName);
				languageList.add(input);
			}
		} catch (DbException | SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new DbException("Can't get topics from database");
		} finally {
			ConnectionUtil.close(resultSet, prepareStatement, connection);
		}
		return languageList;
	}

}
