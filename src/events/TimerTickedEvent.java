package events;

/**
 * TimerTickedEvent class
 * This class keeps track of the timer and everytime it ticks.
 * 
 * @author Group: Mitchell Young, Kou Yang, Trung Pham, Jack Haben
 */
public class TimerTickedEvent extends SecuritySystemEvent {
    private int timeLeft;

    /**
     * TimerTickedEvent constructor
     * Stores the value of the timer left. 
     * 
     * @param value
     */
    public TimerTickedEvent(int value) {
        this.timeLeft = value;
    }


    /**
     * getTimeLeft method
     * Gets the remaining time for
     * whenever it is called.
     * 
     * @return timeLeft - an integer value displaying the time
     */
    public int getTimeLeft() {
        return timeLeft;
    }
}