package mk.finki.ukim.mk.labzadaca.service.impl;

import mk.finki.ukim.mk.labzadaca.model.Event;
import mk.finki.ukim.mk.labzadaca.model.Location;
import mk.finki.ukim.mk.labzadaca.repository.jpa.EventJpaRepository;
import mk.finki.ukim.mk.labzadaca.repository.jpa.LocationJpaRepository;
import mk.finki.ukim.mk.labzadaca.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    private final EventJpaRepository eventRepository;
    private final LocationJpaRepository locationJpaRepository;

    public EventServiceImpl(EventJpaRepository eventRepository, LocationJpaRepository locationJpaRepository) {
        this.eventRepository = eventRepository;
        this.locationJpaRepository = locationJpaRepository;
    }

    @Override
    public List<Event> listAll() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> searchEvents(String text,Double rating) {
        return eventRepository.searchEventByNameContainsIgnoreCaseAndPopularityScoreGreaterThanEqual(text,rating);
    }

    @Override
    public List<Event> searchEventsByLocation(Location location) {
        return eventRepository.searchEventByLocation(location);
    }

    @Override
    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public Optional<Event> save(String name, String description, Double popularityScore, Long locationId) {
        Location  location=locationJpaRepository.findById(locationId).orElse(null);
        if(location!=null){
            Event event=new Event(name,description,popularityScore,location);
            return Optional.of(eventRepository.save(event));
        }

        return Optional.empty();
    }

    @Override
    public Optional<Event> update(Long id, String name, String description, Double popularityScore,Long locationId) {

        Optional<Event> old=eventRepository.findById(id);
        Location location = locationJpaRepository.findById(locationId).orElse(null);

        if(old.isPresent()){
            eventRepository.deleteById(id);
           return Optional.of(eventRepository.save(new Event(name,description,popularityScore,location)));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    public void increaseRating(Long id) {
        Event event=eventRepository.findById(id).orElse(null);
        if(event!=null){
            event.setPopularityScore(event.getPopularityScore()+1);
            eventRepository.save(event);
        }
    }

    @Override
    public void decreaseRating(Long id) {
        Event event=eventRepository.findById(id).orElse(null);
        if(event!=null){
            event.setPopularityScore(event.getPopularityScore()-1);
            eventRepository.save(event);
        }
    }

}
