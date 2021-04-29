package events;

public class AllDoorCloseEvent extends SecuritySystemEvent {
	private static AllDoorCloseEvent instance;
	/**
	 * Singleton for AllDoorCloseEvent event
	 */
	private AllDoorCloseEvent() {
	}
	
	/**
	 * Creates a class instance.
	 * If there is already an instance,
	 * it returns the instance. 
	 * Otherwise it creates a new instance.
	 * @return
	 */
	public static AllDoorCloseEvent instance() {
		if (instance == null) {
			instance = new AllDoorCloseEvent();
		}
		return instance;
	}

}
