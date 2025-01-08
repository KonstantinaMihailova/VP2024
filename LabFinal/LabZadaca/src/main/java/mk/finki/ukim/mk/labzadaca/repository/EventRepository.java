package mk.finki.ukim.mk.labzadaca.repository;

import mk.finki.ukim.mk.labzadaca.bootstrap.DataHolder;
import mk.finki.ukim.mk.labzadaca.model.Event;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EventRepository {

    public List<Event> findAll(){
        return DataHolder.events;
    }

    public List<Event> searchEvents(String text, Double rating){

        return DataHolder.events.stream().filter(r->r.getName().contains(text)).filter(r->r.getPopularityScore()>=rating).collect(Collectors.toList());
    }




}
