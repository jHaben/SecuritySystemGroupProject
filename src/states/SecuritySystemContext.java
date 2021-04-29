package states;

import display.SecuritySystemDisplay;
import events.AllDoorCloseEvent;
import events.AwayPressEvent;
import events.CancelPressEvent;
import events.DoorOpensEvent;
import events.MovementEvent;
import events.SixtySecondEvent;
import events.StayPressEvent;
import events.TimerTickedEvent;
import events.ValidPassEvent;
import timer.Notifiable;
import timer.Timer;

/**
 * SecuritySystemContext
 * 
 * 
 * @author Group: Mitchell Young, Kou Yang, Trung Pham, Jack Haben
 */

public class SecuritySystemContext implements Notifiable{
	private SecuritySystemDisplay display;
	private SecuritySystemState currentState;
	private static SecuritySystemContext instance;
	private String userEnteredPassword = "";
	private String password = "1234";
	private Timer timer;
	public Timer getTimer() {
		return timer;
	}
	public void setTimer(Timer timer) {
		this.timer = timer;
	}
	/**
	 * Making the class a singleton
	 */
	private SecuritySystemContext() {
		instance = this;
		currentState = UnarmedStage.instance();
		// currentState.enter();
	}

	public static SecuritySystemContext instance() {
		if (instance == null) {
			instance = new SecuritySystemContext();
		}
		return instance;
	}

	// These are temporary methods used to find the current state
	// Meant for debugging
	public SecuritySystemState getCurrentState() {
		return currentState;
	}

	// These are temporary methods used to find the current state
	// Meant for debugging.
	public void setCurrentState(SecuritySystemState currentState) {
		this.currentState = currentState;
	}

	/**
	 * setDisplay method. When the display changes we can get the reference.
	 * 
	 * @param display
	 * @return
	 */
	public SecuritySystemDisplay getDisplay() {
		return display;
	}

	/**
	 * setDisplay method. When the display changes we can get the reference.
	 * 
	 * @param display
	 */
	public void setDisplay(SecuritySystemDisplay display) {
		this.display = display;
	}
	
	public String getUserEnteredPassword() {
		return userEnteredPassword;
	}

	public void setUserEnteredPassword(String userEnteredPassword) {
		this.userEnteredPassword = userEnteredPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Initializing UnarmedState as the default state
	 */
	public void initialize() {
		instance.changeState(UnarmedStage.instance());
	}

	/**
	 * ChangeState. Method used to change the current state to the next available
	 * state.
	 * 
	 * @param nextState object
	 * @throws InterruptedException
	 */
	public void changeState(SecuritySystemState nextState) {
		System.out.println("Changing states - (SecuritySystemContext.java -> changeState())");
		currentState.leave();
		currentState = nextState;
		currentState.enter();
	}

	/**
	 * Creating methods to determine the event. Remember to create an empty method
	 * in SecuritySystemState.java with the event object as the parameter.
	 * 
	 */

	public void handleEvent(CancelPressEvent event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(ValidPassEvent event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(DoorOpensEvent event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(AllDoorCloseEvent event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(MovementEvent event) {
		currentState.handleEvent(event);

	}

	public void handleEvent(StayPressEvent event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(AwayPressEvent event) {
		currentState.handleEvent(event);

	}

	/**
	 * Calls the showNotReady method in SecuritySystemDisplay (Which in turn calls
	 * it in GUIDisplay).
	 */
	public void showNotReady() {
		display.showNotReady();
	}

	public void showReady() {
		display.showReady();
	}

	public void showStayCowndown() {
		display.showCounDownStart();
	}

	public void showTimeLeft(int time) {
		display.showTimeLeft(time);
	}

	public void showTimeRunOut() {
		display.showTimeRunOut();
	}

	public void showPasswordRequired() {
		display.showPasswordRequired();
	}

	public void showWarning(int time) {
		display.showWarning(time);
	}

	public void passwordBeingEntered() {
		display.showPasswordRequired();
	}

	public void showAwayArmed() {
		display.showAwayArmed();
	}

	public void showStayArmed() {
		display.showStayArmed();
	}

	public void showBreachState() {
		display.showBreachState();
	}
	@Override
	public void handleEvent(TimerTickedEvent event) {
		currentState.handleEvent(event);
		
	}
	@Override
	public void handleEvent(SixtySecondEvent event) throws InterruptedException {
		currentState.handleEvent(event);
		
	}

}
