package events;

public class MovementEvent extends SecuritySystemEvent {
	private static MovementEvent instance;
	/**
	 * Singleton for MovementEvent event
	 */
	private MovementEvent() {
	}
	
	/**
	 * Creates a class instance.
	 * If there is already an instance,
	 * it returns the instance. 
	 * Otherwise it creates a new instance.
	 * @return
	 */
	public static MovementEvent instance() {
		if (instance == null) {
			instance = new MovementEvent();
		}
		return instance;
	}
}
