package co.za.digilink.candidate.scoreboardservice.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(schema = "SCORE_BOARD")
public class Quarter implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Quarter quarter)) return false;

        if (!getId().equals(quarter.getId())) return false;
        if (!getName().equals(quarter.getName())) return false;
        return getDescription() != null ? getDescription().equals(quarter.getDescription()) : quarter.getDescription() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        return result;
    }
}
