package co.za.digilink.candidate.scoreboardservice.service;

import co.za.digilink.candidate.scoreboardservice.entities.Category;
import co.za.digilink.candidate.scoreboardservice.entities.SubCategory;
import co.za.digilink.candidate.scoreboardservice.service.processes.Processor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedHashSet;
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
        //  loadSubCategories(categoryID, category);
    }

    @Override
    public void process(Category category) {
    }

//    private void loadSubCategories(Integer categoryID, Category category) {
//        final Set<SubCategory> subCategories = subCategoryService.getByCategory(categoryID).stream().sorted(new Comparator<SubCategory>() {
//            @Override
//            public int compare(SubCategory o1, SubCategory o2) {
//                return (int) (o1.getId() - o2.getId());
//            }
//        }).collect(Collectors.toCollection(LinkedHashSet::new));
//        category.setSubCategory(subCategories);
//    }

    @SneakyThrows
    public List<Category> getFullCategories() {
        return this.categoryService.getAll().stream().map(val -> {
            val.setSubCategory(val.getSubCategory().stream().sorted(new Comparator<SubCategory>() {
                @Override
                public int compare(SubCategory o1, SubCategory o2) {
                    return (int) (o1.getId() - o2.getId());
                }
            }).collect(Collectors.toCollection(LinkedHashSet::new)));
            return val;
        }).collect(Collectors.toList());
    }


}
