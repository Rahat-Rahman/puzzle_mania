package GuiLayer;

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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DAOLayer.PassUserDAO;
import EntityLayer.User;
import HelperLayer.LoginHelper;

public class Userlogin extends JFrame {

	private JLabel lblName,lblPassword,lblWelcome,lblGameName3;
	private JTextField txtName;
	private JPasswordField txtPassword;
	private JButton btnLogin,btnSignUp,btnBack;
	Container C;
	
	private firstPage homeparentframe;
	private PassUserDAO passdao;
	private User users;
	
	
	public Userlogin(firstPage homeparent){
		homeparentframe = homeparent;
		this.setLayout(null);
		this.setSize(750,560);
		this.setTitle("User Log in");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.RED);
	    this.setFocusable(true);
	    C=this.getContentPane();
	    C.setBackground(Color.WHITE);
	    C.setLayout(null);
	    passdao = new PassUserDAO();
	    
	    this.addGuestComponent();
	}

	private void addGuestComponent() {
		// TODO Auto-generated method stub
		lblWelcome=new JLabel(" WELCOME TO IMAGE PUZZLE MANIA ...");
		lblWelcome.setBounds(30,70,650,60);
		lblWelcome.setForeground(Color.BLACK);
		lblWelcome.setFont(new Font("ALGERIAN",Font.ITALIC,35));
		add(lblWelcome);
		
		
		ImageIcon icon2 = new ImageIcon(new ImageIcon(this.getClass().getResource("pzl3.gif")).getImage().getScaledInstance(450,60, java.awt.Image.SCALE_DEFAULT));
		lblGameName3=new JLabel(icon2);
		this.lblGameName3.setBounds(60,350,600,90);
		C.add(lblGameName3);
		
		lblName=new JLabel(" Name : ");
		lblName.setBounds(40,135,70,50);
		add(lblName);
		
		lblPassword=new JLabel(" Password : ");
		lblPassword.setBounds(40,195,70,50);
		add(lblPassword);
		
		txtName=new JTextField(20);
		txtName.setBounds(140,135,120,50);
		add(txtName);
		
		txtPassword=new JPasswordField(20);
		txtPassword.setBounds(140,195,120,50);
		add(txtPassword);
		
//		txtPassword=new JPasswordField(20);
//		txtPassword.setBounds(140,195,120,50);
//		add(txtPassword);
		
		btnLogin =new JButton(" Log in ");
		btnLogin.setBounds(140,260,80,40);
		btnLogin.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
			
				//levelShow();
				
				users = passdao.Login(txtName.getText(), txtPassword.getText());	
				
				if(users.getId()==-1)
					JOptionPane.showMessageDialog(null,"Invalid Username or password");
				else
				{
					LoginHelper.loginUser = users;
					levelShow();
				}
					
				
				
			}
			
		});
		btnLogin.setBackground(Color.CYAN);
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setFont(new Font("New Times Roman",Font.BOLD,12));
		add(btnLogin);
		
		
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
			
		
		ImageIcon icon = new ImageIcon(new ImageIcon(this.getClass().getResource("BackArrow.png")).getImage().getScaledInstance(35, 20, java.awt.Image.SCALE_SMOOTH));
		btnBack.setIcon(icon);
		add(btnBack);
		
		
		
	}
	private void levelShow()
	{
		levelViewer v1= new levelViewer(this);
		v1.setVisible(true);
		setVisible(false);
	}
	
	
	
}

