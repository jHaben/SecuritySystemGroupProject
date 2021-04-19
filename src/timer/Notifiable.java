package timer;

import events.SixtySecondEvent;
import events.TimerTickedEvent;

/**
 * An entity that can be notified of timing events
 * 
 * @author Brahma Dathan
 *
 */
public interface Notifiable {
    /**
     * Process timer ticks
     */
    public void handleEvent(TimerTickedEvent event);

    /**
     * Process timer runs out event
     */
    public void handleEvent(SixtySecondEvent event);
}
