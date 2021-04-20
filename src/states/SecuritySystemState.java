package states;

import events.AllDoorCloseEvent;
import events.AwayPressEvent;
import events.DoorOpensEvent;
import events.MovementEvent;
import events.StayPressEvent;

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

	public void handleEvent(MovementEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void handleEvent(StayPressEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void handleEvent(AwayPressEvent event) {
		// TODO Auto-generated method stub
		
	}
	
}
