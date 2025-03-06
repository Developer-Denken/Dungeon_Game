package game_code;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Set;

public class UIObject {
	protected Dimension size;
	protected Point location;
	protected Color color;
	protected Runnable clickEvent;
	protected String text;
	protected Color textColor;
	protected int textFont;
	protected int textEffect;
	protected Font currentFont;
	protected int scalar;
	
	public UIObject(int scalar) {
		size = new Dimension();
		location = new Point();
		
		this.scalar = scalar;
	}
	
	public void setColor(Color c) {
		color = c;
	}
	
	public Color getColor() {
		return color;
	}
	
	public int getWidth() {
		return size.width;
	}
	
	public int getHeight() {
		return size.height;
	}
	
	public int getX() {
		return location.x;
	}
	
	public int getY() {
		return location.y;
	}
	
	public void setSize(int width, int height) {
		size.width = width;
		size.height = height;
	}
	
	public Dimension getSize() {
		return new Dimension(size);
	}
	
	public void setLocation(int x, int y) {
		location.x = x;
		location.y = y;
	}
	
	public void setLocation(Point point) {
		location = new Point(point);
	}
	
	public Rectangle getRect() {
		return new Rectangle(location.x, location.y, size.width, size.height);
	}
	
	public void onClickEvent() {
		if(clickEvent != null) clickEvent.run();
	}
	
	public void setClickEvent(Runnable e, Set<UIObject> clickables) {
		clickEvent = e;
		clickables.add(this);
	}
	
	public void setClickEvent(Runnable e) {
		clickEvent = e;
	}
	
	public void draw(Graphics2D paint) {
		paint.setColor(color);
		paint.fillRect(scalar * location.x, scalar * location.y, scalar * size.width, scalar * size.height);
		
		drawText(paint);
	}
	
	public void setText(String s) {
		text = s;
		if(textColor == null) textColor = Color.black;
	}
	
	public void setTextColor(Color c) {
		textColor = c;
		currentFont = new Font(FontHandler.getTextFont(textFont), textEffect, size.height * scalar);
	}
	
	public void setTextEffect(int effect) {
		textEffect = effect;
		currentFont = new Font(FontHandler.getTextFont(textFont), textEffect, size.height * scalar);
	}
	
	public void translate(Point d) {
		location.x += d.x;
		location.y += d.y;
	}
	
	protected void drawText(Graphics2D paint) {
		if(text == null) return;
		
		paint.setColor(textColor);
		paint.setFont(currentFont);
		paint.drawString(text, location.x * scalar, location.y * scalar + size.height * scalar);
	}
}
