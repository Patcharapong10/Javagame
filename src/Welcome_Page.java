import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Welcome_Page extends JFrame implements ActionListener, MouseListener{
	
	Main_BS obj2;

	public Welcome_Page() {
		super("Balloon Smash Game");
		addMouseListener(this);
		
		obj2 = new Main_BS();
		
		add(obj2);
		
		setSize(1280,720);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setLocationRelativeTo(null);
		setResizable(false);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
	
	}

	public void mouseClicked(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
	
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
	
	}

	public void actionPerformed(ActionEvent e) {
	
	}

}