package buttons;

import display.GUIDisplay;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class NumberButton extends GUIButton implements EventHandler<ActionEvent>{
	private String numberButtonValue;
	
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
		GUIDisplay.getInstance().showingPassword(numberButtonValue);
	}

}
