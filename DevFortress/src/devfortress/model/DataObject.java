/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model;

import devfortress.utilities.Event;

/**
 *
 * @author anhtran
 */
public class DataObject {

    private String log;
    private Event event;

    /**
     * Create data object to hold log message and event object.
     *
     * @param log
     * @param event
     */
    public DataObject(String log, Event event) {
        this.log = log;
        this.event = event;
    }

    /**
     * Get log message.
     *
     * @return
     */
    public String getLog() {
        return log;
    }

    /**
     * Get event object.
     *
     * @return
     */
    public Event getEvent() {
        return event;
    }
}
