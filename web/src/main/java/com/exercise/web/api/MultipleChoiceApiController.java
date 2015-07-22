package com.exercise.web.api;

import com.exercise.core.MultipleChoice;
import com.exercise.core.MultipleChoiceSelection;
import com.exercise.core.service.MultipleChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("/list")
    @ResponseBody
    public List<MultipleChoice> listOfMultipleChoice() {
        return multipleChoiceService.listMultipleChoice();
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public void addMultipleChoice(@RequestBody MultipleChoice multipleChoice){
        System.out.println(multipleChoice.getContent()+"----------------");
        System.out.println(multipleChoice.getMultipleChoiceSelections()+"----------------");
        System.out.println(multipleChoice.getMultipleChoiceSelections().size()+"----------------");
        for (MultipleChoiceSelection multipleChoiceSelection : multipleChoice.getMultipleChoiceSelections()) {
            System.out.println(multipleChoiceSelection.getContent()+"----------------");
            System.out.println(multipleChoiceSelection.isAnswer()+"----------------");
        }
    }
}
