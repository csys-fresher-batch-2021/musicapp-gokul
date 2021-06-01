package in.gokul.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.gokul.exception.DbException;
import in.gokul.model.Language;
import in.gokul.util.ConnectionUtil;

public class DeleteLanguageDao {
	public boolean  deleteLanguage(Language language) 
	   {
		PreparedStatement pst=null;
		Connection connection=null;
	    boolean deleted=false;
		try {
			connection=ConnectionUtil.getConnection();
			String sql="delete from language where language_name=?";
			pst=connection.prepareStatement(sql);
			pst.setString(1,language.getLanguage());
			int result=pst.executeUpdate();
			deleted=(result==1);
			return deleted;
		}
		catch (DbException | SQLException e) {
			throw new DbException("Cannot delete language from the database"+e.getMessage());

		}
		finally
		{
		   ConnectionUtil.close(pst,connection);
			
		}
		
		}
	//hello

}
