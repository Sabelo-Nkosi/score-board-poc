package co.za.digilink.candidate.scoreboardservice.service;

import co.za.digilink.candidate.scoreboardservice.entities.Category;
import co.za.digilink.candidate.scoreboardservice.entities.SubCategory;
import co.za.digilink.candidate.scoreboardservice.service.processes.Processor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScoreBoardRetriever extends Processor<Integer, Category> {

    private final CategoryService categoryService;
    private final SubCategoryService subCategoryService;

    public ScoreBoardRetriever(CategoryService categoryService, SubCategoryService subCategoryService) {
        this.categoryService = categoryService;
        this.subCategoryService = subCategoryService;
    }


    @Override
    public void process(Integer categoryID, Category category) {
        if (categoryID != null) {
            throw new IllegalArgumentException("Set id for retrieval");
        }
        loadSubCategories(categoryID, category);
    }

    private void loadSubCategories(Integer categoryID, Category category) {
        List<SubCategory> subCategories = subCategoryService.getByCategory(categoryID);
        category.setSubCategory(new HashSet<>(subCategories));
    }

    @SneakyThrows
    public List<Category> getFullCategories() {
        return this.categoryService.getAll();
    }
}
