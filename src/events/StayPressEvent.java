package events;

public class StayPressEvent extends SecuritySystemEvent {
	private static StayPressEvent instance;
	/**
	 * Singleton for unarmed event
	 */
	private StayPressEvent() {
	}
	
	public static StayPressEvent instance() {
		if (instance == null) {
			instance = new StayPressEvent();
		}
		return instance;
	}
}
