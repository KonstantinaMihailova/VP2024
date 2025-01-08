package mk.finki.ukim.mk.labzadaca.repository.jpa;


import mk.finki.ukim.mk.labzadaca.model.Event;
import mk.finki.ukim.mk.labzadaca.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventJpaRepository extends JpaRepository<Event,Long> {
    List<Event> searchEventByNameContainsIgnoreCaseAndPopularityScoreGreaterThanEqual(String text,Double rating);
    List<Event> searchEventByLocation(Location location);




}
