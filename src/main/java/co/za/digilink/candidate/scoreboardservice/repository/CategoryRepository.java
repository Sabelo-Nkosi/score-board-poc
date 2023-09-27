package co.za.digilink.candidate.scoreboardservice.repository;

import co.za.digilink.candidate.scoreboardservice.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin("*")
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
