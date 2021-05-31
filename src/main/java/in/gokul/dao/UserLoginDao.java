package in.gokul.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.gokul.exception.DbException;

import in.gokul.model.User;
import in.gokul.util.ConnectionUtil;

public class UserLoginDao {
	private UserLoginDao()
	{
		
	}
	public static User getUserDetailsByUserName(User user) {

		String selectSQLQuery = " SELECT * FROM  userDetail where user_Name=?  ";
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		User userDetail = null;
		try {
			connection = ConnectionUtil.getConnection();
			prepareStatement = connection.prepareStatement(selectSQLQuery);
			prepareStatement.setString(1, user.getUserName());
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				String userName = resultSet.getString("user_Name");
				String password = resultSet.getString("pass_word");

				userDetail = new User(userName, password);

			}
		} catch (DbException | SQLException e) {
			e.printStackTrace();
			throw new DbException("Can't get user  from database");
		} finally {
			ConnectionUtil.close(resultSet, prepareStatement, connection);
		}
		return userDetail;
	}

}
