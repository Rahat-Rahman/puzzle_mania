package GuiLayer;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import TableModelLayer.UserTableModel;
import DAOLayer.UserDAO;
import EntityLayer.User;

	public class GuestUser extends JFrame {

		private JLabel lblName,lblPassword,lblWelcome,lblGameName4;
		private JTextField txtName,txtCheck,txtType;
		private JButton btnLogin,btnSignUp,btnType,btnBack;
		Container C;
		
		private firstPage homeparentframe;
		private UserDAO userdao;
		
		public GuestUser(firstPage homeparent){
			homeparentframe=homeparent;
			this.setLayout(null);
			this.setSize(750,560);
			this.setTitle("Guest Appearance");
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setBackground(Color.RED);
		    this.setFocusable(true);
		    C=this.getContentPane();
		    C.setBackground(Color.WHITE);
		    C.setLayout(null);
		    
		    try
			{
				userdao= new UserDAO();
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
		    
		    this.addGuestComponent();
		}

		private void addGuestComponent() {
			// TODO Auto-generated method stub
			lblWelcome=new JLabel(" WELCOME TO IMAGE PUZZLE MANIA ...");
			lblWelcome.setBounds(30,70,650,60);
			lblWelcome.setForeground(Color.BLACK);
			lblWelcome.setFont(new Font("ALGERIAN",Font.ITALIC,35));
			add(lblWelcome);
			
			lblName=new JLabel(" Name : ");
			lblName.setBounds(40,135,70,50);
			add(lblName);
			
			lblPassword=new JLabel(" Type The Word :");
			lblPassword.setBounds(40,195,120,50);
			add(lblPassword);
			
			txtName=new JTextField(20);
			txtName.setBounds(140,135,120,50);
			add(txtName);
			
			txtCheck=new JTextField("Verify");
			//txtCheck.setText("Puzzle");
			txtCheck.setBounds(140,195,170,50);
			txtCheck.setForeground(Color.BLACK);
			txtCheck.setFont(new Font("Vivaldi",Font.ITALIC,30));
			txtCheck.setEditable(false);
			add(txtCheck);
			
			txtType=new JTextField(50);
			txtType.setBounds(320,195,120,50);
			add(txtType);
			
			btnType =new JButton(" Submit ");
			btnType.setBounds(270,260,80,40);
			btnType.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					
					if(txtCheck.getText().equals(txtType.getText()) && !txtName.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(null, "Successfully Verified");
						btnLogin.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Verify Unsuccessful... Try Again");
					}
				}
				
				
			});
			btnType.setBackground(Color.CYAN);
			btnType.setForeground(Color.BLACK);
			btnType.setFont(new Font("New Times Roman",Font.BOLD,12));
			add(btnType);
			
			
			
			btnLogin =new JButton(" Play As A Guest ");
			btnLogin.setBounds(140,350,130,40);
			btnLogin.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e) {
					
					ShowLevel();
				}
				
			});
			btnLogin.setBackground(Color.CYAN);
			btnLogin.setForeground(Color.BLACK);
			btnLogin.setFont(new Font("New Times Roman",Font.BOLD,12));
			btnLogin.setVisible(false);
			add(btnLogin);
			
			
			btnSignUp =new JButton(" Sign up for The Game");
			btnSignUp.setBounds(305,350,180,40);
			btnSignUp.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e) {
					
					ShowSignUp();
					ShowDetailFrame(-1);
				}
				
			});
			btnSignUp.setBackground(Color.RED);
			btnSignUp.setForeground(Color.BLACK);
			btnSignUp.setFont(new Font("New Times Roman",Font.BOLD,12));
			add(btnSignUp);
			
			btnBack= new JButton("");
			btnBack.setBounds(5,5,37,20);
			btnBack.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					homeparentframe.setVisible(true);
					
				}
				
			});
			ImageIcon icon3 = new ImageIcon(new ImageIcon(this.getClass().getResource("BackArrow.png")).getImage().getScaledInstance(35, 20, java.awt.Image.SCALE_SMOOTH));
			btnBack.setIcon(icon3);
			add(btnBack);
			
			ImageIcon icon4 = new ImageIcon(new ImageIcon(this.getClass().getResource("pzl4.gif")).getImage().getScaledInstance(450,60, java.awt.Image.SCALE_DEFAULT));
			lblGameName4=new JLabel(icon4);
			this.lblGameName4.setBounds(60,400,600,90);
			C.add(lblGameName4);
			
			
			
		}
		private void ShowLevel(){
			levelViewer2 lv1=new levelViewer2(this);
			lv1.setVisible(true);
		    setVisible(false);
		}
		private void ShowSignUp(){
			SignUp s1=new SignUp(this);
			//s1.setVisible(true);
		    setVisible(false);
		}
		
		private void ShowDetailFrame(int id){
			SignUp sp=new SignUp(this,id,userdao);
			sp.setVisible(true);
		}
		public void populateTable() {
		     
			ArrayList<User> users = new ArrayList<User>();
			
			UserTableModel usertablemodel= new UserTableModel(users);
			
			
		}
		
		
		
	}


