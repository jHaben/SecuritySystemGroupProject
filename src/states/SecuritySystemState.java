package states;

import events.AllDoorCloseEvent;
import events.AwayPressEvent;
import events.CancelPressEvent;
import events.DoorOpensEvent;
import events.MovementEvent;
import events.SixtySecondEvent;
import events.StayPressEvent;
import events.TimerTickedEvent;
import events.ValidPassEvent;

/**
 * SecuritySystemState class. Singleton class
 * Class that determines the handleEvent of said class
 * 
 * @author Group: Mitchell Young, Kou Yang, Trung Pham, Jack Haben
 */
public abstract class SecuritySystemState {
	
	/**
	 * Initializing the state
	 */
	public abstract void enter();
	
	/**
	 * Leaving the state
	 */
	public abstract void leave();
	
	/**
	 * handleEvent method for when DoorOpensEvent
	 * occurs. 
	 * @param event
	 */
	public void handleEvent(DoorOpensEvent event) {
	}

	/**
	 * handleEvent method for when DoorOpensEvent
	 * occurs. 
	 * @param event
	 */
	public  void handleEvent(AllDoorCloseEvent event) {
	}
	
	/**
	 * handleEvent method for when CancelPressEvent
	 * occurs. 
	 * @param event
	 */
	public void handleEvent(CancelPressEvent event) {
	}

	/**
	 * 
	 * handleEvent method for when MovementEvent
	 * occurs. 
	 * @param event
	 */
	public void handleEvent(MovementEvent event) {
	}

	/**
	 * handleEvent method for when StayPressEvent
	 * occurs. 
	 * @param event
	 */
	public void handleEvent(StayPressEvent event) {
	}

	/**
	 * handleEvent method for when AwayPressEvent
	 * occurs. 
	 * @param event
	 */
	public void handleEvent(AwayPressEvent event) {
	}
	
	/**
	 * handleEvent method for when ValidPassEvent
	 * occurs. 
	 * @param event
	 */
	public void handleEvent(ValidPassEvent event) {
	}

	/**
	 * handleEvent method for when TimerTickedEvent
	 * occurs. 
	 * @param event
	 */
	public  void handleEvent(TimerTickedEvent event) {
	}
	
	/**
	 * handleEvent method for when SixtySecondEvent
	 * occurs. 
	 * @param event
	 */
	public void handleEvent(SixtySecondEvent event) throws InterruptedException {	
	}


	
}
