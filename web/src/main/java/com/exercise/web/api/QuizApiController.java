package com.exercise.web.api;

import com.exercise.core.MultipleChoice;
import com.exercise.core.Quiz;
import com.exercise.core.service.MultipleChoiceService;
import com.exercise.core.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by chenbojian on 7/22/15.
 */
@RestController
@RequestMapping("/api/quiz")
public class QuizApiController {
    private MultipleChoiceService multipleChoiceService;
    private QuizService quizService;

    @Autowired
    public QuizApiController(MultipleChoiceService multipleChoiceService, QuizService quizService) {
        this.multipleChoiceService = multipleChoiceService;
        this.quizService = quizService;
    }

    @RequestMapping(value = "/list-multiple-choice", method = RequestMethod.GET)
    @ResponseBody
    public List<MultipleChoice> listMultipleChoice(){
        return multipleChoiceService.listMultipleChoice();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Quiz getQuiz(@PathVariable("id") long id){
        return quizService.findQuizById(id);
    }
}
