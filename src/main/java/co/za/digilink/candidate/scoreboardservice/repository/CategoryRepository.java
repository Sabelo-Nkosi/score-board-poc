package co.za.digilink.candidate.scoreboardservice.repository;

import co.za.digilink.candidate.scoreboardservice.entities.Category;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.math.BigDecimal;

@Repository
@CrossOrigin("*")
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
