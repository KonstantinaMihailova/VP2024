package mk.finki.ukim.mk.labzadaca.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String capacity;
    private String description;
    private String name;
    @OneToMany
    private List<Event> events;

    public Location(String address, String capacity, String description, String name) {
        this.address = address;
        this.capacity = capacity;
        this.description = description;
        this.name = name;
    }

    public Location() {

    }

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getCapacity() {
        return capacity;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public List<Event> getEvents() {
        return events;
    }
}
