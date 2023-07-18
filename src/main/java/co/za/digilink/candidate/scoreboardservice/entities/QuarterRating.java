package co.za.digilink.candidate.scoreboardservice.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(schema = "SCORE_BOARD")
public class QuarterRating implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
