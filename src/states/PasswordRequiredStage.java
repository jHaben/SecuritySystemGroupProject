package states;

import com.sun.org.apache.xerces.internal.parsers.SecurityConfiguration;

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
	
	private String userEnteredPassword = "";
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
	
	
	/**
	 * handleEvent method.
	 * Stores whatever the user entered into it's own variable and re-displays it.
	 * 
	 * It later then checks to see if the password is valid or not. 
	 * 
	 * If it's valid, it moves to the next stage. 
	 */
	@Override
	public void handleEvent(ValidPassEvent event) {
		userEnteredPassword += SecuritySystemContext.instance().getDisplay().getGuiText().getText();
		SecuritySystemContext.instance().getDisplay().getGuiText().setText(userEnteredPassword);
		if (userEnteredPassword.equals(password)) {
			SecuritySystemContext.instance().changeState(UnarmedStage.instance());
		}
		
	}
	
}
