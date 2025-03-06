package game_code;

import java.awt.Color;
import javax.swing.JFrame;

public class GameFrame extends JFrame {
	private static final long serialVersionUID = 713222573799139487L;
	
	private WindowPanel currentWindow;

	public GameFrame() {
		
		// Sets up and initializes the game frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.setLayout(null);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.getContentPane().setBackground(Color.black);
		this.setVisible(true);
		
	}
	
	public <T extends WindowPanel> void putWindow(T window) {
		if(currentWindow != null) this.remove(currentWindow);
		
		this.add(window);
		currentWindow = window;
	}
}
