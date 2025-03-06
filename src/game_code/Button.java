package game_code;

import java.util.Set;

public class Button extends UIObject {
	
	public Button(Set<UIObject> clickables, int scalar) {
		super(scalar);
		
		this.size.width = 30;
		this.size.height = 10;
		
		clickEvent = () -> System.out.println("CLICK EVENT NOT ASSIGNED");
		this.setClickEvent(this.clickEvent, clickables);
	}
	
}
