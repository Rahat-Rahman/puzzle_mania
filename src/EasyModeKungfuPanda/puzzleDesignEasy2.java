package EasyModeKungfuPanda;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;








import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import GuiLayer.ChooseEasyFrame;
import GuiLayer.PreviewE2;
import GuiLayer.firstPage;
import GuiLayer.levelViewer;
import GuiLayer.levelViewer2;


public class puzzleDesignEasy2 extends JFrame{

	private JPanel panelLeft;
	private JPanel panelRight;
	
	private JButton btnView,btnBack;
	private JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
	
	private JLabel lblMoves;
	private JLabel lblTime;
	
	private JTextField txtMoves;
	private JTextField txtTime;
	private String[] imgs = new String[]{"1.jpeg","2.jpeg","3.jpeg","4.jpeg","5.jpeg","6.jpeg","7.jpeg","8.jpeg"}; 
 	private ArrayList<String> Images =  new ArrayList<String>(Arrays.asList(imgs));
	private ArrayList<String> RandomImagePosition = new ArrayList<String>();
 	int move=0,time=0;
	Timer timer;
	
	private  ChooseEasyFrame parentframeeasy;
	
	public puzzleDesignEasy2(ChooseEasyFrame frameeasy)
	{
		parentframeeasy=frameeasy;
		this.setLayout(null);
		this.setSize(750,560);
		this.setTitle("Puzzle Mania");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.RED);
	    this.setFocusable(true);
	    
	    panelLeft =new JPanel(new GridLayout(0,3,2,2));
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
	    
	    timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				time++;
				txtTime.setText(time+"");
			}
		});
	    timer.start();
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
		btnView.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				showEasyFrame();
				
			}
			  
			
		});
		btnView.setBounds(40,350,120, 35);
		this.panelRight.add(btnView);
		
		btnBack= new JButton("");
		btnBack.setBounds(40,300,45,35);
		btnBack.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				parentframeeasy.setVisible(true);
				
				
			}
			
		});
		ImageIcon icon3 = new ImageIcon(new ImageIcon(this.getClass().getResource("BackArrow.png")).getImage().getScaledInstance(45, 34, java.awt.Image.SCALE_SMOOTH));
		btnBack.setIcon(icon3);
		this.panelRight.add(btnBack);
	}
	
	private void showEasyFrame(){
		
		PreviewE2 e2= new PreviewE2(this,null);
		e2.setVisible(true);
		//setVisible(false);
		
	}
	
	private void Check()
	{
		System.out.println(RandomImagePosition);
		int i;
		for(i=0;i<imgs.length;i++)
		{
			if(imgs[i]!=RandomImagePosition.get(i)){
				break;
			}
		}
		
		if(i==8)
		{
			timer.stop();
			JOptionPane.showMessageDialog(null, "Moves: "+move+",Time: "+time);
			setVisible(false);
			parentframeeasy.setVisible(true);
			
		}
	}

	private void AddPanelLeftComponent() {
		
		Random random = new Random();
		
		int rand = random.nextInt(7);
		String randImageName = "";
		int randImageN0;
		// TODO Auto-generated method stub
		
		
		
		btn1= new JButton("1");
		//btn1.setBounds(10,10,50,50);
		if(rand==0)
		{
			btn1.setText("");
			RandomImagePosition.add("");
		}
		else
		{
			randImageN0 = Images.size()-1==0?0:random.nextInt(Images.size()-1);
			randImageName = Images.get(randImageN0);
			RandomImagePosition.add(randImageName);
			ImageIcon icon = new ImageIcon(new ImageIcon(this.getClass().getResource(randImageName)).getImage().getScaledInstance(172, 160, java.awt.Image.SCALE_SMOOTH));
			btn1.setIcon(icon);
			btn1.setText("1");
			Images.remove(randImageN0);
		}
		this.panelLeft.add(btn1);
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//move++;
				
				
				if(btn1.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Invalid Position");
					return;
				}
				
				if(btn2.getText().isEmpty())
				{
					btn2.setIcon(btn1.getIcon());
					btn1.setIcon(null);
					btn2.setText("2");
					btn1.setText("");
					RandomImagePosition.set(1, RandomImagePosition.get(0));
					RandomImagePosition.set(0, "");
					move++;
					//Check();
				}
				else if(btn4.getText().isEmpty())
				{
					btn4.setIcon(btn1.getIcon());
					btn1.setIcon(null);
					btn4.setText("4");
					btn1.setText("");
					RandomImagePosition.set(3, RandomImagePosition.get(0));
					RandomImagePosition.set(0, "");
					move++;
					//Check();
				}
				txtMoves.setText(move+"");
				Check();
			}
		});
		
		
		
		
		btn2= new JButton("2");
		if(rand==1)
		{
			btn2.setText("");
			RandomImagePosition.add("");
		}
		else
		{
			randImageN0 = Images.size()-1==0?0:random.nextInt(Images.size()-1);
			randImageName = Images.get(randImageN0);
			RandomImagePosition.add(randImageName);
			ImageIcon icon = new ImageIcon(new ImageIcon(this.getClass().getResource(randImageName)).getImage().getScaledInstance(172, 160, java.awt.Image.SCALE_SMOOTH));
			btn2.setIcon(icon);
			btn2.setText("2");
			Images.remove(randImageN0);
		}
		this.panelLeft.add(btn2);
        btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(btn2.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Invalid Position");
					return;
				}
				
				if(btn1.getText().isEmpty())
				{
					btn1.setIcon(btn2.getIcon());
					btn2.setIcon(null);
					btn1.setText("1");
					btn2.setText("");
					RandomImagePosition.set(0, RandomImagePosition.get(1));
					RandomImagePosition.set(1, "");
					move++;
					//Check();
				}
				else if(btn3.getText().isEmpty())
				{
					btn3.setIcon(btn2.getIcon());
					btn2.setIcon(null);
					btn3.setText("3");
					btn2.setText("");
					RandomImagePosition.set(2, RandomImagePosition.get(1));
					RandomImagePosition.set(1, "");
					move++;
					//Check();
				}
				else if(btn5.getText().isEmpty())
				{
					btn5.setIcon(btn2.getIcon());
					btn2.setIcon(null);
					btn5.setText("5");
					btn2.setText("");
					RandomImagePosition.set(4, RandomImagePosition.get(1));
					RandomImagePosition.set(1, "");
					move++;
					//Check();
				}
				txtMoves.setText(move+"");
				Check();
			}
		});
        
		
		
		
		btn3= new JButton("3");
		//btn3.setBounds(110,10,50,50);
		if(rand==2)
		{
			btn3.setText("");
			RandomImagePosition.add("");
		}
		else
		{
			randImageN0 = Images.size()-1==0?0:random.nextInt(Images.size()-1);
			randImageName = Images.get(randImageN0);
			RandomImagePosition.add(randImageName);
			ImageIcon icon = new ImageIcon(new ImageIcon(this.getClass().getResource(randImageName)).getImage().getScaledInstance(172, 160, java.awt.Image.SCALE_SMOOTH));
			btn3.setIcon(icon);
			btn3.setText("3");
			Images.remove(randImageN0);
		}
		this.panelLeft.add(btn3);
        btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(btn3.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Invalid Position");
					return;
				}
				
				if(btn2.getText().isEmpty())
				{
					btn2.setIcon(btn3.getIcon());
					btn3.setIcon(null);
					btn2.setText("2");
					btn3.setText("");
					RandomImagePosition.set(1, RandomImagePosition.get(2));
					RandomImagePosition.set(2, "");
					move++;
					//Check();
				}
				else if(btn6.getText().isEmpty())
				{
					btn6.setIcon(btn3.getIcon());
					btn3.setIcon(null);
					btn6.setText("6");
					btn3.setText("");
					RandomImagePosition.set(5, RandomImagePosition.get(2));
					RandomImagePosition.set(2, "");
					move++;
					//Check();
				}
				txtMoves.setText(move+"");
				Check();
			}
		});
        
		
		
		
		
		btn4= new JButton("4");
		//btn4.setBounds(160,10,50,50);
		if(rand==3)
		{
			btn4.setText("");
			RandomImagePosition.add("");
		}
		else
		{
			randImageN0 = Images.size()-1==0?0:random.nextInt(Images.size()-1);
			randImageName = Images.get(randImageN0);
			RandomImagePosition.add(randImageName);
			ImageIcon icon = new ImageIcon(new ImageIcon(this.getClass().getResource(randImageName)).getImage().getScaledInstance(172, 160, java.awt.Image.SCALE_SMOOTH));
			btn4.setIcon(icon);
			btn4.setText("4");
			Images.remove(randImageN0);
		}
		this.panelLeft.add(btn4);
        btn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(btn4.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Invalid Position");
					return;
				}
				
				if(btn1.getText().isEmpty())
				{
					btn1.setIcon(btn4.getIcon());
					btn4.setIcon(null);
					btn1.setText("1");
					btn4.setText("");
					RandomImagePosition.set(0, RandomImagePosition.get(3));
					RandomImagePosition.set(3, "");
					move++;
					//Check();
				}
				else if(btn7.getText().isEmpty())
				{
					btn7.setIcon(btn4.getIcon());
					btn4.setIcon(null);
					btn7.setText("7");
					btn4.setText("");
					RandomImagePosition.set(6, RandomImagePosition.get(3));
					RandomImagePosition.set(3, "");
					move++;
					//Check();
				}
				else if(btn5.getText().isEmpty())
				{
					btn5.setIcon(btn4.getIcon());
					btn4.setIcon(null);
					btn5.setText("5");
					btn4.setText("");
					RandomImagePosition.set(4, RandomImagePosition.get(3));
					RandomImagePosition.set(3, "");
					move++;
					//Check();
				}
				txtMoves.setText(move+"");
				Check();
			}
		});
		
        
        
		
		
		btn5= new JButton("5");
		//btn5.setBounds(10,60,50,50);
		if(rand==4)
		{
			btn5.setText("");
			RandomImagePosition.add("");
		}
		else
		{
			randImageN0 = Images.size()-1==0?0:random.nextInt(Images.size()-1);
			randImageName = Images.get(randImageN0);
			RandomImagePosition.add(randImageName);
			ImageIcon icon = new ImageIcon(new ImageIcon(this.getClass().getResource(randImageName)).getImage().getScaledInstance(172, 160, java.awt.Image.SCALE_SMOOTH));
			btn5.setIcon(icon);
			btn5.setText("5");
			Images.remove(randImageN0);
		}
		this.panelLeft.add(btn5);
		btn5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(btn5.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Invalid Position");
					return;
				}
				
				if(btn2.getText().isEmpty())
				{
					btn2.setIcon(btn5.getIcon());
					btn5.setIcon(null);
					btn2.setText("2");
					btn5.setText("");
					RandomImagePosition.set(1, RandomImagePosition.get(4));
					RandomImagePosition.set(4, "");
					move++;
					//Check();
				}
				else if(btn4.getText().isEmpty())
				{
					btn4.setIcon(btn5.getIcon());
					btn5.setIcon(null);
					btn4.setText("4");
					btn5.setText("");
					RandomImagePosition.set(3, RandomImagePosition.get(4));
					RandomImagePosition.set(4, "");
					move++;
					//Check();
				}
				else if(btn6.getText().isEmpty())
				{
					btn6.setIcon(btn5.getIcon());
					btn5.setIcon(null);
					btn6.setText("6");
					btn5.setText("");
					RandomImagePosition.set(5, RandomImagePosition.get(4));
					RandomImagePosition.set(4, "");
					move++;
					//Check();
				}
				else if(btn8.getText().isEmpty())
				{
					btn8.setIcon(btn5.getIcon());
					btn5.setIcon(null);
					btn8.setText("8");
					btn5.setText("");
					RandomImagePosition.set(7, RandomImagePosition.get(4));
					RandomImagePosition.set(4, "");
					move++;
					//Check();
				}
				txtMoves.setText(move+"");
				Check();
			}
		});
		
		
		
		
		
		btn6= new JButton("6");
		//btn6.setBounds(60,60,50,50);
		if(rand==5)
		{
			btn6.setText("");
			RandomImagePosition.add("");
		}
		else
		{
			randImageN0 = Images.size()-1==0?0:random.nextInt(Images.size()-1);
			randImageName = Images.get(randImageN0);
			RandomImagePosition.add(randImageName);
			ImageIcon icon = new ImageIcon(new ImageIcon(this.getClass().getResource(randImageName)).getImage().getScaledInstance(172, 160, java.awt.Image.SCALE_SMOOTH));
			btn6.setIcon(icon);
			btn6.setText("6");
			Images.remove(randImageN0);
		}
		this.panelLeft.add(btn6);
		btn6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(btn6.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Invalid Position");
					return;
				}
				
			    if(btn3.getText().isEmpty())
				{
					btn3.setIcon(btn6.getIcon());
					btn6.setIcon(null);
					btn3.setText("3");
					btn6.setText("");
					RandomImagePosition.set(2, RandomImagePosition.get(5));
					RandomImagePosition.set(5, "");
					move++;
					//Check();
				}
				else if(btn5.getText().isEmpty())
				{
					btn5.setIcon(btn6.getIcon());
					btn6.setIcon(null);
					btn5.setText("5");
					btn6.setText("");
					RandomImagePosition.set(4, RandomImagePosition.get(5));
					RandomImagePosition.set(5, "");
					move++;
					//Check();
				}
				else if(btn9.getText().isEmpty())
				{
					btn9.setIcon(btn6.getIcon());
					btn6.setIcon(null);
					btn9.setText("9");
					btn6.setText("");
					RandomImagePosition.set(8, RandomImagePosition.get(5));
					RandomImagePosition.set(5, "");
					move++;
					//Check();
				}
			    txtMoves.setText(move+"");
			    Check();
			}
		});
	   
		
		
		
		
		btn7= new JButton("7");
		//btn7.setBounds(110,60,50,50);
		if(rand==6)
		{
			btn7.setText("");
			RandomImagePosition.add("");
		}
		else
		{
			randImageN0 = Images.size()-1==0?0:random.nextInt(Images.size()-1);
			randImageName = Images.get(randImageN0);
			RandomImagePosition.add(randImageName);
			ImageIcon icon = new ImageIcon(new ImageIcon(this.getClass().getResource(randImageName)).getImage().getScaledInstance(172, 160, java.awt.Image.SCALE_SMOOTH));
			btn7.setIcon(icon);
			btn7.setText("7");
			Images.remove(randImageN0);
		}
		this.panelLeft.add(btn7);
        btn7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(btn7.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Invalid Position");
					return;
				}
				
				 if(btn4.getText().isEmpty())
				{
					btn4.setIcon(btn7.getIcon());
					btn7.setIcon(null);
					btn4.setText("4");
					btn7.setText("");
					RandomImagePosition.set(3, RandomImagePosition.get(6));
					RandomImagePosition.set(6, "");
					move++;
					//Check();
				}
				
				else if(btn8.getText().isEmpty())
				{
					btn8.setIcon(btn7.getIcon());
					btn7.setIcon(null);
					btn8.setText("8");
					btn7.setText("");
					RandomImagePosition.set(7, RandomImagePosition.get(6));
					RandomImagePosition.set(6, "");
					move++;
					//Check();
				}
				 txtMoves.setText(move+"");
				 Check();
			}
		});


	
		
		
		btn8= new JButton("8");
		//btn8.setBounds(160,60,50,50);
		if(rand==7)
		{
			btn8.setText("");
			RandomImagePosition.add("");
		}
		else
		{
			randImageN0 = Images.size()-1==0?0:random.nextInt(Images.size()-1);
			randImageName = Images.get(randImageN0);
			RandomImagePosition.add(randImageName);
			ImageIcon icon = new ImageIcon(new ImageIcon(this.getClass().getResource(randImageName)).getImage().getScaledInstance(172, 160, java.awt.Image.SCALE_SMOOTH));
			btn8.setIcon(icon);
			btn8.setText("8");
			Images.remove(randImageN0);
		}
		this.panelLeft.add(btn8);
		btn8.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					if(btn8.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(null, "Invalid Position");
						return;
					}
					if(btn5.getText().isEmpty())
					{
						btn5.setIcon(btn8.getIcon());
						btn8.setIcon(null);
						btn5.setText("5");
						btn8.setText("");
						RandomImagePosition.set(4, RandomImagePosition.get(7));
						RandomImagePosition.set(7, "");
						move++;
						//Check();
					}
					else if(btn7.getText().isEmpty())
					{
						btn7.setIcon(btn8.getIcon());
						btn8.setIcon(null);
						btn7.setText("7");
						btn8.setText("");
						RandomImagePosition.set(6, RandomImagePosition.get(7));
						RandomImagePosition.set(7, "");
						move++;
						//Check();
					} 
					else if(btn9.getText().isEmpty())
					{
						btn9.setIcon(btn8.getIcon());
						btn8.setIcon(null);
						btn9.setText("9");
						btn8.setText("");
						RandomImagePosition.set(8, RandomImagePosition.get(7));
						RandomImagePosition.set(7, "");
						move++;
						//Check();
					}
					txtMoves.setText(move+"");
					Check();
				}
			});
		 
		 
		
		
		
		
		btn9= new JButton("9");
		//btn9.setBounds(10,110,50,50);
		if(rand==8)
		{
			btn9.setText("");
			RandomImagePosition.add("");
		}
		else
		{
			randImageN0 = Images.size()-1==0?0:random.nextInt(Images.size()-1);
			randImageName = Images.get(randImageN0);
			RandomImagePosition.add(randImageName);
			ImageIcon icon = new ImageIcon(new ImageIcon(this.getClass().getResource(randImageName)).getImage().getScaledInstance(172, 160, java.awt.Image.SCALE_SMOOTH));
			btn9.setIcon(icon);
			btn9.setText("9");
			Images.remove(randImageN0);
		}
		this.panelLeft.add(btn9);
        btn9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(btn9.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Invalid Position");
					return;
				}
				 if(btn6.getText().isEmpty())
				{
					btn6.setIcon(btn9.getIcon());
					btn9.setIcon(null);
					btn6.setText("6");
					btn9.setText("");
					RandomImagePosition.set(5, RandomImagePosition.get(8));
					RandomImagePosition.set(8, "");
					move++;
					//Check();
				}
				else if(btn8.getText().isEmpty())
				{
					btn8.setIcon(btn9.getIcon());
					btn9.setIcon(null);
					btn8.setText("8");
					btn9.setText("");
					RandomImagePosition.set(7, RandomImagePosition.get(8));
					RandomImagePosition.set(8, "");
					move++;
					//Check();
				}
				 txtMoves.setText(move+"");
				 Check();
			}
		});
		
		



//			ImageIcon icon = new ImageIcon(new ImageIcon(this.getClass().getResource("ABC.jpg")).getImage().getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH));
//			btn.setIcon(icon);
		}
		
	}
	
//	private class buttonHandler implements ActionListener{
//		
//		public void actionPerformed(ActionEvent e)
//		{
//			
//		}
//	}
//private class MouseHandler implements MouseListener
//{
//
//	@Override
//	public void mouseClicked(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseEntered(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseExited(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mousePressed(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseReleased(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//	
//}

	
	
	

