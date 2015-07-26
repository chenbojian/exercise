package com.exercise.web.api;

import com.exercise.core.MultipleChoice;
import com.exercise.core.MultipleChoiceSelection;
import com.exercise.core.service.MultipleChoiceService;
import com.exercise.core.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by chenbojian on 7/20/15.
 */
@RestController
@RequestMapping("/api/multiple-choice")
public class MultipleChoiceApiController {

    private MultipleChoiceService multipleChoiceService;

    @Autowired
    public MultipleChoiceApiController(MultipleChoiceService multipleChoiceService) {
        this.multipleChoiceService = multipleChoiceService;
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public List<MultipleChoice> listOfMultipleChoice() {
        return multipleChoiceService.listMultipleChoice();
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public void addMultipleChoice(@RequestBody MultipleChoice multipleChoice) {
        for (MultipleChoiceSelection multipleChoiceSelection : multipleChoice.getMultipleChoiceSelections()) {
            if (multipleChoiceSelection.getMultipleChoice() == null) {
                multipleChoiceSelection.setMultipleChoice(multipleChoice);
                System.out.println("-----------");
            }
        }
        multipleChoiceService.save(multipleChoice);
    }
}
