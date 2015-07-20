package com.exercise.web;


import com.exercise.core.MultipleChoice;
import com.exercise.core.MultipleChoiceSelection;
import com.exercise.core.service.MultipleChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by chenbojian on 7/20/15.
 */
@RestController
@RequestMapping("/multiple-choice")
public class MultipleChoiceController {

    private MultipleChoiceService multipleChoiceService;

    @Autowired
    public MultipleChoiceController(MultipleChoiceService multipleChoiceService) {
        this.multipleChoiceService = multipleChoiceService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView showMultipleChoicePage() {
        ModelAndView modelAndView = new ModelAndView("multipleChoice");
        MultipleChoice multipleChoice = multipleChoiceService.getMultipleChoice();
        modelAndView.addObject("multipleChoice", multipleChoice);
        return modelAndView;

    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ModelAndView isSelectionRight(long multipleChoiceId, int selectionId) {
        ModelAndView modelAndView = new ModelAndView("multipleChoice");
        MultipleChoice multipleChoice = multipleChoiceService.findMultipleChoiceById(multipleChoiceId);
        modelAndView.addObject("selectionId", selectionId);
        modelAndView.addObject("multipleChoice", multipleChoice);
        if (multipleChoice.getSelectionById(selectionId).isAnswer()) {
            modelAndView.addObject("message", "You are right!");
        } else {
            modelAndView.addObject("message", "You are wrong!");
        }
        return modelAndView;
    }

}

