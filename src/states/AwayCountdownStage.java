package states;

import buttons.CheckBoxes;
import events.SixtySecondEvent;
import events.TimerTickedEvent;
import timer.Notifiable;
import timer.Timer;

public class AwayCountdownStage extends SecuritySystemState implements Notifiable{
	private static AwayCountdownStage instance;
	 private Timer timer;
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
		 timer = new Timer(this, 10);
	      // SecuritySystemContext.instance().showStayCowndown();
	       SecuritySystemContext.instance().showTimeLeft(timer.getTimeValue());	}

	@Override
	public void leave() {
		timer.stop();
        timer = null;
        //SecuritySystemContext.instance().showTimeRunOut();
        SecuritySystemContext.instance().showTimeLeft(0);			
	}

	@Override
	public void handleEvent(TimerTickedEvent event) {
		SecuritySystemContext.instance().showTimeLeft(timer.getTimeValue());
		
	}

	@Override
	public void handleEvent(SixtySecondEvent event) {
		 SecuritySystemContext.instance().showTimeLeft(0);
		 //if(CheckBoxes.instance().checkZonesReady()) {
		 SecuritySystemContext.instance().changeState(AwayCheckDoorStage.instance());		
	}

}
