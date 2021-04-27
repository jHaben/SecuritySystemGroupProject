package states;

import events.AllDoorCloseEvent;
import events.SixtySecondEvent;
import events.TimerTickedEvent;
import events.ValidPassEvent;
import timer.Notifiable;
import timer.Timer;

public class WarningDoorsOpenState extends SecuritySystemState implements Notifiable {
	private static WarningDoorsOpenState instance;
	private Timer timer = new Timer(this, 0);

	/**
	 * Private constructor. Singleton.
	 */
	private WarningDoorsOpenState() {
	}

	/**
	 * returning the instance
	 * 
	 * @return the instance object
	 */
	public static WarningDoorsOpenState instance() {
		if (instance == null) {
			instance = new WarningDoorsOpenState();
		}
		return instance;
	}
	
	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	/**
	 * Entering unarmed state. Will display on the GUI
	 */
	@Override
	public void enter() {
		SecuritySystemContext.instance().showWarning();			//TODO: Not being shown - kou
		SecuritySystemContext.instance().showStayCowndown();	//TODO: Not being shown - kou
		SecuritySystemContext.instance().showTimeLeft(timer.getTimeValue());
		timer.start();
	}
	
	@Override
	public void leave() {
		timer.stop();
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

	public void handleEvent(AllDoorCloseEvent event) {
		WarningDoorsClosedState.instance().getTimer().addTimeValue(timer.getTimeValue()-
				WarningDoorsClosedState.instance().getTimer().getTimeValue());
		SecuritySystemContext.instance().changeState(WarningDoorsClosedState.instance());
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
		SecuritySystemContext.instance().getDisplay().getGuiText().setText(SecuritySystemContext.instance().getUserEnteredPassword());
		if (SecuritySystemContext.instance().getUserEnteredPassword().equals(SecuritySystemContext.instance().getPassword())) {
			SecuritySystemContext.instance().changeState(UnarmedStage.instance());
		}
	}

}

