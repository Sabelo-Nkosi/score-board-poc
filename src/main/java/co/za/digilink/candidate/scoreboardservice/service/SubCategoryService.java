package co.za.digilink.candidate.scoreboardservice.service;

import co.za.digilink.candidate.scoreboardservice.entities.SubCategory;
import co.za.digilink.candidate.scoreboardservice.repository.SubCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryService extends GenericService<SubCategoryRepository, Integer, SubCategory> {

    final SubCategoryRepository subCategoryRepository;
    public SubCategoryService(SubCategoryRepository subCategoryRepository) {
        super(subCategoryRepository);
        this.subCategoryRepository = subCategoryRepository;
    }

    public List<SubCategory> getByCategory(Integer categoryID) {
        return subCategoryRepository.findSubCategoryByCategory_Id(categoryID);
    }
}
