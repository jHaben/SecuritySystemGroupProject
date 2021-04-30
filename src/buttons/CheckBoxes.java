package buttons;

import events.AllDoorCloseEvent;
import events.DoorOpensEvent;
import javafx.scene.control.CheckBox;
import states.SecuritySystemContext;

/**
 * CheckBoxes class. This class is a super class to the checkboxes in the GUI.
 * Has a method that keeps track of whether the checkboxes have been checked or
 * unchecked.
 * 
 * @author Group: Mitchell Young, Kou Yang, Trung Pham, Jack Haben
 */

public class CheckBoxes {
	// CheckBox variables
	private CheckBox zone1;
	private CheckBox zone2;
	private CheckBox zone3;

	// Checkbox instance
	private static CheckBoxes instance;

	/**
	 * CheckBoxes constructor. Assigns the checkboxes with their appropriate names
	 * 
	 * @return none - Returns the zone information.
	 */
	public CheckBoxes() {
		zone1 = new CheckBox("zone1");
		zone2 = new CheckBox("zone2");
		zone3 = new CheckBox("zone3");

		this.configureCheckBox(zone1, zone2, zone3);
	}

	/**
	 * Instance of the CheckBoxes class Checks if there is already an instance. If
	 * not, then creates a new instance of the class.
	 * 
	 * @return instance.
	 */
	public static CheckBoxes instance() {
		if (instance == null) {
			instance = new CheckBoxes();
		}
		return instance;
	}

	public CheckBox getZone1() {
		return zone1;
	}

	public CheckBox getZone2() {
		return zone2;
	}

	public CheckBox getZone3() {
		return zone3;
	}

	/**
	 * configureCheckBox method. Tells if all the checkboxes are checked. Also
	 * checks if the checkboxes are unchecked In which case, will tell the system
	 * the information accordingly
	 * 
	 * @param checkBox1
	 * @param checkBox2
	 * @param checkBox3
	 */
	private void configureCheckBox(CheckBox checkBox1, CheckBox checkBox2, CheckBox checkBox3) {

		checkBox1.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
			if (isNowSelected) {
				if (checkBox2.isSelected() && checkBox3.isSelected()) {

					SecuritySystemContext.instance().handleEvent(AllDoorCloseEvent.instance());
				}
			} else {

				SecuritySystemContext.instance().handleEvent(DoorOpensEvent.instance());
			}
		});

		checkBox2.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
			if (isNowSelected) {
				if (checkBox1.isSelected() && checkBox3.isSelected()) {

					SecuritySystemContext.instance().handleEvent(AllDoorCloseEvent.instance());
				}
			} else {

				SecuritySystemContext.instance().handleEvent(DoorOpensEvent.instance());
			}
		});

		checkBox3.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
			if (isNowSelected) {
				if (checkBox1.isSelected() && checkBox2.isSelected()) {

					SecuritySystemContext.instance().handleEvent(AllDoorCloseEvent.instance());
				}
			} else {

				SecuritySystemContext.instance().handleEvent(DoorOpensEvent.instance());
			}
		});
	}
}
