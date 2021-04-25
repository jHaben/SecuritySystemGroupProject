package states;

import events.ValidPassEvent;
import buttons.CheckBoxes;

public class BreachStage extends SecuritySystemState {
	private static BreachStage instance;
	private String userEnteredPassword = "";
	private String password = "1234";
	
	/**
	 * Private constructor. Singleton.
	 */
	private BreachStage() {
	}
	
	/**
	 * returning the instance
	 * @return the instance object
	 */
	public static BreachStage instance() {
		if (instance == null) {
			instance = new BreachStage();
		}
		return instance;
	}
	
	/**
	 * Entering the breach stage.
	 */
	@Override
	public void enter() {
		SecuritySystemContext.instance().showBreachState();
		userEnteredPassword = "";
	}

	@Override
	public void leave() {
		SecuritySystemContext.instance().showNotReady();
		userEnteredPassword = "";
	}
	
	public void handleEvent(ValidPassEvent event) {
		userEnteredPassword += SecuritySystemContext.instance().getDisplay().getGuiText().getText();
		SecuritySystemContext.instance().getDisplay().getGuiText().setText(userEnteredPassword);
		if (userEnteredPassword.equals(password)) {
			if (CheckBoxes.instance().getZonesReady()) {
				SecuritySystemContext.instance().changeState(ZoneReadyState.instance());
			}
			else {
				SecuritySystemContext.instance().changeState(UnarmedStage.instance());
			}
		}
	}
	
}

