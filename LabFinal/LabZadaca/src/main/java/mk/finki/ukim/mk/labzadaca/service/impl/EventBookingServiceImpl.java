package mk.finki.ukim.mk.labzadaca.service.impl;

import mk.finki.ukim.mk.labzadaca.model.Event;
import mk.finki.ukim.mk.labzadaca.model.EventBooking;
import mk.finki.ukim.mk.labzadaca.model.Location;
import mk.finki.ukim.mk.labzadaca.repository.jpa.EventJpaRepository;
import mk.finki.ukim.mk.labzadaca.repository.jpa.LocationJpaRepository;
import mk.finki.ukim.mk.labzadaca.service.EventBookingService;
import org.springframework.stereotype.Service;

@Service
public class EventBookingServiceImpl implements EventBookingService {

    private final LocationJpaRepository locationJpaRepository;
    private final EventJpaRepository eventJpaRepository;

    public EventBookingServiceImpl(LocationJpaRepository locationJpaRepository, EventJpaRepository eventJpaRepository) {
        this.locationJpaRepository = locationJpaRepository;
        this.eventJpaRepository = eventJpaRepository;
    }

    @Override
    public EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, int numberOfTickets) {
        return null;
    }

//    @Override
//    public boolean canBook(Long eventId, int numTickets) {
//        Event event=eventJpaRepository.findById(eventId).orElse(null);
//        if(event != null){
//            Location locationEvent=event.getLocation();
//            Long capacity=Long.parseLong(locationEvent.getCapacity());
//
//            return capacity - numTickets >= 0;
//        }
//        return false;
//    }


}
