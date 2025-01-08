package mk.finki.ukim.mk.labzadaca.service;

import mk.finki.ukim.mk.labzadaca.model.Event;
import mk.finki.ukim.mk.labzadaca.model.EventBooking;

public interface EventBookingService{
    EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, int numberOfTickets);

//    boolean canBook(Long eventId, int numTickets);
}
