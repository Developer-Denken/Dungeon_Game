package game_code;

import java.awt.Point;
import java.awt.Rectangle;

public abstract class CollisionHandler {
	
	public static boolean pointInBox(Point point, Rectangle rect) {
		return point.x >= rect.x && point.x <= rect.x + rect.width && point.y >= rect.y && point.y <= rect.y + rect.height;
	}
	
}
