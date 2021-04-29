package events;

public class DoorOpensEvent extends SecuritySystemEvent {
	private static DoorOpensEvent instance;
	
	/**
	 * Singleton for DoorOpensEvent event
	 */
	private DoorOpensEvent() {
	}
	
	/**
	 * Creates a class instance.
	 * If there is already an instance,
	 * it returns the instance. 
	 * Otherwise it creates a new instance.
	 * @return
	 */
	public static DoorOpensEvent instance() {
		if (instance == null) {
			instance = new DoorOpensEvent();
		}
		return instance;
	}
	
}
