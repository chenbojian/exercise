package com.exercise.web.api;

import com.exercise.core.MultipleChoice;
import com.exercise.core.service.MultipleChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by chenbojian on 7/20/15.
 */
@RestController
@RequestMapping("/api")
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
}
