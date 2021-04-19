package events;

public class DoorOpensEvent extends SecuritySystemEvent {
	private static DoorOpensEvent instance;
	
	/**
	 * Singleton for unarmed event
	 */
	private DoorOpensEvent() {
	}
	
	public static DoorOpensEvent instance() {
		if (instance == null) {
			instance = new DoorOpensEvent();
		}
		return instance;
	}
	
}
