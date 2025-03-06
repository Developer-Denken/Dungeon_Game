package game_code;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class Dungeon {
	private Map<Point, DungeonRoom> dungeonMap;
	public static int RANDOM;
	
	static {
		RANDOM = 10;
	}
	
	private Dungeon(int type) {
		dungeonMap = new HashMap<>();
		
	}
}
