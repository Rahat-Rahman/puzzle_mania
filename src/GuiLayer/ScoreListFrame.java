package GuiLayer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import TableModelLayer.HighScoreTableModel;
import DAOLayer.*;
import EntityLayer.highscore;


public class ScoreListFrame extends JFrame{
	
private JPanel upperPanel;
private JPanel lowerPanel;

private JLabel lblsearch;
private JTextField txtsearch;

private JButton btnDelete,btnBack;

private JTable tblScores;
private HighScoreDAO scoreDao;
private firstPage parentfstpage;

public ScoreListFrame(firstPage page )
{
	parentfstpage= page;
	this.setSize(750,560);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLayout(null);
	try
	{
		scoreDao= new HighScoreDAO();
	}
	catch(Exception ex)
	{
		System.out.println(ex);
	}
	
	upperPanel = new JPanel(new FlowLayout());
	this.upperPanel.setBorder(new LineBorder(Color.BLACK,1));
	this.upperPanel.setBounds(5,5,710,40);
	add(this.upperPanel);
	
	lowerPanel = new JPanel(null);
	this.lowerPanel.setBorder(new LineBorder(Color.RED,2));
	this.lowerPanel.setBounds(5,50,710,470);
	add(this.lowerPanel);
	
	this.AddUpperComponent();
	this.AddLowerComponent();
	
	
}


private void AddUpperComponent() {
	
	      lblsearch = new JLabel("High Scores ");
	      this.upperPanel.add(lblsearch);
	      
	      btnDelete=new JButton("Delete");
	      btnDelete.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					DeleteData();
					
				}
		    	    
		      });
	      this.upperPanel.add(btnDelete);
	      
	      btnBack= new JButton("");
		  btnBack.setBounds(5,5,37,20);
		  btnBack.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					parentfstpage.setVisible(true);
					
				}
				
			});
			ImageIcon icon3 = new ImageIcon(new ImageIcon(this.getClass().getResource("BackArrow.png")).getImage().getScaledInstance(32, 17, java.awt.Image.SCALE_SMOOTH));
			btnBack.setIcon(icon3);
			this.upperPanel.add(btnBack);

	      
}

private void ShowDetailFrame(int id){
	//SignUp su=new SignUp(this,id,userdao);
	//.setVisible(true);
}




private void AddLowerComponent() {
	tblScores = new JTable();
	tblScores.setBackground(Color.WHITE);
	JScrollPane sp= new JScrollPane();
	sp.setBounds(5,15,680,450);
	this.lowerPanel.add(sp);
	sp.setViewportView(tblScores);
	
	this.populateTable();
	
	
	
}

//private void showDetailFrame()
//{
//	UserDetailFrame udf=new UserDetailFrame(this);
//	udf.setVisible(true);
//}




public void populateTable() {
     
	ArrayList<highscore> scores = new ArrayList<highscore>();
	
	       scores = scoreDao.GetAllScores();

	
	HighScoreTableModel scoretablemodel= new HighScoreTableModel(scores);
	tblScores.setModel(scoretablemodel);
	
}

private void DeleteData()
{
	int row = tblScores.getSelectedRow();
	//JOptionPane.showConfirmDialog(null,row);
	
	if(row<0)
	{
		JOptionPane.showMessageDialog(null,"Please select a row first");
		return;
	}
	
	int moves= (int)tblScores.getValueAt(row,2);

	
	if(scoreDao.DeleteHighScore(moves))
		JOptionPane.showMessageDialog(null, "Deleted Successfully");
	else
		JOptionPane.showMessageDialog(null, "Deleted UnseccessFul");
	
	this.populateTable();
		
	
}


	
}

