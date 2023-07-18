package co.za.digilink.candidate.scoreboardservice.rest;


import co.za.digilink.candidate.scoreboardservice.entities.Category;
import co.za.digilink.candidate.scoreboardservice.service.ScoreBoardProcessor;
import co.za.digilink.candidate.scoreboardservice.service.ScoreBoardRetriever;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/processor")
public class CategoryProcessorController {
    public final ScoreBoardProcessor scoreBoardProcessor;
    public final ScoreBoardRetriever scoreBoardRetriever;

    public CategoryProcessorController(ScoreBoardProcessor scoreBoardProcessor,
                                       ScoreBoardRetriever scoreBoardRetriever) {
        this.scoreBoardProcessor = scoreBoardProcessor;
        this.scoreBoardRetriever = scoreBoardRetriever;
    }

    @PostMapping
    public Category process(@RequestBody Category category) {
        Integer categoryID = null;
        scoreBoardProcessor.process(categoryID, category);
        return category;
    }

    @GetMapping("/fetch")
    public List<Category> process() {
        return this.scoreBoardRetriever.getFullCategories();
    }

}
