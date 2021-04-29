package buttons;

import events.AwayPressEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.SecuritySystemContext;

/**
 * AwayButton class. extends GUIButton class. The button gets the String from
 * GUIDisplay. The handle event will determine what events are to happen.
 * 
 * @author Group: Mitchell Young, Kou Yang, Trung Pham, Jack Haben
 *
 */

public class AwayButton extends GUIButton implements EventHandler<ActionEvent> {
	
	/**
	 * AwayButton Constructor. 
	 * Takes the super and uses the string for naming the button
	 * 
	 * @param string
	 */
	public AwayButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		SecuritySystemContext.instance().handleEvent(AwayPressEvent.instance());
	}

}
