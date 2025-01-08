package mk.finki.ukim.mk.labzadaca.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private String name;
    private String description;
    @Getter
    private double popularityScore;
    @ManyToOne
    private Location location;

    public Event(String name, String description, double popularityScore,Location location) {
        this.name = name;
        this.description = description;
        this.popularityScore = popularityScore;
        this.location=location;
    }

    public Event(String name, String description, Double popularityScore, Optional<Location> location) {
    }

    public Location getLocation() {
        return location;
    }

    public Event(){}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPopularityScore() {
        return popularityScore;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPopularityScore(double popularityScore) {
        this.popularityScore = popularityScore;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
