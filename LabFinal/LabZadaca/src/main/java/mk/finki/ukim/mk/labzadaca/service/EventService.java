package mk.finki.ukim.mk.labzadaca.service;

import mk.finki.ukim.mk.labzadaca.model.Event;
import mk.finki.ukim.mk.labzadaca.model.Location;

import java.util.List;
import java.util.Optional;

public interface EventService {
    List<Event> listAll();
    List<Event> searchEvents(String text,Double rating);
    List<Event> searchEventsByLocation(Location location);
    void deleteById(Long id);
    Optional<Event> save(String name, String description, Double popularityScore, Long locationId);
    Optional<Event> update(Long id, String name,String description, Double popularityScore,Long locationId);
    Optional<Event> findById(Long id);
    void increaseRating(Long id);
    void decreaseRating(Long id);


}
