package GuiLayer;
import TableModelLayer.*;
import DAOLayer.*;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;





public class levelViewer extends JFrame{
	
	
	private JLabel lblGameName2,lblTitle1,lblTitle2,lblUserPro;
	private JButton btnEasy,btnHard,btnProfile,btnBack,btnBack2;
	Container C1;
	
	private Userlogin userpageframe;
	
	private UpdateDAO updatedao;
	
	
	public levelViewer(Userlogin userpage){
		
		
		userpageframe=userpage;
		this.setLayout(null);
		this.setSize(750,560);
		this.setTitle("Choose Level");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.RED);
	    this.setFocusable(true);
	    C1=this.getContentPane();
	    C1.setBackground(Color.WHITE);
	    C1.setLayout(null);
	    
	    
	    this.addLevelComponent();
	}
	
	private void addLevelComponent(){
		
		this.setLayout(null);
		
		ImageIcon icon = new ImageIcon(new ImageIcon(this.getClass().getResource("level1.jpg")).getImage().getScaledInstance(550,400, java.awt.Image.SCALE_SMOOTH));
		//panel1.setImage(icon);
		
		lblTitle1=new JLabel(icon);
		this.lblTitle1.setBounds(5, 5, icon.getIconWidth()-30,icon.getIconHeight()+40);
		C1.add(lblTitle1);
		
		ImageIcon icon2 = new ImageIcon(new ImageIcon(this.getClass().getResource("pzl2.gif")).getImage().getScaledInstance(450,60, java.awt.Image.SCALE_DEFAULT));
		lblGameName2=new JLabel(icon2);
		this.lblGameName2.setBounds(10,icon.getIconHeight()+20,600,90);
		C1.add(lblGameName2);
		
		lblUserPro=new JLabel(" USER PROFILES:");
		lblUserPro.setBounds(525,50,200,50);
		lblUserPro.setForeground(Color.BLACK);
		lblUserPro.setFont(new Font("Algerian",Font.BOLD,23));
		add(lblUserPro);
		
		btnProfile=new JButton(" Click Here ");
		btnProfile.setBackground(Color.WHITE);
		btnProfile.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

				ShowSpecificUser();
			}
	      });
				
				
				
		
		btnProfile.setFont(new Font("Times New Roman",Font.BOLD,20));
		btnProfile.setBounds(540,110,175,50);
		this.add(btnProfile);
		
		lblTitle2=new JLabel(" LEVEL :");
		lblTitle2.setBounds(520,200,200,50);
		lblTitle2.setForeground(Color.BLACK);
		lblTitle2.setFont(new Font("Algerian",Font.BOLD,40));
		add(lblTitle2);
		
		btnEasy=new JButton(" EASY ");
		btnEasy.setBackground(Color.WHITE);
		btnEasy.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				showEasyFrame();
				
			}
			  
			
		});
		btnEasy.setFont(new Font("Times New Roman",Font.BOLD,20));
		btnEasy.setBounds(570,260,120,60);
		this.add(btnEasy);
		
		btnHard=new JButton(" HARD ");
		btnHard.setBackground(Color.WHITE);
		btnHard.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				showHardFrame();
				
			}
			  
			
		});
		btnHard.setFont(new Font("Times New Roman",Font.BOLD,20));
		btnHard.setBounds(570,350,120,60);
		this.add(btnHard);
		
		btnBack= new JButton("");
		btnBack.setBounds(5,5,37,20);
		btnBack.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				userpageframe.setVisible(true);
				
				
			}
			
		});
		ImageIcon icon3 = new ImageIcon(new ImageIcon(this.getClass().getResource("BackArrow.png")).getImage().getScaledInstance(35, 20, java.awt.Image.SCALE_SMOOTH));
		btnBack.setIcon(icon3);
		add(btnBack);

	}
	private void showEasyFrame()
	{
		ChooseEasyFrame ef= new ChooseEasyFrame(this);
		ef.setVisible(true);
		setVisible(false);
	}
	
	private void showHardFrame()
	{
		ChooseHardFrame eh= new ChooseHardFrame(this);
		eh.setVisible(true);
		setVisible(false);
	}
//	private void ShowSpecificUser(int id)
//	{
//		SpecificUser ss=new SpecificUser(this,id,updatedao);
//		ss.setVisible(true);
//		setVisible(false);
//	}
	private void ShowSpecificUser()
	{
		SpecificUser ss=new SpecificUser(this);
		ss.setVisible(true);
		setVisible(false);
	}
	
}

