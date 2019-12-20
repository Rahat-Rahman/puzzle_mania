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

public class HighScoreDAO {

	private Connection mycon;
	public HighScoreDAO()
	{
		try{
			mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/puzzlemaniadb","root","");
		}
		
		catch(Exception ex){
			JOptionPane.showMessageDialog(null,"Connection Unsuccessful");
			
		}
		
	}
	
	public ArrayList<highscore> GetAllScores()
	{
		ArrayList<highscore> scores = new ArrayList<highscore>();
		Statement myStatement = null;
		ResultSet myResultSet = null;
		
		try{
			if(mycon==null)
			{
				throw(new Exception("Connection unsuccessful"));
			}
			myStatement = mycon.createStatement();
			myResultSet= myStatement.executeQuery("select * from highscore order by moves");
		    int i=1;
			while(myResultSet.next() && i<=5)
			{
				highscore H= ConvertRowToScore(myResultSet);
				scores.add(H);
				i++;
			}
			
		}
		
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
		finally{
			close(myStatement,null,myResultSet);
		}
		
		return scores;
		
	}
	

	
	public boolean DeleteHighScore(int moves)
	{
		PreparedStatement myStatement= null;
		
		try
		{
			myStatement= mycon.prepareStatement("Delete from highscore where moves=?");
			myStatement.setInt(1, moves);
			int row = myStatement.executeUpdate();
			
			return row>0;
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
		finally{
			close(null,myStatement,null);
		}
		
		
		return false;
	}
	
	public highscore GetById(int id)
	{
		highscore hs=new highscore();
		hs.setId(id);
		ArrayList<highscore> scoress = new ArrayList<highscore>();
		Statement myStatement = null;
		ResultSet myResultSet = null;
		
		try{
			if(mycon==null)
			{
				throw(new Exception("Connection unsuccessful"));
			}
			myStatement = mycon.createStatement();
			myResultSet= myStatement.executeQuery("select * from highscore where Id="+id);
		
			if(myResultSet.next())
				hs=ConvertRowToScore(myResultSet);
			
		}
		
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
		finally{
			close(myStatement,null,myResultSet);
		}
		
		
		return hs;
	}
	
    public boolean InsertUser(highscore hscore)
    {
    	PreparedStatement myStatement=null;
    	
    	try{
         myStatement= mycon.prepareStatement("Insert into highscore values(?,?,?,?)");
         
         myStatement.setString(1,hscore.getName());
         myStatement.setInt(2,hscore.getId());
         myStatement.setInt(3,hscore.getTime());
         myStatement.setInt(4,hscore.getMoves());
         
         int i=myStatement.executeUpdate();
         
         return i>0;
    	
    	
    	}
    	catch(Exception ex)
    	{
    		JOptionPane.showMessageDialog(null,ex.getMessage());
    	}
    	finally{
			close(null,myStatement,null);
		}
    	return false;
    }
    
   
    
    
    private highscore ConvertRowToScore(ResultSet myResultSet) throws SQLException
	{
		 highscore s = new highscore();
		
		s.setId(myResultSet.getInt("id"));
		s.setName(myResultSet.getString("Name"));
		s.setMoves(myResultSet.getInt("moves"));
		s.setTime(myResultSet.getInt("time"));
		
		return s;
		
		
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
