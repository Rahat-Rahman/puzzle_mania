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
import javax.swing.JTextField;

import DAOLayer.UserDAO;
import EntityLayer.User;
import HelperLayer.ValidationHelper;

public class SignUp extends JFrame{
    private JLabel lblGameName5,lblTitleShow,lblInputName,lblInputId,lblInputPassword,lblInputDOB,lblSignPic,lblArrowPic;
    private JTextField txtInputName,txtInputId,txtInputPassword,txtInputDOB;
    
    private JButton btnBack,btnSignUp;
    Container C;
    private UserDAO userDao;
    private User user;
    private boolean isNew;
    int a;
    
    private GuestUser parentFrame;
   // private GuestUser guestuserpageframe;
    
    public SignUp(GuestUser parent){
    	parentFrame=parent;
    	//guestuserpageframe=guestuserpage;
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
	    
	    this.addSignUpComponent();
	     a=-1;
	    
	    
    }
    
    
    

    
    public SignUp(GuestUser parent, int id,UserDAO dao){
    	
    	parentFrame=parent;
    	userDao=dao;
    	user=userDao.GetById(id);
    	

    	this.setLayout(null);
		this.setSize(750,560);
		this.setTitle("Sign Up");
		this.setLocationRelativeTo(parentFrame);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.RED);
	    this.setFocusable(true);
	    C=this.getContentPane();
	    C.setBackground(Color.WHITE);
	    C.setLayout(null);
	    
	    this.addSignUpComponent();
	    this.populateData();
	    
	    
    }
    
    


	
	private void FillUser()
	{
		user.setName(txtInputName.getText());
		user.setId(Integer.parseInt(txtInputId.getText()));
		user.setPassword(txtInputPassword.getText());
		user.setDOB(txtInputDOB.getText());
	}
	
	
    



	private void addSignUpComponent() {
		// TODO Auto-generated method stub
		lblTitleShow=new JLabel(" Input Your Information to Sign-up ");
		lblTitleShow.setBounds(30,70,650,60);
		lblTitleShow.setForeground(Color.BLACK);
		lblTitleShow.setFont(new Font("ALGERIAN",Font.ITALIC,25));
		add(lblTitleShow);
		
		lblInputName=new JLabel(" Name : ");
		lblInputName.setBounds(40,135,70,40);
		add(lblInputName);
		
		lblInputId=new JLabel(" Id : ");
		lblInputId.setBounds(40,180,70,40);
		add(lblInputId);
		
		lblInputPassword=new JLabel(" Password : ");
		lblInputPassword.setBounds(40,225,70,40);
		add(lblInputPassword);

		lblInputDOB=new JLabel(" DOB : ");
		lblInputDOB.setBounds(40,270,70,50);
		add(lblInputDOB);
		
		txtInputName=new JTextField(20);
		txtInputName.setBounds(140,135,120,40);
		add(txtInputName);
		
		txtInputId=new JTextField(20);
		txtInputId.setBounds(140,180,120,40);
		add(txtInputId);
		
		txtInputPassword=new JTextField(20);
		txtInputPassword.setBounds(140,225,120,40);
		add(txtInputPassword);
		
		txtInputDOB=new JTextField(20);
		txtInputDOB.setBounds(140,270,120,40);
		add(txtInputDOB);
		
		ImageIcon icon = new ImageIcon(new ImageIcon(this.getClass().getResource("Sign Up.gif")).getImage().getScaledInstance(200,100, java.awt.Image.SCALE_DEFAULT));
    	lblSignPic=new JLabel(icon);
		this.lblSignPic.setBounds(350, 100,260,220);
		C.add(lblSignPic);
		
		ImageIcon icon1 = new ImageIcon(new ImageIcon(this.getClass().getResource("arrow.png")).getImage().getScaledInstance(100,80, java.awt.Image.SCALE_SMOOTH));
    	lblArrowPic=new JLabel(icon1);
		this.lblArrowPic.setBounds(400, 250,150,100);
		C.add(lblArrowPic);
		
		btnSignUp =new JButton(" Sign up and continue");
		btnSignUp.setBounds(140,320,200,40);
		if(a!=-1){
		btnSignUp.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
		
			if(!IsValidData())
			{
				
				  return;
			}				
		    FillUser();
		    
		    boolean isSuccess=false;
		    
		    
		    
		    if(isNew)
		    {
		    	isSuccess=userDao.InsertUser(user);
		    }
		    
		    if(isSuccess)
		    {
		    	JOptionPane.showMessageDialog(null, "Operation Complited");
		    	setVisible(false);
		    	//parentFrame.populateTable();
		        showLevelViewer();
		    }
			
			}

		});}
		btnSignUp.setBackground(Color.CYAN);
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
				 parentFrame.setVisible(true);
				
			}
			
		});
		ImageIcon icon3 = new ImageIcon(new ImageIcon(this.getClass().getResource("BackArrow.png")).getImage().getScaledInstance(35, 20, java.awt.Image.SCALE_SMOOTH));
		btnBack.setIcon(icon3);
		add(btnBack);
		
		ImageIcon icon2 = new ImageIcon(new ImageIcon(this.getClass().getResource("pzl5.gif")).getImage().getScaledInstance(450,60, java.awt.Image.SCALE_DEFAULT));
		lblGameName5=new JLabel(icon2);
		this.lblGameName5.setBounds(60,400,600,90);
		C.add(lblGameName5);
		
		
	}
	
	private void populateData() {
		if(user.getId()==-1)
		{
			isNew=true;
			return;
		}
		isNew=false;
		txtInputId.setEnabled(false);
		txtInputId.setText(user.getId()+"");
		txtInputName.setText(user.getName());
		txtInputPassword.setText(user.getPassword());
		txtInputDOB.setText(user.getDOB());
		
	}
	private void showLevelViewer(){
		levelViewer3 lv1=new levelViewer3(this);
		lv1.setVisible(true);
	    setVisible(false);
	}

	private boolean IsValidData()
	{
		if(!ValidationHelper.IsIntValid(txtInputId.getText()))
		{
			JOptionPane.showMessageDialog(null,"Invalid Id");
			return false;
		}
		if(txtInputName.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null,"Name field is blank");
			return false;
		}
		if(txtInputPassword.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null,"Password field is blank");
			return false;
		}
		if(txtInputDOB.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null,"Date Of Birth field is blank");
			return false;
		}
		
		return true;
	}


}
