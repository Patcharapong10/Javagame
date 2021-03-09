import java.awt.Graphics;
import javax.swing.JPanel;

public class Run extends JPanel{
	Welcome_Page obj ;
	Main_BS obj1;
	public Run() {
		obj = new Welcome_Page();
	}
	
	public static void main(String[] args) {
		new Run();
		
	}
}