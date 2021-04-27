package states;

import events.ValidPassEvent;
import buttons.CheckBoxes;

public class BreachStage extends SecuritySystemState {
	private static BreachStage instance;
	
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
	}

	@Override
	public void leave() {
	}
	
	public void handleEvent(ValidPassEvent event) {
		if (SecuritySystemContext.instance().getUserEnteredPassword().length() > 5) {
			SecuritySystemContext.instance().setUserEnteredPassword("");
		}
		else {
			SecuritySystemContext.instance().setUserEnteredPassword(SecuritySystemContext.instance().getUserEnteredPassword() +
					SecuritySystemContext.instance().getDisplay().getGuiText().getText());
		}
		SecuritySystemContext.instance().showBreachState();
		//TODO: WORKAROUND to using 2 text boxes when entering a password to include both state prompt and password. - KOU Yang
		//SecuritySystemContext.instance().getDisplay().getGuiText().setText("BREACHED!\nPassword: " + userEnteredPassword);
		if (SecuritySystemContext.instance().getUserEnteredPassword().equals(SecuritySystemContext.instance().getPassword())) {
			if (CheckBoxes.instance().getZonesReady()) {
				SecuritySystemContext.instance().setUserEnteredPassword("");
				SecuritySystemContext.instance().changeState(ZoneReadyState.instance());
			}
			else {
				SecuritySystemContext.instance().setUserEnteredPassword("");
				SecuritySystemContext.instance().changeState(UnarmedStage.instance());
			}
		}
	}
	
}

