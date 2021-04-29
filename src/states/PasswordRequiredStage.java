package states;

import events.CancelPressEvent;
import events.DoorOpensEvent;
import events.ValidPassEvent;

/**
 * passwordRequiredStage class. Singleton class
 * Class that determines the handleEvent of said class
 * 
 * @author Group: Mitchell Young, Kou Yang, Trung Pham, Jack Haben
 */
public class PasswordRequiredStage extends SecuritySystemState {
	private static PasswordRequiredStage instance;

	/**
	 * Private constructor. Singleton.
	 */
	private PasswordRequiredStage() {
	}

	/**
	 * returning the instance
	 * 
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
	 * Method that handles if a user clicks cancel while in the Password Required
	 * state.
	 */
	@Override
	public void handleEvent(CancelPressEvent event) {
		SecuritySystemContext.instance().changeState(StayStage.instance());

	}

	/**
	 * If a zone opens while it is in the Password Required State
	 */
	@Override
	public void handleEvent(DoorOpensEvent event) {
		SecuritySystemContext.instance().setUserEnteredPassword("");
		SecuritySystemContext.instance().changeState(BreachDoorsOpenStage.instance());

	}

	/**
	 * handleEvent method. Stores whatever the user entered into it's own variable
	 * and re-displays it.
	 * 
	 * It later then checks to see if the password is valid or not.
	 * 
	 * If it's valid, it moves to the next stage.
	 */
	@Override
	public void handleEvent(ValidPassEvent event) {
		if (SecuritySystemContext.instance().getUserEnteredPassword().length() > 5) {
			SecuritySystemContext.instance().setUserEnteredPassword("");
		}
		else {
			SecuritySystemContext.instance().setUserEnteredPassword(SecuritySystemContext.instance().getUserEnteredPassword() +
					SecuritySystemContext.instance().getDisplay().getGuiText().getText());
		}
		SecuritySystemContext.instance().showPasswordRequired();
		if (SecuritySystemContext.instance().getUserEnteredPassword().equals(SecuritySystemContext.instance().getPassword())) {
			SecuritySystemContext.instance().setUserEnteredPassword("");
			SecuritySystemContext.instance().changeState(ZoneReadyState.instance());
		}
	}

}
