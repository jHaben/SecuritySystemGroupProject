package events;

public class CancelPressEvent extends SecuritySystemEvent {
	private static CancelPressEvent instance;
	/**
	 * Singleton for unarmed event
	 */
	private CancelPressEvent() {
	}
	
	public static CancelPressEvent instance() {
		if (instance == null) {
			instance = new CancelPressEvent();
		}
		return instance;
	}
}
