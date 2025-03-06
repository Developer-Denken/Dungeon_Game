package game_code;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.WindowEvent;

import javax.swing.SwingUtilities;

public class MainMenu extends WindowPanel {
	private static final long serialVersionUID = -3678470337014277678L;
	
	private Button playButton;
	private Button exitButton;
	
	public MainMenu(Dimension d) {
		ORIGINAL_SIZE = new Dimension(320, 180);
		SwingUtilities.invokeLater(() -> initWindow(d));
		updateGUI();
	}
	
	@Override
	protected void initWindow(Dimension d) {
		super.initWindow(d);
		
		playButton = new Button(clickables, scalar);
		playButton.setLocation(this.centerElement(playButton.getSize()));
		playButton.setColor(Color.orange);
		playButton.setClickEvent(this::playButtonClicked);
		playButton.setText("PLAY!");
		playButton.setTextEffect(1);
		
		exitButton = new Button(clickables, scalar);
		exitButton.setLocation(this.centerElement(exitButton.getSize()));
		exitButton.translate(new Point(0, 20));
		exitButton.setColor(Color.cyan);
		exitButton.setClickEvent(() -> Main.mainFrame.dispatchEvent(new WindowEvent(Main.mainFrame, WindowEvent.WINDOW_CLOSING)));
		exitButton.setText("EXIT");
		exitButton.setTextEffect(1);
		
		drawables.add(playButton);
		drawables.add(exitButton);
	}
	
	public void playButtonClicked() {
		Main.mainFrame.putWindow(new GameWindow(Main.mainFrame.getSize()));
	}
}
