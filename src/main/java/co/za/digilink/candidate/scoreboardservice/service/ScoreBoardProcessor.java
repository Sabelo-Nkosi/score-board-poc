package co.za.digilink.candidate.scoreboardservice.service;

import co.za.digilink.candidate.scoreboardservice.entities.Category;
import co.za.digilink.candidate.scoreboardservice.entities.SubCategory;
import co.za.digilink.candidate.scoreboardservice.service.processes.Processor;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ScoreBoardProcessor extends Processor<Integer, Category> {
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
            final Category persistedCat = categoryService.persist(category);
            adjudicateSubcategoryLinks(persistedCat, persistedCat.getSubCategory());
        } else {
            final Category category1 = categoryService.getById(category.getId());
            mapProperties(category1, category);
            final Category persistedCat = categoryService.persist(category1);
            adjudicateSubcategoryLinks(category1, category.getSubCategory());
        }
    }

    private void mapProperties(Category category1, Category category) {
        category1.setName(category.getName());
        category1.setDescription(category.getDescription());
       // adjudicateSubcategoryLinks(category1, category.getSubCategory());
    }

    private void adjudicateSubcategoryLinks(Category category, Set<SubCategory> subCategory) {
        category.setSubCategory(new HashSet<>());
        final Set<SubCategory> toPersist = new HashSet<>();
        subCategory.stream().filter(val -> val.getCategory() == null).collect(Collectors.toSet()).forEach(subCat -> {
            subCat.setCategory(category);
            toPersist.add(subCat);
        });

        subCategoryService.createAll(toPersist);
    }


}
