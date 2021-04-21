package states;

import buttons.CheckBoxes;
import events.AllDoorCloseEvent;

public class StayCheckDoorStage extends SecuritySystemState {
	private static StayCheckDoorStage instance;
	
	/**
	 * Private constructor. Singleton.
	 */
	private StayCheckDoorStage() {
	}
	
	/**
	 * returning the instance
	 * @return the instance object
	 */
	public static StayCheckDoorStage instance() {
		if (instance == null) {
			instance = new StayCheckDoorStage();
		}
		return instance;
	}
	
	/**
	 * Entering unarmed state. 
	 * Will display on the GUI
	 */
	@Override
	public void enter() {
		if(CheckBoxes.instance().checkZonesReady()) {
		    SecuritySystemContext.instance().changeState(StayStage.instance());
		    } else {  
			SecuritySystemContext.instance().changeState(UnarmedStage.instance());
		}
	}
	
	

	@Override
	public void leave() {
		// TODO Auto-generated method stub
		
	}
}