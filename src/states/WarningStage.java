package states;

import events.SixtySecondEvent;
import events.TimerTickedEvent;
import events.ValidPassEvent;
import timer.Notifiable;
import timer.Timer;

public class WarningStage extends SecuritySystemState implements Notifiable {
	private static WarningStage instance;
	private Timer timer;

	private String userEnteredPassword = "";
	private String password = "1234";

	/**
	 * Private constructor. Singleton.
	 */
	private WarningStage() {
	}

	/**
	 * returning the instance
	 * 
	 * @return the instance object
	 */
	public static WarningStage instance() {
		if (instance == null) {
			instance = new WarningStage();
		}
		return instance;
	}

	/**
	 * Entering unarmed state. Will display on the GUI
	 */
	@Override
	public void enter() {
		userEnteredPassword = "";
		SecuritySystemContext.instance().showWarning();
		timer = new Timer(this, 10);
		SecuritySystemContext.instance().showStayCowndown();
		SecuritySystemContext.instance().showTimeLeft(timer.getTimeValue());
	}

	@Override
	public void handleEvent(TimerTickedEvent event) {
		SecuritySystemContext.instance().showTimeLeft(timer.getTimeValue());

	}

	@Override
	public void handleEvent(SixtySecondEvent event) throws InterruptedException {
		SecuritySystemContext.instance().showTimeLeft(0);
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
			userEnteredPassword = SecuritySystemContext.instance().getDisplay().getGuiText().getText();
		}
		else {
			userEnteredPassword += SecuritySystemContext.instance().getDisplay().getGuiText().getText();
		}
		SecuritySystemContext.instance().getDisplay().getGuiText().setText(userEnteredPassword);
		if (userEnteredPassword.equals(password)) {
			SecuritySystemContext.instance().changeState(UnarmedStage.instance());
		}

	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
		SecuritySystemContext.instance().showTimeRunOut();
		SecuritySystemContext.instance().showTimeLeft(0);
		SecuritySystemContext.instance().showBreachState();
		userEnteredPassword = "";
	}
}