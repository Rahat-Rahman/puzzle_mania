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

import EasyModeKungfuPanda.puzzleDesignEasy2;
import EasyModeMinnion.puzzleDesignEasy1;
import HardModeMinnion.puzzleDesignHard1;
import HardModelKungfuPanda.puzzleDesignHard2;



public class ChooseHardFrame extends JFrame{
	
	
	private JLabel lblTitle1;
	private JButton btnMinnion,btnKung,btnBack;
	Container C1;
	
	//private levelViewer levelshowframe1;
	//private levelViewer3 levelshowframe2;
	private JFrame parent;
	

	
	
	public ChooseHardFrame(JFrame jf){
		
		parent=jf;
		//levelshowframe1=levelshow;
		//levelshowframe2=levelshow2;
	
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
		
		
		lblTitle1=new JLabel("Choose Frame ");
		this.lblTitle1.setBounds(50,70,180,50);
		lblTitle1.setBackground(Color.WHITE);
		lblTitle1.setFont(new Font("Times New Roman",Font.BOLD,20));
		C1.add(lblTitle1);
		
		
		
		btnMinnion= new JButton("1");
		btnMinnion.setBounds(70,135,120,110);
		btnMinnion.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				showHardFrame();
				
			}
			  
			
		});
		ImageIcon icon3 = new ImageIcon(new ImageIcon(this.getClass().getResource("minnion.jpg")).getImage().getScaledInstance(130, 110, java.awt.Image.SCALE_SMOOTH));
		btnMinnion.setIcon(icon3);
		this.add(btnMinnion);
		
		btnKung= new JButton("2");
		btnKung.setBounds(200,135,120,110);
		btnKung.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				showHardFrame2();
				
			}
			  
			
		});
		ImageIcon icon4 = new ImageIcon(new ImageIcon(this.getClass().getResource("kung.jpg")).getImage().getScaledInstance(130, 110, java.awt.Image.SCALE_SMOOTH));
		btnKung.setIcon(icon4);
		this.add(btnKung);
		
		btnBack= new JButton("");
		btnBack.setBounds(5,5,37,20);
		btnBack.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				parent.setVisible(true);
				
				
			}
			
		});
		ImageIcon icon5 = new ImageIcon(new ImageIcon(this.getClass().getResource("BackArrow.png")).getImage().getScaledInstance(35, 20, java.awt.Image.SCALE_SMOOTH));
		btnBack.setIcon(icon5);
		add(btnBack);

	}
	private void showHardFrame()
	{
		puzzleDesignHard1 e1= new puzzleDesignHard1(this);
		e1.setVisible(true);
		setVisible(false);
	}
	
	private void showHardFrame2()
	{
		puzzleDesignHard2 e2= new puzzleDesignHard2(this);
		e2.setVisible(true);
		setVisible(false);
	}
	
}

