package events;

public class MovementEvent extends SecuritySystemEvent {
	private static MovementEvent instance;
	/**
	 * Singleton for unarmed event
	 */
	private MovementEvent() {
	}
	
	public static MovementEvent instance() {
		if (instance == null) {
			instance = new MovementEvent();
		}
		return instance;
	}
}
