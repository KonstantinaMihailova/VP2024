package mk.finki.ukim.mk.labzadaca.service.impl;

import mk.finki.ukim.mk.labzadaca.model.Location;
import mk.finki.ukim.mk.labzadaca.repository.jpa.LocationJpaRepository;
import mk.finki.ukim.mk.labzadaca.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationJpaRepository locationJpaRepository;

    public LocationServiceImpl(LocationJpaRepository locationJpaRepository) {
        this.locationJpaRepository = locationJpaRepository;
    }

    @Override
    public List<Location> findAll() {
        return this.locationJpaRepository.findAll();
    }
}
