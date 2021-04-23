package buttons;

import events.AllDoorCloseEvent;
import events.DoorOpensEvent;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.scene.control.CheckBox;
import states.SecuritySystemContext;

public class CheckBoxes {
	private CheckBox zone1;
	private CheckBox zone2;
	private CheckBox zone3;
	private Boolean zonesReady = false;
	private static CheckBoxes instance;

	private ObservableSet<CheckBox> selectedCheckBoxes = FXCollections.observableSet();
	private IntegerBinding numCheckBoxesSelected = Bindings.size(selectedCheckBoxes);

	private final int maxNumSelected = 3;

	public CheckBoxes() {
		zone1 = new CheckBox("zone1");
		zone2 = new CheckBox("zone2");
		zone3 = new CheckBox("zone3");

		this.initialize();

	}

	public static CheckBoxes instance() {
		if (instance == null) {
			instance = new CheckBoxes();
		}
		return instance;
	}

	public void initialize() {

		configureCheckBox(zone1);
		configureCheckBox(zone2);
		configureCheckBox(zone3);

		numCheckBoxesSelected.addListener((obs, oldSelectedCount, newSelectedCount) -> {
			if (newSelectedCount.intValue() == maxNumSelected) {
				zonesReady = true;
				SecuritySystemContext.instance().handleEvent(AllDoorCloseEvent.instance());
			} else {
				zonesReady = false;
				SecuritySystemContext.instance().handleEvent(DoorOpensEvent.instance());
			}
		});

	}

	/**
	 * @return the zone1
	 */
	public CheckBox getZone1() {
		return zone1;
	}

	/**
	 * @return the zone2
	 */
	public CheckBox getZone2() {
		return zone2;
	}

	/**
	 * @return the zone3
	 */
	public CheckBox getZone3() {
		return zone3;
	}

	public Boolean getZonesReady() {
		return zonesReady;
	}

	private void configureCheckBox(CheckBox checkBox) {

		if (checkBox.isSelected()) {
			selectedCheckBoxes.add(checkBox);
		}

		checkBox.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
			if (isNowSelected) {

				selectedCheckBoxes.add(checkBox);
			} else {
				selectedCheckBoxes.remove(checkBox);

			}

		});

	}

}
