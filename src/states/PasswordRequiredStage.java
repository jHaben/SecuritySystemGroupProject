package states;

import buttons.NumberButton;
import events.AllDoorCloseEvent;
import events.CancelPressEvent;
import events.DoorOpensEvent;
import events.TimerTickedEvent;

public class PasswordRequiredStage extends SecuritySystemState {
	private static PasswordRequiredStage instance;
	private String passwordCombinationEntered;
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
	
	@Override
	public void handleEvent(CancelPressEvent event) {
		SecuritySystemContext.instance().changeState(StayCheckDoorStage.instance());
	}
	
	@Override
	public void handleEvent(DoorOpensEvent event) {
		//		System.out.println("BREACH!");
	}
	
}
