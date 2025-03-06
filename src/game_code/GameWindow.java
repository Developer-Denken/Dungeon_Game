package game_code;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingUtilities;

public class GameWindow extends WindowPanel implements Runnable {
	private static final long serialVersionUID = 1761950239538815421L;
	
	private int fps;
	private int delayMillis;
	private Thread gameThread;
	
	private PhysicsObject player;
	
	public GameWindow(Dimension d) {
		ORIGINAL_SIZE = new Dimension(320, 180);
		SwingUtilities.invokeLater(() -> initWindow(d));
		
		fps = 60;
		delayMillis = 1000 / fps;
		gameThread = new Thread(this);
		
		player = new PhysicsObject();
		player.setSize(10, 10);
		player.setLocation(centerElement(player.getSizeAsDimension()));
		player.setColor(Color.green);
		
		updateGUI();
		gameThread.start();
	}
	
	public void newFrame() {
		updateGUI();
	}

	@SuppressWarnings("static-access")
	@Override
	public void run() {
		
		while(gameThread != null) {
			
			long startTime = System.currentTimeMillis();
			
			newFrame();
			
			long endTime = System.currentTimeMillis();
			long delayTime = delayMillis - endTime + startTime;
			
			try {
				gameThread.sleep(delayTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	
}
