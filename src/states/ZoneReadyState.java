package states;

import events.AllDoorCloseEvent;
import events.AwayPressEvent;
import events.DoorOpensEvent;
import events.SixtySecondEvent;
import events.StayPressEvent;
import events.TimerTickedEvent;
import timer.Notifiable;
import timer.Timer;

public class ZoneReadyState extends SecuritySystemState implements Notifiable{
private static ZoneReadyState instance;
	
	/**
	 * Private constructor. Singleton.
	 */
	private ZoneReadyState() {
	}
	
	/**
	 * returning the instance
	 * @return the instance object
	 */
	public static ZoneReadyState instance() {
		if (instance == null) {
			instance = new ZoneReadyState();
		}
		return instance;
	}
	
	/**
	 * Entering unarmed state. 
	 * Will display on the GUI
	 */
	@Override
	public void enter() {
		SecuritySystemContext.instance().showReady();
	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub
	}
	
	public void handleEvent(DoorOpensEvent event ) {
		SecuritySystemContext.instance().changeState(UnarmedStage.instance());
	}
	public void handleEvent(StayPressEvent event ) {
		//add time to timer
		SecuritySystemContext.instance().changeState(StayCoundownStage.instance());
	}
	public void handleEvent(AwayPressEvent event ) {
		SecuritySystemContext.instance().setTimer(new Timer(SecuritySystemContext.instance(), 5));
		SecuritySystemContext.instance().changeState(AwayCountdownStage.instance());
	}

	@Override
	public void handleEvent(TimerTickedEvent event) {
		SecuritySystemContext.instance().showTimeLeft(SecuritySystemContext.instance().getTimer().getTimeValue());
		
	}

	@Override
	public void handleEvent(SixtySecondEvent event) throws InterruptedException {
		// TODO Auto-generated method stub
		
	}
}
