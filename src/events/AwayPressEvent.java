package events;

public class AwayPressEvent extends SecuritySystemEvent {
	private static AwayPressEvent instance;
	/**
	 * Singleton for unarmed event
	 */
	private AwayPressEvent() {
	}
	
	public static AwayPressEvent instance() {
		if (instance == null) {
			instance = new AwayPressEvent();
		}
		return instance;
	}
}
