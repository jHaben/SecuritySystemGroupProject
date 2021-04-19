package events;

public class ValidPassEvent extends SecuritySystemEvent {
	private static ValidPassEvent instance;
	/**
	 * Singleton for unarmed event
	 */
	private ValidPassEvent() {
	}
	
	public static ValidPassEvent instance() {
		if (instance == null) {
			instance = new ValidPassEvent();
		}
		return instance;
	}
}
