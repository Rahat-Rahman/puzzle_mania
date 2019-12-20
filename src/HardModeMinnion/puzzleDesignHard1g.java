package HardModeMinnion;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import GuiLayer.Preview;
import GuiLayer.PreviewForGuest;
import GuiLayer.levelViewer2;


public class puzzleDesignHard1g extends JFrame{

	private JPanel panelLeft;
	private JPanel panelRight;
	
	private JButton btnView,btnBack;
	private JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16;
	
	private JLabel lblMoves;
	private JLabel lblTime;
	
	private JTextField txtMoves;
	private JTextField txtTime;
	
    private levelViewer2 parentlavelg;
	
	public puzzleDesignHard1g(levelViewer2 parentg)
	{
		parentlavelg=parentg;
		this.setLayout(null);
		this.setSize(750,560);
		this.setTitle("Puzzle Mania");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.RED);
	    this.setFocusable(true);
	    
	    panelLeft =new JPanel(new GridLayout(0,4,2,2));
	    panelLeft.setBackground(Color.LIGHT_GRAY);
	    this.panelLeft.setBorder(new TitledBorder(new LineBorder(Color.black,1),"Game"));
	    this.panelLeft.setBounds(10,5,500,500);
	    add(this.panelLeft);
	    
	    
	    panelRight =new JPanel(null);
	    this.panelRight.setBorder(new TitledBorder(new LineBorder(Color.black,1),"Score"));
	    this.panelRight.setBounds(525,5,200,500);
	    add(this.panelRight);
	    
	    this.AddPanelLeftComponent();
	    this.AddPanelRightComponent();
	    
	    
	}

	private void AddPanelRightComponent() {
		// TODO Auto-generated method stub
		this.setLayout(null);
		
		lblMoves = new JLabel("Moves : ");
		lblMoves.setBounds(10,20,60,30);
		this.panelRight.add(lblMoves);
		lblTime= new JLabel("Time : ");
		lblTime.setBounds(10,70,60,30);
		this.panelRight.add(lblTime);
		
		txtMoves = new JTextField();
		txtMoves.setBounds(60, 20, 80,30);
		this.panelRight.add(txtMoves);
		txtTime = new JTextField();
		txtTime.setBounds(60, 70, 80,30);
		this.panelRight.add(txtTime);
		
		btnView = new JButton(" Pre View ");
		btnView.setBounds(40,350,120, 35);
		btnView.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				showHardFrame();
				
			}
			  
			
		});
		this.panelRight.add(btnView);
		
		btnBack= new JButton("");
		btnBack.setBounds(40,300,45,35);
		btnBack.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				parentlavelg.setVisible(true);
				
				
			}
			
		});
		ImageIcon icon3 = new ImageIcon(new ImageIcon(this.getClass().getResource("BackArrow.png")).getImage().getScaledInstance(45, 34, java.awt.Image.SCALE_SMOOTH));
		btnBack.setIcon(icon3);
		this.panelRight.add(btnBack);
		
			
		
		
		
	}
	
private void showHardFrame(){
		
		PreviewForGuest e1= new PreviewForGuest(null,this);
		e1.setVisible(true);
		//setVisible(false);
		
	}

	private void AddPanelLeftComponent() {
		// TODO Auto-generated method stub
		btn1= new JButton("1");
		//btn1.setBounds(10,10,50,50);
		ImageIcon icon = new ImageIcon(new ImageIcon(this.getClass().getResource("1.jpeg")).getImage().getScaledInstance(132, 115, java.awt.Image.SCALE_SMOOTH));
		btn1.setIcon(icon);
		this.panelLeft.add(btn1);
		
		btn2= new JButton("2");
		//btn2.setBounds(60,10,50,50);
		ImageIcon icon2 = new ImageIcon(new ImageIcon(this.getClass().getResource("2.jpeg")).getImage().getScaledInstance(132, 115, java.awt.Image.SCALE_SMOOTH));
		btn2.setIcon(icon2);
		this.panelLeft.add(btn2);
		
		btn3= new JButton("3");
		//btn3.setBounds(110,10,50,50);
		ImageIcon icon3 = new ImageIcon(new ImageIcon(this.getClass().getResource("3.jpeg")).getImage().getScaledInstance(132, 115, java.awt.Image.SCALE_SMOOTH));
		btn3.setIcon(icon3);
		this.panelLeft.add(btn3);
		
		btn4= new JButton("4");
		//btn4.setBounds(160,10,50,50);
		ImageIcon icon4 = new ImageIcon(new ImageIcon(this.getClass().getResource("4.jpeg")).getImage().getScaledInstance(132, 115, java.awt.Image.SCALE_SMOOTH));
		btn4.setIcon(icon4);
		this.panelLeft.add(btn4);
		
		btn5= new JButton("5");
		//btn5.setBounds(10,60,50,50);
		ImageIcon icon5 = new ImageIcon(new ImageIcon(this.getClass().getResource("5.jpeg")).getImage().getScaledInstance(132, 115, java.awt.Image.SCALE_SMOOTH));
		btn5.setIcon(icon5);
		this.panelLeft.add(btn5);
		
		btn6= new JButton("6");
		//btn6.setBounds(60,60,50,50);
		ImageIcon icon6 = new ImageIcon(new ImageIcon(this.getClass().getResource("6.jpeg")).getImage().getScaledInstance(132, 115, java.awt.Image.SCALE_SMOOTH));
		btn6.setIcon(icon6);
		this.panelLeft.add(btn6);
		
		btn7= new JButton("7");
		//btn7.setBounds(110,60,50,50);
		ImageIcon icon7 = new ImageIcon(new ImageIcon(this.getClass().getResource("7.jpeg")).getImage().getScaledInstance(132, 115, java.awt.Image.SCALE_SMOOTH));
		btn7.setIcon(icon7);
		this.panelLeft.add(btn7);
		
		btn8= new JButton("8");
		//btn8.setBounds(160,60,50,50);
		ImageIcon icon8 = new ImageIcon(new ImageIcon(this.getClass().getResource("8.jpeg")).getImage().getScaledInstance(132, 115, java.awt.Image.SCALE_SMOOTH));
		btn8.setIcon(icon8);
		this.panelLeft.add(btn8);
		
		btn9= new JButton("9");
		//btn9.setBounds(10,110,50,50);
		ImageIcon icon9 = new ImageIcon(new ImageIcon(this.getClass().getResource("9.jpeg")).getImage().getScaledInstance(132, 115, java.awt.Image.SCALE_SMOOTH));
		btn9.setIcon(icon9);
		this.panelLeft.add(btn9);
		
		btn10= new JButton("10");
		//btn10.setBounds(60,110,50,50);
		ImageIcon icon10 = new ImageIcon(new ImageIcon(this.getClass().getResource("10.jpeg")).getImage().getScaledInstance(132, 115, java.awt.Image.SCALE_SMOOTH));
		btn10.setIcon(icon10);
		this.panelLeft.add(btn10);
		
		btn11= new JButton("11");
		//btn11.setBounds(110,110,50,50);
		ImageIcon icon11 = new ImageIcon(new ImageIcon(this.getClass().getResource("11.jpeg")).getImage().getScaledInstance(132, 115, java.awt.Image.SCALE_SMOOTH));
		btn11.setIcon(icon11);
		this.panelLeft.add(btn11);
		
		btn12= new JButton("12");
		//btn12.setBounds(160,110,50,50);
		ImageIcon icon12 = new ImageIcon(new ImageIcon(this.getClass().getResource("12.jpeg")).getImage().getScaledInstance(132, 115, java.awt.Image.SCALE_SMOOTH));
		btn12.setIcon(icon12);
		this.panelLeft.add(btn12);
		
		btn13= new JButton("13");
		//btn13.setBounds(10,160,50,50);
		ImageIcon icon13 = new ImageIcon(new ImageIcon(this.getClass().getResource("13.jpeg")).getImage().getScaledInstance(132, 115, java.awt.Image.SCALE_SMOOTH));
		btn13.setIcon(icon13);
		this.panelLeft.add(btn13);
		
		btn14= new JButton("14");
		//btn14.setBounds(60,160,50,50);
		ImageIcon icon14 = new ImageIcon(new ImageIcon(this.getClass().getResource("14.jpeg")).getImage().getScaledInstance(132, 115, java.awt.Image.SCALE_SMOOTH));
		btn14.setIcon(icon14);
		this.panelLeft.add(btn14);
		
		btn15= new JButton("15");
		//btn15.setBounds(110,160,50,50);
		ImageIcon icon15 = new ImageIcon(new ImageIcon(this.getClass().getResource("15.jpeg")).getImage().getScaledInstance(132, 115, java.awt.Image.SCALE_SMOOTH));
		btn15.setIcon(icon15);
		this.panelLeft.add(btn15);
		
		btn16= new JButton("16");
		//btn16.setBounds(160,160,50,50);
		ImageIcon icon16 = new ImageIcon(new ImageIcon(this.getClass().getResource("16.jpeg")).getImage().getScaledInstance(132, 115, java.awt.Image.SCALE_SMOOTH));
		btn16.setIcon(icon16);
		this.panelLeft.add(btn16);
		}
		
	}
	
//	private class buttonHandler implements ActionListener{
//		
//		public void actionPerformed(ActionEvent e)
//		{
//			
//		}
	
	
	
	
