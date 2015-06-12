package invaders;
import java.applet.*;
import java.awt.*;
import javax.swing.JFrame;


public class InvaderWindow extends JFrame {

	/**
	 * Rob Casale
	 */
	public InvaderWindow() {
		add(new Board());	//adds in everything from Board class
	    setTitle("Pumpkin Invaders");	//makes title
	    setDefaultCloseOperation(EXIT_ON_CLOSE);	//allows user to close window
	    setSize(840, 700);		//makes window size
	    setLocationRelativeTo(null);
	    setVisible(true);		//makes visible
	    setResizable(false);	//ability to resize window is off
	}
	public static void main(String[] args) {
		new InvaderWindow();	//calls InvaderWindow method
	}
}
