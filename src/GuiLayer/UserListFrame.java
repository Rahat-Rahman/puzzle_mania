package GuiLayer;

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

import TableModelLayer.UserTableModel;
import DAOLayer.*;
import EntityLayer.*;
import EntityLayer.User;


public class UserListFrame extends JFrame{
	
private JPanel upperPanel;
private JPanel lowerPanel;

private JLabel lblsearch;
private JTextField txtsearch;

private JButton btnUpdate,btnAdd,btnSearch,btnDelete;

private JTable tblUsers;
private UserDAO userdao;

public UserListFrame()
{
	this.setSize(750,560);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLayout(null);
	try
	{
		userdao= new UserDAO();
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
	
	      lblsearch = new JLabel("Input ID to Update : ");
	      this.upperPanel.add(lblsearch);
	      
	      txtsearch = new JTextField(10);
	      this.upperPanel.add(txtsearch);
	      
	      btnSearch=new JButton("Search");
	      btnSearch.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				populateTable();
				
			}
	    	    
	      });
	      this.upperPanel.add(btnSearch);
         
         
         btnAdd=new JButton("Add");
         btnAdd.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					ShowDetailFrame(-1);
					
				}
		    	    
		      });
	      this.upperPanel.add(btnAdd);
	      
}

private void ShowDetailFrame(int id){
	//SignUp su=new SignUp(this,id,userdao);
	//.setVisible(true);
}




private void AddLowerComponent() {
	tblUsers = new JTable();
	tblUsers.setBackground(Color.WHITE);
	JScrollPane sp= new JScrollPane();
	sp.setBounds(5,15,680,450);
	this.lowerPanel.add(sp);
	sp.setViewportView(tblUsers);
	
	this.populateTable();
	
	
	
}

//private void showDetailFrame()
//{
//	UserDetailFrame udf=new UserDetailFrame(this);
//	udf.setVisible(true);
//}




public void populateTable() {
     
	ArrayList<User> users = new ArrayList<User>();
	
	if(txtsearch.getText().isEmpty())
	       users =  userdao.GetAllUser();
	
	else
	    users=userdao.SearchUser(txtsearch.getText());
	
	UserTableModel usertablemodel= new UserTableModel(users);
	tblUsers.setModel(usertablemodel);
	
}


	
}

