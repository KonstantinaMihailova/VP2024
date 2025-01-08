package mk.finki.ukim.mk.labzadaca.repository.jpa;

import mk.finki.ukim.mk.labzadaca.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationJpaRepository extends JpaRepository<Location,Long> {
}
