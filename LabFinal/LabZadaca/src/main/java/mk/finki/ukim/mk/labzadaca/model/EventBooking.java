package mk.finki.ukim.mk.labzadaca.model;


import lombok.Data;

@Data
public class EventBooking {
    String eventName;
    String attendeeName;
    String attendeeAddress;
    Long numberOfTickets;


}
