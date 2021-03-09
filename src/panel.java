import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class panel extends JPanel
{
	private Play_Balloon[] UFOIT = new Play_Balloon[20]; 
	
	public panel()
	{
		setPreferredSize(new Dimension(1100, 580));
		setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
		
		for(int i = 0 ; i < 20 ; i++)
		{
			UFOIT[i] = new Play_Balloon();
		}
	}
	
	public void paint(Graphics g) 
	{
		super.paint(g);
		
	}
}