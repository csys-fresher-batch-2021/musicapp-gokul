package in.gokul.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.gokul.exception.DbException;
import in.gokul.model.Admin;

import in.gokul.util.ConnectionUtil;

public class AdminLoginDao {
	private AdminLoginDao()
	{
		
	}
	public static Admin adminLogin(Admin admin)
	
	{
    String selectSQLQuery = " SELECT * FROM  adminDetails where admin_Name=?  ";
	Connection connection = null;
	PreparedStatement prepareStatement = null;
	ResultSet resultSet = null;
	Admin adminDetail = null;
	try {
		connection = ConnectionUtil.getConnection();
		prepareStatement = connection.prepareStatement(selectSQLQuery);
		prepareStatement.setString(1, admin.getAdminName());
		resultSet = prepareStatement.executeQuery();
		while (resultSet.next()) {
			String adminName = resultSet.getString("admin_Name");
			String password = resultSet.getString("pass_word");

			adminDetail = new Admin(adminName, password);

		}
	} catch (DbException | SQLException e) {
		e.printStackTrace();
		throw new DbException("Can't get admin  from database");
	} finally {
		ConnectionUtil.close(resultSet, prepareStatement, connection);
	}
	return adminDetail;

		
	}

}
