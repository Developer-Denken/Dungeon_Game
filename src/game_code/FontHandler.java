package game_code;

import java.awt.GraphicsEnvironment;
import java.util.Arrays;
import java.util.List;

public abstract class FontHandler {
	private static List<String> fonts = Arrays.asList(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
	
	public static String getTextFont(int fontID) {
		return fonts.get(fontID);
	}
	
}
