package za.ac.cput.communitystoremarketplace.Factory;

import za.ac.cput.communitystoremarketplace.Domain.Event;

import java.sql.Time;
import java.util.Date;

public class EventFactory {

    public static Event createEvent(Long eventId, String eventTitle, String eventDescription, Date eventDate, Time eventTime, String eventLocation){
        return new Event.Builder()
                .setEventId(eventId)
                .setEventTitle(eventTitle)
                .setEventDescription(eventDescription)
                .setEventDate(eventDate)
                .setEventTime(eventTime)
                .setEventLocation(eventLocation)
                .build();
    }
}
