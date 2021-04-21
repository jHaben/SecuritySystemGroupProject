package states;

import buttons.CheckBoxes;
import buttons.NumberButton;
import display.GUIDisplay;
import display.SecuritySystemDisplay;
import events.AllDoorCloseEvent;
import events.CancelPressEvent;
import events.DoorOpensEvent;
import events.TimerTickedEvent;
import events.ValidPassEvent;

public class PasswordRequiredStage extends SecuritySystemState {
	private static PasswordRequiredStage instance;

	private String password = "1234";
	
	/**
	 * Private constructor. Singleton.
	 */
	private PasswordRequiredStage() {
	}
	
	/**
	 * returning the instance
	 * @return the instance object
	 */
	public static PasswordRequiredStage instance() {
		if (instance == null) {
			instance = new PasswordRequiredStage();
		}
		return instance;
	}
	
	@Override
	public void enter() {
		SecuritySystemContext.instance().showPasswordRequired();
	}

	@Override
	public void leave() {
		
	}
	
	/**
	 * Method that handles if a user clicks cancel while in the 
	 * Password Required state.
	 */
	@Override
	public void handleEvent(CancelPressEvent event) {
		SecuritySystemContext.instance().changeState(StayCheckDoorStage.instance());

	}
	/**
	 * If a zone opens while it is in the Password Required State
	 */
	@Override
	public void handleEvent(DoorOpensEvent event) {
		if(!CheckBoxes.instance().checkZonesReady()) {
			SecuritySystemContext.instance().changeState(BreachStage.instance());
		}
	}
	
	@Override
	public void handleEvent(ValidPassEvent event) {
		
		SecuritySystemContext.instance().getDisplay().showPasswordRequired();
		System.out.println(SecuritySystemContext.instance().getDisplay().getGuiText().getText());
		
	}
	
}
