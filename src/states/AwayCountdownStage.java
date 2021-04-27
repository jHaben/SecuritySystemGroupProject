package states;

import buttons.CheckBoxes;
import events.SixtySecondEvent;
import events.TimerTickedEvent;
import timer.Notifiable;
import timer.Timer;

public class AwayCountdownStage extends SecuritySystemState implements Notifiable{
	private static AwayCountdownStage instance;
;
	/**
	 * Private constructor. Singleton.
	 */
	private AwayCountdownStage() {
	}
	
	/**
	 * returning the instance
	 * @return the instance object
	 */
	public static AwayCountdownStage instance() {
		if (instance == null) {
			instance = new AwayCountdownStage();
		}
		return instance;
	}
	
	/**
	 * Entering unarmed state. 
	 * Will display on the GUI
	 */
	@Override
	public void enter() {
	       SecuritySystemContext.instance().showTimeLeft(SecuritySystemContext.instance().getTimer().getTimeValue());	}

	@Override
	public void leave()  {
		SecuritySystemContext.instance().getTimer().stop();
		SecuritySystemContext.instance().setTimer(null);
        SecuritySystemContext.instance().showTimeLeft(0);	
	   	}

	@Override
	public void handleEvent(TimerTickedEvent event) {
		SecuritySystemContext.instance().showTimeLeft(SecuritySystemContext.instance().getTimer().getTimeValue());
		
	}

	
	@Override
	public void handleEvent(SixtySecondEvent event) throws InterruptedException  {
		 SecuritySystemContext.instance().showTimeLeft(0);
		 SecuritySystemContext.instance().changeState(AwayCheckDoorStage.instance());
		// CheckBoxes.instance().getThread().wait();
	}

}
	
