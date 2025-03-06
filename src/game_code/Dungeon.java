package game_code;

import java.awt.Point;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Dungeon {
	private Map<Point, DungeonRoom> dungeonMap;
	private int type;
	public static int RANDOM;
	
	static {
		RANDOM = 0;
	}
	
	private Dungeon(int type) {
		this.type = type;
		dungeonMap = generateRandomDungeonMap();
	}
	
	private Map<Point, DungeonRoom> generateRandomDungeonMap() {
		// Generates The Dungeon Through a Wave Collapse Function (Probably)
		
		Map<Point, DungeonRoom> dunMap = new HashMap<>();
		
		dunMap.put(new Point(0, 0), new DungeonRoom(RoomTemplate.START_ROOM));
		
		Set<DungeonRoom> availableRooms = getAvailableRoomsFromDungeon(dunMap);
		
		return dunMap;
	}
	
	private Set<DungeonRoom> getAvailableRoomsFromDungeon(Map<Point, DungeonRoom> dunMap) {
		Set<DungeonRoom> availableRooms = new HashSet<>();
		
		for(Map.Entry<Point, DungeonRoom> room : dunMap.entrySet()) {
			System.out.println(room);
		}
		
		return availableRooms;
	}
}
