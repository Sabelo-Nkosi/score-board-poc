package co.za.digilink.candidate.scoreboardservice.service;

import co.za.digilink.candidate.scoreboardservice.entities.Category;
import co.za.digilink.candidate.scoreboardservice.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CategoryService extends GenericService<CategoryRepository, Integer, Category> {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository repository, CategoryRepository categoryRepository) {
        super(repository);
        this.categoryRepository = categoryRepository;
    }

}
