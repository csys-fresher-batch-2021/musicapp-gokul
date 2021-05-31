package in.gokul.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.gokul.exception.DbException;

import in.gokul.model.User;
import in.gokul.util.ConnectionUtil;

public class NewUserRegistrationDao {
	public boolean addNewUser(User user) {
		PreparedStatement pst = null;
		Connection connection = null;

		try {
			connection = ConnectionUtil.getConnection();
			String sql = "insert into userDetail (user_Name ,email_Id,mobile_Num,gender,age,pass_word) values (?,?,?,?,?,?)";
			pst = connection.prepareStatement(sql);
			pst.setString(1, user.getUserName());
			pst.setString(2, user.getEmailId());
			pst.setLong(3, user.getMobileNumber());
			pst.setString(4, user.getGender());
			pst.setInt(5, user.getAge());
			pst.setString(6, user.getPassword());

			int result = pst.executeUpdate();
			return (result == 1);
		} catch (DbException | SQLException e) {
			e.printStackTrace();
			throw new DbException("Cannot add user into the database" + e.getMessage());

		} finally {
			ConnectionUtil.close(pst, connection);

		}

	}
}
