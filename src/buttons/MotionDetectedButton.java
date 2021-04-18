package buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * MotionDetectedButton class.
 * extends GUIButton class. The button gets the String from GUIDisplay.
 * The handle event will determine what events are to happen.
 * 
 * @author  Group: Mitchell Young, Kou Yang, Trung Pham, Jack Haben
 *
 */

public class MotionDetectedButton extends GUIButton implements EventHandler<ActionEvent>  {

	public MotionDetectedButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
