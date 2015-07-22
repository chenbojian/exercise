package com.exercise.web.api;

import com.exercise.core.MultipleChoice;
import com.exercise.core.service.MultipleChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by chenbojian on 7/22/15.
 */
@RestController
@RequestMapping("/api/quiz")
public class QuizApiController {
    private MultipleChoiceService multipleChoiceService;

    @Autowired
    public QuizApiController(MultipleChoiceService multipleChoiceService) {
        this.multipleChoiceService = multipleChoiceService;
    }

    @RequestMapping(value = "/list-multiple-choice", method = RequestMethod.GET)
    @ResponseBody
    public List<MultipleChoice> listMultipleChoice(){
        return multipleChoiceService.listMultipleChoice();
    }
}
