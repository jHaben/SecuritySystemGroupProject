package buttons;

import events.StayPressEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.SecuritySystemContext;

/**
 * StayButton class. extends GUIButton class. The button gets the String from
 * GUIDisplay. The handle event will determine what events are to happen.
 * 
 * @author Group: Mitchell Young, Kou Yang, Trung Pham, Jack Haben
 *
 */

public class StayButton extends GUIButton implements EventHandler<ActionEvent> {

	public StayButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		SecuritySystemContext.instance().handleEvent(StayPressEvent.instance());
	}
}
