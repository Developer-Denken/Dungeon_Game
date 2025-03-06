package game_code;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public abstract class WindowPanel extends JPanel implements MouseListener {
	private static final long serialVersionUID = -5403196563896341414L;
	protected Dimension ORIGINAL_SIZE;
	protected int scalar;
	protected Image currentImage;
	protected Set<UIObject> clickables;
	protected Set<UIObject> drawables;
	
	protected void initWindow(Dimension d) {
		clickables = new HashSet<>();
		drawables = new HashSet<>();
		
		this.setSize(getScaledSize(d));
		this.setLocation(getCenteredPosition(d));
		this.setOpaque(true);
		
		this.addMouseListener(this);
	}
	
	public void paint(Graphics g) {
		super.paintComponent(g);

		Graphics2D paint = (Graphics2D) g;
		
		for(UIObject o : drawables) o.draw(paint);
	}
	
	protected Dimension getScaledSize(Dimension d) {
		scalar = (int) Math.min((double) d.width / ORIGINAL_SIZE.width, (double) d.height / ORIGINAL_SIZE.height);
		return new Dimension(ORIGINAL_SIZE.width * scalar, ORIGINAL_SIZE.height * scalar);
	}
	
	public Point getCenteredPosition(Dimension d) {
		return new Point((d.width - this.getWidth()) / 2, (d.height - this.getHeight()) / 2);
	}
	
	protected Point centerElement(Dimension d) {
		return new Point((ORIGINAL_SIZE.width - d.width) / 2, (ORIGINAL_SIZE.height - d.height) / 2);
	}
	
	protected void drawUIObject(UIObject o, Graphics2D paint) {
		paint.setColor(o.getColor());
		paint.fillRect(o.getX(), o.getY(), o.getWidth(), o.getHeight());
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		for(UIObject o : clickables) {
			if(CollisionHandler.pointInBox(new Point(e.getX() / scalar, e.getY() / scalar), o.getRect())) o.onClickEvent();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void updateGUI() {
		SwingUtilities.invokeLater(() -> repaint());
	}
}
