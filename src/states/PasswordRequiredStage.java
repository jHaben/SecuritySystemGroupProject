package states;

import events.CancelPressEvent;
import events.DoorOpensEvent;
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
		userEnteredPassword = "";
	}

	@Override
	public void leave() {
		userEnteredPassword = "";
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

		SecuritySystemContext.instance().changeState(BreachStage.instance());

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
		if (userEnteredPassword.length() > 5) {
			userEnteredPassword = "";
		}
		else {
			userEnteredPassword += SecuritySystemContext.instance().getDisplay().getGuiText().getText();
		}
		SecuritySystemContext.instance().getDisplay().getGuiText().setText("Enter Password to Disarm.\nPassword:" + userEnteredPassword);
		if (userEnteredPassword.equals(password)) {
			SecuritySystemContext.instance().changeState(ZoneReadyState.instance());
		}

	}

}
