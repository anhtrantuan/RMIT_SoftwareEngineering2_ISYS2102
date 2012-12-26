/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.model;

import devfortress.utilities.Event;
import java.util.ArrayList;

/**
 *
 * @author anhtran
 */
public class DataObject {

    private String log;
    private ArrayList<Event> events;

    /**
     * Create data object to hold log message and event object.
     *
     * @param log
     * @param event
     */
    public DataObject(String log, ArrayList<Event> events) {
        this.log = log;
        this.events = events;
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
     * Get event objectd.
     *
     * @return
     */
    public ArrayList<Event> getEvents() {
        return events;
    }
}
