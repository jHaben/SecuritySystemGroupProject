package events;

/**
 * Represents the TimerRanOut event.
 *
 */
public class SixtySecondEvent extends SecuritySystemEvent {
    private static SixtySecondEvent instance;

    /**
     * Private for singleton
     * 
     */
    private SixtySecondEvent() {

    }

    /**
     * For the singleton pattern
     * 
     * @return the only instance
     */
    public static SixtySecondEvent instance() {
        if (instance == null) {
            instance = new SixtySecondEvent();
        }
        return instance;
    }
}