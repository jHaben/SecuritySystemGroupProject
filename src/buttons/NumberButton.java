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

	@Override
	public void handle(ActionEvent event) {

		String currentStateString = SecuritySystemContext.instance().getCurrentState().getClass().getSimpleName();
		while (currentStateString.equals("PasswordRequiredStage")) {
			
		}
		
		
		if(currentStateString.equals("PasswordRequiredStage")) {
			GUIDisplay.getInstance().showingPassword(numberButtonValue);

			
		}
		
	}

}
