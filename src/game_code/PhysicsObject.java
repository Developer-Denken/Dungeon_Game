package game_code;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

public class PhysicsObject {

	private Vector location;
	private Vector size;
	private Color color;
	
	public PhysicsObject() {
		location = new Vector(0, 0);
		size = new Vector(0, 0);
	}
	
	public void setLocation(Point p) {
		location.x = p.x;
		location.y = p.y;
	}
	
	public void setSize(double width, double height) {
		size.x = width;
		size.y = height;
	}
	
	public Dimension getSizeAsDimension() {
		return new Dimension((int) size.x, (int) size.y);
	}
	
	public void setColor(Color c) {
		color = c;
	}
	
	public Color getColor() {
		return color;
	}
}
