import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.ImageIcon;
public class Play_Bomb {
	int x , y;
	int xspeed , yspeed;
	int xMin, xMax, yMin, yMax;
	int size;
	int gamestatus = 1;
	int speed ;
	boolean statusBall;
	private BufferedImage img;
	ImageIcon  Bomb = new ImageIcon("bomb.png"); 
	public Play_Bomb()
	{
		xMin = 5; xMax = 1228;
		yMin = 65; yMax = 630;	
		x=(int)(Math.random()*800)+70;
		y=(int)(Math.random()*560)+85;
		xspeed =(int)(Math.random()*12)+1;
		yspeed =(int)(Math.random()*12)+1;
		size = 40;
	}
	public void drawBomb(Main_BS  P , Graphics g)
	{	
		if(statusBall == true)
		{
			Bomb.paintIcon(P,g,x,y);
		}
	}
	public void move()
	{
		x = x + xspeed;
		y = y + yspeed;
		if(x < xMin){
			x = xMin;
			xspeed = -xspeed;
		}
		else if (x+size > xMax)
		{
			x = xMax - size;
			xspeed = -xspeed;
		}
		if (y < yMin)
		{
			y = yMin;
			yspeed = -yspeed;
		}
		else if (y+size > yMax)
		{
			y = yMax - size;
			yspeed = -yspeed;
		}	
	}
	public boolean hitBomb(int posx,int posy) 
	{
		int x2 = x + 100; 
		int y2 = y + 60; 	
		if (posx >= x && posx <= x2)
		{
			if (posy >= y && posy <= y2) 
			{
				return true;
			}
		}
		return false;
	}
	public void setstatus(boolean status)
	{
		statusBall = status;
	}
	public boolean getStatus()
	{
		return(statusBall);
	}
}