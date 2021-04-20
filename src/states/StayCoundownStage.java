package states;

import timer.Timer;
import events.SixtySecondEvent;
import events.TimerTickedEvent;
import timer.Notifiable;


public class StayCoundownStage extends SecuritySystemState implements Notifiable{
private static StayCoundownStage instance;
private Timer timer;
	
	/**
	 * Private constructor. Singleton.
	 */
	private StayCoundownStage() {
	}
	
	/**
	 * returning the instance
	 * @return the instance object
	 */
	public static StayCoundownStage instance() {
		if (instance == null) {
			instance = new StayCoundownStage();
		}
		return instance;
	}
	
	/**
	 * Entering unarmed state. 
	 * Will display on the GUI
	 */
	@Override
	public void enter() {
		  timer = new Timer(this, 10);
	       SecuritySystemContext.instance().showStayCowndown();
	       SecuritySystemContext.instance().showTimeLeft(timer.getTimeValue());
	}

	@Override
	public void leave() {
		timer.stop();
        timer = null;
        SecuritySystemContext.instance().showTimeRunOut();
        SecuritySystemContext.instance().showTimeLeft(0);		
	}

	@Override
	public void handleEvent(TimerTickedEvent event) {
		SecuritySystemContext.instance().showTimeLeft(timer.getTimeValue());
	}

	@Override
	public void handleEvent(SixtySecondEvent event) {
		// TODO Auto-generated method stub
		
	}

}
