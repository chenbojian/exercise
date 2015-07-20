package com.exercise.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by chenbojian on 7/20/15.
 */
@RestController
public class MultipleChoice {
    @RequestMapping("/")
    public ModelAndView showIndexPage() {
        return new ModelAndView("index");

    }
}
