package game_code;

public class Main {
	public static GameFrame mainFrame;
	
	public static void main(String[] args) {
		
		mainFrame = new GameFrame();
		
		mainFrame.putWindow(new MainMenu(mainFrame.getSize()));
		
	}

}

// 390 lines of code