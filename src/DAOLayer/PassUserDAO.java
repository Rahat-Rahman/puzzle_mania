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

public class PassUserDAO {

	private Connection mycon;
	public PassUserDAO()
	{
		try{
			mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/puzzlemaniadb","root","");
		}
		
		catch(Exception ex){
			JOptionPane.showMessageDialog(null,"Connection Unsuccessful");
			
		}
		
	}
	public User Login(String Name,String Password)
	{
		User u = new User();
		u.setId(-1);
		
		Statement myStatement = null;
		ResultSet myResult = null;
		try
		{
			myStatement= mycon.createStatement();
			myResult = myStatement.executeQuery("Select * from User where Name='"+Name+"' and Password='"+Password+"' ");
			
			if(myResult.next())
				u = ConvertRowToUser(myResult);
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		
		return u;
	}
	
	
	
//	
//	public ArrayList<User> GetAllUser()
//	{
//		ArrayList<User> users = new ArrayList<User>();
//		Statement myStatement = null;
//		ResultSet myResultSet = null;
//		
//		try{
//			if(mycon==null)
//			{
//				throw(new Exception("Connection unsuccessful"));
//			}
//			myStatement = mycon.createStatement();
//			myResultSet= myStatement.executeQuery("select * from user ");
//		
//			while(myResultSet.next())
//			{
//				User U= ConvertRowToUser(myResultSet);
//				users.add(U);
//			}
//			
//		}
//		
//		catch(Exception ex)
//		{
//			JOptionPane.showMessageDialog(null,ex.getMessage());
//		}
//		finally{
//			close(myStatement,null,myResultSet);
//		}
//		
//		return users;
//		
//	}
//	
//	public ArrayList<User> SearchUser(String key)
//	{
//		ArrayList<User> users = new ArrayList<User>();
//		Statement myStatement = null;
//		ResultSet myResultSet = null;
//		
//		try{
//			if(mycon==null)
//			{
//				throw(new Exception("Connection unsuccessful"));
//			}
//			myStatement = mycon.createStatement();
//			myResultSet= myStatement.executeQuery("select * from user where Name like '%"+key+"%' or Id like '%"+key+"%' ");
//		
//			while(myResultSet.next())
//			{
//				User U= ConvertRowToUser(myResultSet);
//				users.add(U);
//			}
//			
//		}
//		
//		catch(Exception ex)
//		{
//			JOptionPane.showMessageDialog(null,ex.getMessage());
//		}
//		finally{
//			close(myStatement,null,myResultSet);
//		}
//		
//		return users;
//		
//	}
//	
//	public boolean DeleteUser(int id)
//	{
//		PreparedStatement myStatement= null;
//		
//		try
//		{
//			myStatement= mycon.prepareStatement("Delete from user where Id=?");
//			myStatement.setInt(1, id);
//			int row = myStatement.executeUpdate();
//			
//			return row>0;
//		}
//		catch(Exception ex)
//		{
//			JOptionPane.showMessageDialog(null,ex.getMessage());
//		}
//		finally{
//			close(null,myStatement,null);
//		}
//		
//		
//		return false;
//	}
//	
//	public User GetById(int id)
//	{
//		User uu=new User();
//		uu.setId(id);
//		ArrayList<User> users = new ArrayList<User>();
//		Statement myStatement = null;
//		ResultSet myResultSet = null;
//		
//		try{
//			if(mycon==null)
//			{
//				throw(new Exception("Connection unsuccessful"));
//			}
//			myStatement = mycon.createStatement();
//			myResultSet= myStatement.executeQuery("select * from user where Id="+id);
//		
//			if(myResultSet.next())
//				uu=ConvertRowToUser(myResultSet);
//			
//		}
//		
//		catch(Exception ex)
//		{
//			JOptionPane.showMessageDialog(null,ex.getMessage());
//		}
//		finally{
//			close(myStatement,null,myResultSet);
//		}
//		
//		
//		return uu;
//	}
//	
//    public boolean InsertUser(User user)
//    {
//    	PreparedStatement myStatement=null;
//    	
//    	try{
//         myStatement= mycon.prepareStatement("Insert into user values(?,?,?,?)");
//         
//         myStatement.setString(1,user.getName());
//         myStatement.setInt(2,user.getId());
//         myStatement.setString(3,user.getPassword());
//         myStatement.setString(4,user.getDOB());
//         
//         int i=myStatement.executeUpdate();
//         
//         return i>0;
//    	
//    	
//    	}
//    	catch(Exception ex)
//    	{
//    		JOptionPane.showMessageDialog(null,ex.getMessage());
//    	}
//    	finally{
//			close(null,myStatement,null);
//		}
//    	return false;
//    }
//    
//    public boolean UpdateUser(User user)
//    {
//    	
//    	try{
//    		PreparedStatement myStatement= mycon.prepareStatement("Update user set Name=?,Password=?,DOB=? where Id=?");
//         
//         myStatement.setString(1,user.getName());
//         myStatement.setString(2,user.getPassword());
//         myStatement.setString(3,user.getDOB());
//         
//         myStatement.setInt(4,user.getId());
//         
//         int i=myStatement.executeUpdate();
//         
//         return i>0;
//    	
//    	
//    	}
//    	catch(Exception ex)
//    	{
//    		JOptionPane.showMessageDialog(null,ex.getMessage());
//    	}
//    	return false;
//    }
//    
//    
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
