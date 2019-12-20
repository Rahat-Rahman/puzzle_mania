package TableModelLayer;

import EntityLayer.*;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class UserTableModel extends AbstractTableModel {

	private String[] colNames={"Id","Name","Date of Birth"}; 
	private ArrayList<User> tblUser =new ArrayList<User>();
	
	public UserTableModel(ArrayList<User> users)
	{
		tblUser=users;
	}
	
	
	@Override
	public int getColumnCount() {
		return colNames.length;
	}

	@Override
	public int getRowCount() {
		return tblUser.size();
	}
	
	public String getColumnName(int col)
	{
		return colNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		User user=tblUser.get(row);
		
		switch(col)
		{
		case 0:
			return user.getId();
		case 1:
			return user.getName();
		case 2:
			return user.getDOB();
//		case 3:
//			return user.getPassword();
	    default:
	    	return user.getId();
		}
		
	}
}
	
