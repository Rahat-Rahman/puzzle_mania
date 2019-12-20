package DAOLayer;


import EntityLayer.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class UpdateDAO  {

	private Connection mycon;
	public UpdateDAO ()
	{
		try{
			mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/puzzlemaniadb","root","");
		}
		
		catch(Exception ex){
			JOptionPane.showMessageDialog(null,"Connection Unsuccessful");
			
		}
		
	}
	
	public ArrayList<User> GetAllUser()
	{
		ArrayList<User> users = new ArrayList<User>();
		Statement myStatement = null;
		ResultSet myResultSet = null;
		
		try{
			if(mycon==null)
			{
				throw(new Exception("Connection unsuccessful"));
			}
			myStatement = mycon.createStatement();
			myResultSet= myStatement.executeQuery("select * from user ");
		
			while(myResultSet.next())
			{
				User U= ConvertRowToUser(myResultSet);
				users.add(U);
			}
			
		}
		
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
		finally{
			close(myStatement,null,myResultSet);
		}
		
		return users;
		
	}
	

	public User GetById(int id)
	{
		User uu=new User();
		uu.setId(id);
		ArrayList<User> users = new ArrayList<User>();
		Statement myStatement = null;
		ResultSet myResultSet = null;
		
		try{
			if(mycon==null)
			{
				throw(new Exception("Connection unsuccessful"));
			}
			myStatement = mycon.createStatement();
			myResultSet= myStatement.executeQuery("select * from user where Id="+id);
		
			if(myResultSet.next())
				uu=ConvertRowToUser(myResultSet);
			
		}
		
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
		finally{
			close(myStatement,null,myResultSet);
		}
		
		
		return uu;
	}
	

    public boolean UpdateUser(User user)
    {
    	
    	try{
    		PreparedStatement myStatement= mycon.prepareStatement("Update user set Name=?,Password=?,DOB=? where Id=?");
         
         myStatement.setString(1,user.getName());
         myStatement.setString(2,user.getPassword());
         myStatement.setString(3,user.getDOB());
         myStatement.setInt(4,user.getId());
         
         int i=myStatement.executeUpdate();
         
         return i>0;
    	
    	
    	}
    	catch(Exception ex)
    	{
    		JOptionPane.showMessageDialog(null,ex.getMessage());
    	}
    	return false;
    }
    
    
    private User ConvertRowToUser(ResultSet myResultSet) throws SQLException
	{
		User u =new User();
		
		u.setId(myResultSet.getInt("Id"));
		u.setName(myResultSet.getString("Name"));
		u.setPassword(myResultSet.getString("Password"));
		u.setDOB(myResultSet.getString("DOB"));
		
		return u;
		
		
	}
	
	private void close(Statement myStatement,PreparedStatement preparedstatement,ResultSet myResult)
	{
		
		
		try{
			if(myStatement!=null)
				myStatement.close();
			
			if(myResult!=null)
				myResult.close();
			
			if(preparedstatement!=null)
				preparedstatement.close();
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
		
	}
	
}
