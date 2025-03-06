package game_code;

import java.awt.Point;
import java.util.Map;

public class DungeonRoom {
	
	private Map<Integer, DungeonRoom> connections;
	private Point location;
	
	public DungeonRoom(RoomTemplate template) {
		location = new Point(0, 0);
	}
	
	@Override
	public String toString() {
		return "Position X: " + location.x + ", Position Y: " + location.y;
	}
	
}
