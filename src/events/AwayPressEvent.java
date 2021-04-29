package events;

public class AwayPressEvent extends SecuritySystemEvent {
	private static AwayPressEvent instance;
	/**
	 * Singleton for AwayPressEvent event
	 */
	private AwayPressEvent() {
	}
	
	/**
	 * Creates a class instance.
	 * If there is already an instance,
	 * it returns the instance. 
	 * Otherwise it creates a new instance.
	 * @return
	 */
	public static AwayPressEvent instance() {
		if (instance == null) {
			instance = new AwayPressEvent();
		}
		return instance;
	}
}
