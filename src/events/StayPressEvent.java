package events;

public class StayPressEvent extends SecuritySystemEvent {
	private static StayPressEvent instance;
	/**
	 * Singleton for unarmed event
	 */
	private StayPressEvent() {
	}
	
	/**
	 * Creates a class instance.
	 * If there is already an instance,
	 * it returns the instance. 
	 * Otherwise it creates a new instance.
	 * @return
	 */
	public static StayPressEvent instance() {
		if (instance == null) {
			instance = new StayPressEvent();
		}
		return instance;
	}
}
