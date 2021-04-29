package buttons;

import events.AwayPressEvent;
import events.MovementEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.SecuritySystemContext;

/**
 * MotionDetectedButton class.
 * extends GUIButton class. The button gets the String from GUIDisplay.
 * The handle event will determine what events are to happen.
 * 
 * @author  Group: Mitchell Young, Kou Yang, Trung Pham, Jack Haben
 *
 */

public class MotionDetectedButton extends GUIButton implements EventHandler<ActionEvent>  {

	/**
	 * MotionDetectedButton Constructor. 
	 * Takes the super and uses the string for naming the button
	 * 
	 * @param string
	 */
	public MotionDetectedButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent arg0) {
		 SecuritySystemContext.instance().handleEvent(MovementEvent.instance());		
	}

}
