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

public class firstPage extends JFrame {
	
	private JLabel lblpic,lblPlayAs,lblGameName;;
	private JButton btnUser,btnGUser,btnHScore;
	Container C;
	
    public firstPage(){
    	
    	this.setLayout(null);
		this.setSize(750,560);
		this.setTitle("Image Puzzle Mania");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.RED);
	    this.setFocusable(true);
	    C=this.getContentPane();
	    C.setBackground(Color.WHITE);
	    C.setLayout(null);
	    //C1=this.getContentPane();
	    //C1.setBackground(Color.WHITE);
	    
	    
	    //C1.setLayout(null);
	    
	    this.addFrontComponent();
    }
    
    private void addFrontComponent(){
    	
    	this.setLayout(null);
    	
    	ImageIcon icon = new ImageIcon(new ImageIcon(this.getClass().getResource("img1.jpg")).getImage().getScaledInstance(550,400, java.awt.Image.SCALE_SMOOTH));
    	lblpic=new JLabel(icon);
		this.lblpic.setBounds(5, 5,530,380);
		C.add(lblpic);
		
		lblPlayAs=new JLabel(" PLAY AS :");
		lblPlayAs.setBounds(540,70,200,50);
		lblPlayAs.setForeground(Color.BLACK);
		lblPlayAs.setFont(new Font("ALGERIAN",Font.BOLD,25));
		add(lblPlayAs);
		
		
		
		btnUser= new JButton(" USER ");
		btnUser.setBounds(560,115,150,60);
		btnUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				showUser();
				
			}
		});
		btnUser.setBackground(Color.WHITE);
		btnUser.setForeground(Color.BLACK);
		btnUser.setFont(new Font("New Times Roman",Font.BOLD,20));
		add(btnUser);
		
		btnGUser= new JButton(" GUEST USER ");
		btnGUser.setBounds(560,185,150,60);
		btnGUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				showGuestUser();
				
			}
			
			
		});
		btnGUser.setBackground(Color.WHITE);
		btnGUser.setForeground(Color.BLACK);
		btnGUser.setFont(new Font("New Times Roman",Font.BOLD,16));
		add(btnGUser);
		
		btnHScore= new JButton(" HIGH SCORE ");
		btnHScore.setBounds(560,305,150,60);
		btnHScore.setBackground(Color.WHITE);
		btnHScore.setForeground(Color.BLACK);
		btnHScore.setFont(new Font("New Times Roman",Font.BOLD,16));
		add(btnHScore);
		btnHScore.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				ShowHighScore();
				
			}
			
			
		});
		
		ImageIcon icon1 = new ImageIcon(new ImageIcon(this.getClass().getResource("game.gif")).getImage().getScaledInstance(500,80, java.awt.Image.SCALE_DEFAULT));
		lblGameName=new JLabel(icon1);
		this.lblGameName.setBounds(10,400,600,90);
		C.add(lblGameName);
		
		
    	
    	
    	
    }
    private void showUser()
    {
    	Userlogin u1= new Userlogin(this);
		u1.setVisible(true);
		setVisible(false);
    }
    private void showGuestUser()
    {
    	GuestUser g1= new GuestUser(this);
		g1.setVisible(true);
		setVisible(false);
    }
    
    private void ShowHighScore()
    {
    	ScoreListFrame s1= new ScoreListFrame(this);
		s1.setVisible(true);
		setVisible(false);

}
}

