package in.gokul.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.gokul.exception.DbException;

public class ConnectionUtil {
	private ConnectionUtil() {

	}
   /**
    * this method gets the connection to the database using system variables.
    * @return
    */
	public static Connection getConnection() {
		try {
			Class.forName(System.getenv("spring.datasource.driver-class-name"));
			return DriverManager.getConnection(System.getenv("spring.datasource.url"),
					System.getenv("spring.datasource.username"), System.getenv("spring.datasource.password"));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DbException("Can't establish connection");
		}
	}
   /**
    * This method closes the connection and prepared statement 
    * @param pst
    * @param con
    */
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
	/**
	 * This method closes the resultSet, preparedStatement and connection
	 * @param res
	 * @param pst
	 * @param con
	 */
	public static void close(ResultSet res,PreparedStatement pst, Connection con) {
		try {
			if (con != null) {
				con.close();

			}
			if (pst != null) {
				pst.close();

			}
			if(res!=null)
			{
				res.close();
			}

		} catch (SQLException e) {
			throw new DbException("INVALID CONNECTION");
		}
	}

}
