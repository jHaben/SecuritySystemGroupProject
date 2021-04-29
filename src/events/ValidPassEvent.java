package events;
/**
 * ValidPassEvent class
 * This class is for the event in which the user enteres the correct password.
 * 
 * @author Group: Mitchell Young, Kou Yang, Trung Pham, Jack Haben
 */
public class ValidPassEvent extends SecuritySystemEvent {
	private static ValidPassEvent instance;
	/**
	 * Singleton for unarmed event
	 */
	private ValidPassEvent() {
	}
	
	public static ValidPassEvent instance() {
		if (instance == null) {
			instance = new ValidPassEvent();
		}
		return instance;
	}
}
