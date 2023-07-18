package co.za.digilink.candidate.scoreboardservice.repository;

import co.za.digilink.candidate.scoreboardservice.entities.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
@CrossOrigin("*")
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
    List<SubCategory> findSubCategoryByCategory_Id(Integer id);
}
