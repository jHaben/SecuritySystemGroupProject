package buttons;

import events.AllDoorCloseEvent;
import events.CancelPressEvent;
import events.StayPressEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.SecuritySystemContext;

/**
 * StayButton class.
 * extends GUIButton class. The button gets the String from GUIDisplay.
 * The handle event will determine what events are to happen.
 * 
 * @author  Group: Mitchell Young, Kou Yang, Trung Pham, Jack Haben
 *
 */

public class CurrentStateButton extends GUIButton implements EventHandler<ActionEvent> {
	
	
	public CurrentStateButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		/**
		 * Making a string for the current state 
		 * Has to be in the handle method.
		 */
		String currentStateString = SecuritySystemContext.instance().getCurrentState().getClass().getSimpleName();
		System.out.println(currentStateString);
		}
}
