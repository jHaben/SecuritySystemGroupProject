package states;

public class AwayCountdownStage extends SecuritySystemState{
private static AwayCountdownStage instance;
	
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
		//SecuritySystemContext.instance().showReady();
	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub
		
	}

}
