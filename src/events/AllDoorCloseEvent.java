package events;

public class AllDoorCloseEvent extends SecuritySystemEvent {
	private static AllDoorCloseEvent instance;
	/**
	 * Singleton for unarmed event
	 */
	private AllDoorCloseEvent() {
	}
	
	public static AllDoorCloseEvent instance() {
		if (instance == null) {
			instance = new AllDoorCloseEvent();
		}
		return instance;
	}

}
