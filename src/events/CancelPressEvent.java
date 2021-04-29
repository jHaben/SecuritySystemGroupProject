package events;

public class CancelPressEvent extends SecuritySystemEvent {
	private static CancelPressEvent instance;
	/**
	 * Singleton for CancelPressEvent event
	 */
	private CancelPressEvent() {
	}
	
	/**
	 * Creates a class instance.
	 * If there is already an instance,
	 * it returns the instance. 
	 * Otherwise it creates a new instance.
	 * @return
	 */
	public static CancelPressEvent instance() {
		if (instance == null) {
			instance = new CancelPressEvent();
		}
		return instance;
	}
}
