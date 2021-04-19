package states;

public class StayCoundownStage extends SecuritySystemState{
private static StayCoundownStage instance;
	
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
		//SecuritySystemContext.instance().showReady();
	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub
		
	}

}
