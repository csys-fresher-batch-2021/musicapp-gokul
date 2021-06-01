package in.gokul.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.gokul.exception.DbException;
import in.gokul.model.Language;
import in.gokul.util.ConnectionUtil;

public class AddLanguageDao {
	
public boolean  addLanguage(Language language) 
   {
	PreparedStatement pst=null;
	Connection connection=null;
 
	try {
		connection=ConnectionUtil.getConnection();
		String sql="insert into language(language_name)values(?)";
		pst=connection.prepareStatement(sql);
		pst.setString(1,language.getLanguage());
		int result=pst.executeUpdate();
		return (result==1);
	}
	catch (DbException | SQLException e) {
		e.printStackTrace();
		throw new DbException("Cannot add language into the database"+e.getMessage());

	}
	finally
	{
	   ConnectionUtil.close(pst,connection);
		
	}
	
	}
}
