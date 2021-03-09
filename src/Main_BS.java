import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
public class Main_BS extends JPanel implements ActionListener , MouseListener{
		
		Play_Balloon[] BallIT = new Play_Balloon[20]; 
		Play_Bomb[] BombIT = new Play_Bomb[20]; 
		Play_Clock[] ClockIT = new Play_Clock[20]; 
		JLabel  background , timeLabel , scoreLabel ;  
		JTextField  timeField , scoreField; 
		JButton startbtn , stopbtn , quitbtn; 
		int gametime = 40 , count = 0 , score = 0 , status;
		boolean statusufo, isStarted = false;
		Timer swTimer;
		ImageIcon  bg = new ImageIcon("3492.jpg");
		ImageIcon icon1 = new ImageIcon("Play1.png");
		ImageIcon icon2= new ImageIcon("Stop1.png");
		ImageIcon icon3= new ImageIcon("Micky.jpg");
		ImageIcon icon4= new ImageIcon("Welcome.png");
		
		public Main_BS() {
			
			for(int i = 0 ; i < 20 ; i++)
			{
				BallIT[i] = new Play_Balloon();
			}
			for(int i = 0 ; i < 20 ; i++)
			{
				BombIT[i] = new Play_Bomb();
			}
			for(int i = 0 ; i < 20 ; i++)
			{
				ClockIT[i] = new Play_Clock();
			}
			
		  	startbtn = new JButton("Play Game");
	      	setLayout(null);
	      	startbtn.setBounds(100,12,100,30);
	      	startbtn.addActionListener(this);
	      	add(startbtn);
	      	
	      	stopbtn = new JButton(" Reset ");
	      	setLayout(null);
	      	stopbtn.setBounds(283,12,150,30);
	      	stopbtn.addActionListener(this);
	      	stopbtn.setEnabled(false);
	      	add(stopbtn);
	      	
	      	quitbtn = new JButton("Quit");
	      	setLayout(null);
	      	quitbtn.setBounds(530,12,100,30);
	      	quitbtn.addActionListener(this);
	      	add(quitbtn);
	      	timeLabel = new JLabel("Time : ");
	      	
		  timeLabel.setBounds(713, 18, 79, 20);
		  timeLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		  add(timeLabel);
		  
		  timeField = new JTextField(10);
		  timeField.setFont(new Font("Tahoma", Font.BOLD, 20));
		  timeField.setForeground(Color.BLUE);
		  timeField.setHorizontalAlignment(JTextField.RIGHT);
		  timeField.setBounds(785, 15, 116, 28);
		  timeField.setEditable(false); 
		  add(timeField);
		  
		  scoreLabel = new JLabel("Score : ");
		  scoreLabel.setBounds(970, 18, 79, 20);
		  scoreLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		  add(scoreLabel);
		  
		  scoreField = new JTextField(10);
		  scoreField.setFont(new Font("Tahoma", Font.BOLD, 20));
		  scoreField.setForeground(Color.PINK);
		  scoreField.setHorizontalAlignment(JTextField.RIGHT);
		  scoreField.setBounds(1050, 15, 116, 28);
		  scoreField.setEditable(false); 
		  add(scoreField);
		  
	      background = new JLabel();
	      background.setIcon(bg);
	      background.setBounds(10, 65, 1250, 600);
	      background.setVisible(false); 
	      add(background);
	   
	      setPreferredSize(new Dimension(1280,720));

		swTimer = new Timer(50,this); 
		addMouseListener(this);
		
	}
	public void paint(Graphics g)
	{
		if (isStarted)
		{
			
			count++;
			if(count == 20)
			{
				count = 0;
				gametime--;
			}
			super.paint(g);		
			if(status == 1)
			{
				g.setColor(Color.BLUE);
				timeField.setText(Integer.toString(gametime));
				scoreField.setText(Integer.toString(score));
				for(int i = 0 ; i < 20 ; i++)
				{
					BallIT[i].drawUFO(this,g);
				}
				for(int i = 0 ; i < 20 ; i++)
				{
					BombIT[i].drawBomb(this,g);
				}
				for(int i = 0 ; i < 20 ; i++)
				{
					ClockIT[i].drawClock(this,g);
				}
			}
			else if(status == 0)
			{
				g.setColor(Color.BLUE);
				g.drawRect(10, 0, 1250, 55);
				g.drawRect(10, 65,1250, 600);	
				timeField.setText("");
				scoreField.setText("");
			}
		}
		else
		{
			icon3.paintIcon(this, g, 0, 0);
			icon4.paintIcon(this, g, 370, 70);
			icon1.paintIcon(this, g, 590, 200);
			icon2.paintIcon(this, g, 590, 400);
		}
	}
	
	public void setStarted(boolean value)
	{
		isStarted = value;
	}
	
	public void mouseClicked(MouseEvent e) {
		if (!isStarted)
		{
			if(e.getX() >= 590 && e.getX() <= 710 && e.getY() >= 200 && e.getY() <= 320)
			{	
				setStarted(true);

			}
			else if(e.getX() >= 590 && e.getX() <= 710 && e.getY() >= 400 && e.getY() <= 550)
			{
				System.exit(0);
			
			}
		}
		
		repaint();	
	}
	public void mouseEntered(MouseEvent e) {
		repaint();
	}
	public void mouseExited(MouseEvent e) {
		repaint();	
	}
	
	public void mousePressed(MouseEvent e) {
		for(int i = 0 ; i < 20 ; i++)
		{		
			if (BallIT[i].hitufo(e.getX(),e.getY())) 
			{
				BallIT[i].setstatus(false);
			}
			if (BombIT[i].hitBomb(e.getX(),e.getY())) 
			{
				BombIT[i].setstatus(false);
			}
			if (ClockIT[i].hitClock(e.getX(),e.getY())) 
			{
				ClockIT[i].setstatus(false);
				gametime -= 5;
			}
		}
	}
	public void mouseReleased(MouseEvent e) {
		repaint();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startbtn)
		{
			status = 1;
			score = 0;
			statusufo = true;
			stopbtn.setEnabled(true); 
			startbtn.setEnabled(false);
			background.setVisible(true); 
			for(int i = 0; i < 20; i++)
			{
				BallIT[i].setstatus(true);
			}
			for(int i = 0; i < 20; i++)
			{
				BombIT[i].setstatus(true);
			}
			for(int i = 0; i < 20; i++)
			{
				ClockIT[i].setstatus(true);
			}
			swTimer.start();
		}
		else if (e.getSource() == stopbtn)
		{
			status = 0;
			score = 0;
			gametime = 40;
			statusufo = false;
			startbtn.setEnabled(true);
			background.setVisible(false);
			stopbtn.setEnabled(false);
			swTimer.stop();
		}
		else if (e.getSource() == quitbtn)
		{
			statusufo = false;
			startbtn.setEnabled(false);
			background.setVisible(false);
			stopbtn.setEnabled(false);
			swTimer.stop();
			JOptionPane.showMessageDialog(null, "                   Exit Balloon Smash Game                   ","Balloon Smash Game",JOptionPane.CLOSED_OPTION);
			System.exit(0);
		}
		if(score == 20)
		{
			score = 0;
			swTimer.stop();
			startbtn.setEnabled(true);
			stopbtn.setEnabled(false);
			background.setVisible(false);
			statusufo = false;
			gametime = 40;
			status = 0;
			JOptionPane.showMessageDialog( null,"You winner.","Message", JOptionPane.INFORMATION_MESSAGE );
		}
		else if(gametime == 0)
		{
			swTimer.stop();
			startbtn.setEnabled(true);
			stopbtn.setEnabled(false);
			background.setVisible(false);
			statusufo = false;
			gametime = 40;
			score = 0;
			status = 0;
			JOptionPane.showMessageDialog(null,"Time Out\nYou lose game.","Message",JOptionPane.INFORMATION_MESSAGE);	
		}
		for(int i = 0 ; i < 20 ; i++)
		{
			BallIT[i].move();
		}
		for(int i = 0 ; i < 20 ; i++)
		{
			BombIT[i].move();
		}
		for(int i = 0 ; i < 20 ; i++)
		{
			ClockIT[i].move();
		}
		score = 0;
		
		for(int i = 0 ; i < 20; i++)
		{
			if(BallIT[i].getStatus() == false){
				score++;
				
			}
			if(ClockIT[i].getStatus() == false){
			
			}
		}
		for(int i = 0 ; i < 20; i++)
		{
			if(BombIT[i].getStatus() == false){
				swTimer.stop();
				statusufo = false;
				score = 0;
				status = 0;
				JOptionPane.showMessageDialog(null,"Time Out\nYou lose game.","Message",JOptionPane.INFORMATION_MESSAGE);	
			}
		}
		repaint(); 
	}
	
}