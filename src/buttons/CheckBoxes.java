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
	private static CheckBoxes instance;
	private boolean zonesReady;
	public CheckBoxes() {
		zone1 = new CheckBox("zone1");
		zone2 = new CheckBox("zone2");
		zone3 = new CheckBox("zone3");
		zonesReady=false;
		this.configureCheckBox(zone1,zone2,zone3);

	}

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

	public Boolean getZonesReady() {
		return zonesReady;
	}

	private void configureCheckBox(CheckBox checkBox1,CheckBox checkBox2,CheckBox checkBox3) {

		checkBox1.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
			if (isNowSelected) {
				if(checkBox2.isSelected()&&checkBox3.isSelected()) {
					zonesReady=true;;
					SecuritySystemContext.instance().handleEvent(AllDoorCloseEvent.instance());
				}
			}
			else {
					zonesReady=false;
					SecuritySystemContext.instance().handleEvent(DoorOpensEvent.instance());
			}
				});
	
		checkBox2.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
			if (isNowSelected) {
				if(checkBox1.isSelected()&&checkBox3.isSelected()) {
					zonesReady=true;
					SecuritySystemContext.instance().handleEvent(AllDoorCloseEvent.instance());
				}
			}
			else { 
					zonesReady=false;
					SecuritySystemContext.instance().handleEvent(DoorOpensEvent.instance());
			}
				});
		
		checkBox3.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
			if (isNowSelected) {
				if(checkBox1.isSelected()&&checkBox2.isSelected()) {
					zonesReady=true;
					SecuritySystemContext.instance().handleEvent(AllDoorCloseEvent.instance());
				}
			}
			else { 
					zonesReady=false;
					SecuritySystemContext.instance().handleEvent(DoorOpensEvent.instance());
			}
				});
	}
}
				
			

