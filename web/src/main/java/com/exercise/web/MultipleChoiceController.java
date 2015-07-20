package com.exercise.web;


import com.exercise.core.MultipleChoice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by chenbojian on 7/20/15.
 */
@RestController
@RequestMapping("/multiple-choice")
public class MultipleChoiceController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView showMultipleChoicePage() {
        ModelAndView modelAndView = new ModelAndView("multipleChoice");
        MultipleChoice multipleChoice = new MultipleChoice();
        modelAndView.addObject("multipleChoice", multipleChoice);
        return modelAndView;

    }
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public String isSelectionRight(UserSelection userSelection){
        return "ok";
    }

    private class UserSelection {

    }
}
