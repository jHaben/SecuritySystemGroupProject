package buttons;

import display.GUIDisplay;
import events.CancelPressEvent;
import events.ValidPassEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.PasswordRequiredStage;
import states.SecuritySystemContext;

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

	/**
	 * Handle method. Listens to any number that gets clicked
	 * Whenever a number gets triggered, it clears the text field of what was already there
	 * example "Enter password to disarm alarm", then calls a method to 'write' the clicked number.
	 * 
	 * After which, the handlevent in passwordRequiredStage.java copies what is entered, places 
	 * it in it's own variable, and re-displays it for the user, the handle method clears it every time.
	 * 
	 */
	@Override
	public void handle(ActionEvent event) {
			GUIDisplay.getInstance().clearText();
			GUIDisplay.getInstance().showingPassword(numberButtonValue);
			SecuritySystemContext.instance().handleEvent(ValidPassEvent.instance());
		}
		
	}


