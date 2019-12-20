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

import TableModelLayer.UserTableModel;
import DAOLayer.*;
import EntityLayer.*;
import HelperLayer.LoginHelper;


public class SpecificUser extends JFrame{
	
private JPanel upperPanel;
private JPanel lowerPanel;

private JLabel lblupdate,lblName,lblPassword,lblDOB,lblUpdatePic,lblArrowPic,lblGameName;
private JTextField txtInputName,txtInputPassword,txtInputDOB;

private JButton btnUpdate,btnBack;

//private JTable tblUsers;
private UserDAO userdao;

private levelViewer showLevelPage;
private User user;
private UpdateDAO updatedao;

//public SpecificUser(levelViewer showLevel,int id,UpdateDAO dao)
public SpecificUser(levelViewer showLevel)
{
	showLevelPage=showLevel;
	updatedao=new UpdateDAO();
	user=updatedao.GetById(LoginHelper.loginUser.getId());
	
	
	
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
	this.lowerPanel.setBackground(Color.WHITE);
	add(this.lowerPanel);
	
	this.AddUpperComponent();
	this.AddLowerComponent();
	this.populateData();
	
}

private void populateData()
{
	if(user.getId()==-1)
		return;
	
	txtInputName.setText(user.getName());
	txtInputPassword.setText(user.getPassword());
	txtInputDOB.setText(user.getDOB());
}

private void FillUser()
{
	user.setName(txtInputName.getText());
	user.setPassword(txtInputPassword.getText());
	user.setDOB(txtInputDOB.getText());
}

private void AddUpperComponent() {
	
	      lblupdate = new JLabel("Update Your Information Below and Press Update To Execute The Change");
	      this.upperPanel.add(lblupdate);

	      
          btnUpdate=new JButton("Update");
          btnUpdate.setBackground(Color.CYAN);
          btnUpdate.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//updatedao.UpdateUser(user);
				FillUser();
			    
			    boolean isSuccess=false;
			    
			    	isSuccess=updatedao.UpdateUser(user);
			    
			    if(isSuccess)
			    {
			    	JOptionPane.showMessageDialog(null, "Operation Complited");
			    	//setVisible(false);
			    	
			    }
				
			}
        	  
        	  
          });
          this.upperPanel.add(btnUpdate);
          
          btnBack=new JButton("Back");
          this.upperPanel.add(btnBack);
          btnBack.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					 setVisible(false);
	        	      showLevelPage.setVisible(true);
				}
				});

}



private void AddLowerComponent() {
        this.setLayout(null);
        
        lblName=new JLabel("Name");
        lblName.setBounds(20,20,70,35);
        this.lowerPanel.add(lblName);
        
        lblPassword=new JLabel("Password");
        lblPassword.setBounds(20,80,70,35);
        this.lowerPanel.add(lblPassword);
        
        lblDOB=new JLabel("DOB");
        lblDOB.setBounds(20,135,70,35);
        this.lowerPanel.add(lblDOB);
        
        txtInputName=new JTextField(50);
        txtInputName.setBounds(100,20,120,35);
        this.lowerPanel.add(txtInputName);
        
        txtInputPassword=new JTextField(50);
        txtInputPassword.setBounds(100,80,120,35);
        this.lowerPanel.add(txtInputPassword);
        
        txtInputDOB=new JTextField(50);
        txtInputDOB.setBounds(100,135,120,35);
        this.lowerPanel.add(txtInputDOB);
        
        ImageIcon icon = new ImageIcon(new ImageIcon(this.getClass().getResource("updateinfo.gif")).getImage().getScaledInstance(200,120, java.awt.Image.SCALE_DEFAULT));
    	lblUpdatePic=new JLabel(icon);
		this.lblUpdatePic.setBounds(250,0,260,220);
		lowerPanel.add(lblUpdatePic);
		
    
        ImageIcon icon2 = new ImageIcon(new ImageIcon(this.getClass().getResource("pzl5.gif")).getImage().getScaledInstance(450,60, java.awt.Image.SCALE_DEFAULT));
		lblGameName=new JLabel(icon2);
		this.lblGameName.setBounds(60,300,600,90);
		lowerPanel.add(lblGameName);
	}
}

