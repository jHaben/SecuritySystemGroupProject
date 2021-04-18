package events;

public class UnarmedEvent {
	private static UnarmedEvent instance;
	
	/**
	 * Singleton for unarmed event
	 */
	private UnarmedEvent() {
	}
	
	public static UnarmedEvent instance() {
		if (instance == null) {
			instance = new UnarmedEvent();
		}
		return instance;
	}
	
}
