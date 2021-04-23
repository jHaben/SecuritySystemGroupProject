package buttons;


import javafx.scene.control.CheckBox;
import buttons.GUICheckBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Abstract CheckBox class.. 
 * 
 * @author  Group: Mitchell Young, Kou Yang, Trung Pham, Jack Haben
 *
 */

public abstract class GUICheckBox extends CheckBox{
	/**
	 * Creating Check boxes with appropriate text.
	 * 
	 * @param string: The text of the check box. 
	 */
	public GUICheckBox(String string) {
        super(string);
    }
}
