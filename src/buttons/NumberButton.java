package buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class NumberButton extends GUIButton implements EventHandler<ActionEvent>{
	String numberButtonValue;
	/**
	 * Button for the number
	 * @param string
	 */
	public NumberButton(String string) {
		super(string);
		numberButtonValue = string;
	}

	@Override
	public void handle(ActionEvent event) {
		System.out.println("Number button: " + numberButtonValue + ", has been clicked. (NumberButton.java)");
		
	}

}
