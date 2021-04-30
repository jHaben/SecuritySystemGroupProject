package states;

import events.AllDoorCloseEvent;
import events.SixtySecondEvent;
import events.TimerTickedEvent;
import events.ValidPassEvent;
import timer.Notifiable;
import timer.Timer;

/**
 * WarningDoorsOpenState class. Singleton class
 * Class that determines the handleEvent of said class
 * 
 * @author Group: Mitchell Young, Kou Yang, Trung Pham, Jack Haben
 */
public class WarningDoorsOpenState extends SecuritySystemState implements Notifiable {
	private static WarningDoorsOpenState instance;
	
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
	

	/**
	 * Entering WarningDoorsOpenState state. Will display on the GUI
	 */
	@Override
	public void enter() {
		SecuritySystemContext.instance().showStayCowndown();	
		SecuritySystemContext.instance().showWarning
		(SecuritySystemContext.instance().getTimer().getTimeValue());
		
	}
	
	@Override
	public void leave() {
		
	}

	@Override
	public void handleEvent(TimerTickedEvent event) {
		SecuritySystemContext.instance().showWarning
		(SecuritySystemContext.instance().getTimer().getTimeValue());
	}

	@Override
	public void handleEvent(SixtySecondEvent event) throws InterruptedException {
		SecuritySystemContext.instance().setUserEnteredPassword("");
		SecuritySystemContext.instance().changeState(BreachDoorsOpenStage.instance());
		SecuritySystemContext.instance().getTimer().stop();
		SecuritySystemContext.instance().setTimer(null);
	}

	
	public void handleEvent(AllDoorCloseEvent event) {
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
		} else {
			SecuritySystemContext.instance().setUserEnteredPassword(SecuritySystemContext.instance().getUserEnteredPassword() +
			SecuritySystemContext.instance().getDisplay().getGuiText().getText());
		}
		SecuritySystemContext.instance().showWarning(SecuritySystemContext.instance().getTimer().getTimeValue());
		
		//SecuritySystemContext.instance().getDisplay().getGuiText().setText(SecuritySystemContext.instance().getUserEnteredPassword());
		if (SecuritySystemContext.instance().getUserEnteredPassword().equals(SecuritySystemContext.instance().getPassword())) {
			SecuritySystemContext.instance().setUserEnteredPassword("");
			SecuritySystemContext.instance().changeState(UnarmedStage.instance());
		}
	}

}

