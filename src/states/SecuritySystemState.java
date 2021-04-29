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

public abstract class SecuritySystemState {
	
	/**
	 * Initializing the state
	 */
	public abstract void enter();
	
	/**
	 * Leaving the state
	 */
	public abstract void leave();
	
	public void handleEvent(DoorOpensEvent event) {
		
	}

	public  void handleEvent(AllDoorCloseEvent event) {
		
	}
	
	public void handleEvent(CancelPressEvent event) {
		
	}

	public void handleEvent(MovementEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void handleEvent(StayPressEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void handleEvent(AwayPressEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void handleEvent(ValidPassEvent event) {
		// TODO Auto-generated method stub
		
	}

	public  void handleEvent(TimerTickedEvent event) {
	}
	public void handleEvent(SixtySecondEvent event) throws InterruptedException {
		
	}


	
}
