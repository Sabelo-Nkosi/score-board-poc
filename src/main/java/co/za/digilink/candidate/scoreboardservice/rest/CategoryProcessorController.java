package co.za.digilink.candidate.scoreboardservice.rest;


import co.za.digilink.candidate.scoreboardservice.entities.Category;
import co.za.digilink.candidate.scoreboardservice.service.ScoreBoardProcessor;
import co.za.digilink.candidate.scoreboardservice.service.ScoreBoardRetriever;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Category> bulkProcessor(@RequestBody Category[] categories) {
        for (Category category : categories) {
            Integer categoryID = null;
            scoreBoardProcessor.process(category);
        }
        return List.of(categories);
    }

    @GetMapping("/fetch")
    public List<Category> retreive() {
        return this.scoreBoardRetriever.getFullCategories();
    }


}
