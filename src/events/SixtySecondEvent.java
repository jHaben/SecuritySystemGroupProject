package events;

/**
 * Represents the TimerRanOut event.
 *
 */
public class SixtySecondEvent extends SecuritySystemEvent {
    private static SixtySecondEvent instance;

	/**
	 * Singleton for SixtySecondEvent event
	 */
    private SixtySecondEvent() {

    }

	/**
	 * Creates a class instance.
	 * If there is already an instance,
	 * it returns the instance. 
	 * Otherwise it creates a new instance.
	 * @return
	 */
    public static SixtySecondEvent instance() {
        if (instance == null) {
            instance = new SixtySecondEvent();
        }
        return instance;
    }
}