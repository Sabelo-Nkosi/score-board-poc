package co.za.digilink.candidate.scoreboardservice.service;

import co.za.digilink.candidate.scoreboardservice.entities.Category;
import co.za.digilink.candidate.scoreboardservice.entities.SubCategory;
import co.za.digilink.candidate.scoreboardservice.service.processes.Processor;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
public class ScoreBoardProcessor extends Processor<Integer ,Category> {
    private final CategoryService categoryService;
    private final SubCategoryService subCategoryService;

    public ScoreBoardProcessor(CategoryService categoryService,
                               SubCategoryService subCategoryService) {
        this.categoryService = categoryService;
        this.subCategoryService = subCategoryService;
    }

    @Override
    public void process(Integer categoryID, Category category) {
    }

    @Override
    @Transactional
    public void process(Category category) {
        if (Objects.isNull(category.getId())) {
            //TODO:  check if it persists cat ID on subcategory
            //adjudicateSubcategoryLinks( category.getSubCategory());

            final Category persistedCat = categoryService.persist(category);
            adjudicateSubcategoryLinks(persistedCat, persistedCat.getSubCategory());
        } else {
            final Category category1 = categoryService.getById(category.getId());
        }
    }

    private void adjudicateSubcategoryLinks(Category category,  Set<SubCategory> subCategory) {
        category.setSubCategory(new HashSet<>());
        subCategory.forEach( subCat -> {
        subCat.setCategory(new Category());
            subCat.setCategory(category);
        });
        subCategoryService.createAll(subCategory);
    }


}
