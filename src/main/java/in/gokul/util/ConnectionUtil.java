package in.gokul.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.gokul.exception.DbException;

public class ConnectionUtil {
	private ConnectionUtil() {

	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String driverClass = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost/Musify";
		String username = "postgres";
		String password = "Gokulram@26";
		Class.forName(driverClass);
		Connection connection = DriverManager.getConnection(url, username, password);
		System.out.println("Connection Created");
		return connection;
	}

	public static void close(PreparedStatement pst, Connection con) {
		try {
			if (con != null) {
				con.close();

			}
			if (pst != null) {
				pst.close();

			}

		} catch (SQLException e) {
			throw new DbException("INVALID CONNECTION");
		}
	}
}
