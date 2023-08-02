package co.za.digilink.candidate.scoreboardservice.repository;

import co.za.digilink.candidate.scoreboardservice.entities.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface ScoreRepository extends JpaRepository<Score, Integer> {
}
