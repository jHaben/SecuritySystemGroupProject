package buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * Abstract GUI button. 
 * 
 * @author  Group: Mitchell Young, Kou Yang, Trung Pham, Jack Haben
 *
 */

public abstract class GUIButton extends Button implements EventHandler<ActionEvent> {
    
	/**
	 * Creating buttons with text.
	 * 
	 * @param string: The text of the button. 
	 */
	public GUIButton(String string) {
        super(string);
        setOnAction(this);
    }
}
