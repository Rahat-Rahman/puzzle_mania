package TableModelLayer;

import EntityLayer.highscore;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class HighScoreTableModel extends AbstractTableModel {

	private String[] colNames={"Id","Name","Moves","Times"}; 
	private ArrayList<highscore> tblScores =new ArrayList<highscore>();
	
	public HighScoreTableModel(ArrayList<highscore> scores)
	{
		tblScores=scores;
	}
	
	
	@Override
	public int getColumnCount() {
		return colNames.length;
	}

	@Override
	public int getRowCount() {
		return tblScores.size();
	}
	
	public String getColumnName(int col)
	{
		return colNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		highscore score=tblScores.get(row);
		
		switch(col)
		{
		case 0:
			return score.getId();
		case 1:
			return score.getName();
		case 2:
			return score.getMoves();
//		case 3:
//			return user.getPassword();
	    default:
	    	return score.getTime();
		}
		
	}
}
	
