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


	public class Preview extends JFrame{
		
		
		private JLabel lblTitle1;
		private JButton btnMinnion,btnBack;
		Container C1;
		
		private puzzleDesignEasy1 levelshowframe1;
		private puzzleDesignHard1 levelshowframe2;
		

		
		
		public Preview(puzzleDesignEasy1 levelshow,puzzleDesignHard1 levelshow2){
			
			levelshowframe1=levelshow;
			levelshowframe2=levelshow2;
		
		
			this.setLayout(null);
			this.setSize(600,560);
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
			
			
			lblTitle1=new JLabel("MINNION ");
			this.lblTitle1.setBounds(50,70,180,50);
			lblTitle1.setBackground(Color.WHITE);
			lblTitle1.setFont(new Font("Times New Roman",Font.BOLD,20));
			C1.add(lblTitle1);
			
			
			
			btnMinnion= new JButton("1");
			btnMinnion.setBounds(70,135,400,350);
			btnMinnion.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					//showEasyFrame();
					
				}
				  
				
			});
			ImageIcon icon3 = new ImageIcon(new ImageIcon(this.getClass().getResource("minnion.jpg")).getImage().getScaledInstance(410, 360, java.awt.Image.SCALE_SMOOTH));
			btnMinnion.setIcon(icon3);
			this.add(btnMinnion);
			
			
			btnBack= new JButton("");
			btnBack.setBounds(5,5,37,20);
			btnBack.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					levelshowframe1.setVisible(true);
					
					
				}
				
			});
			ImageIcon icon5 = new ImageIcon(new ImageIcon(this.getClass().getResource("BackArrow.png")).getImage().getScaledInstance(35, 20, java.awt.Image.SCALE_SMOOTH));
			btnBack.setIcon(icon5);
			add(btnBack);

		}
	}
		




