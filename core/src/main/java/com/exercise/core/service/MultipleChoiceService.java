package com.exercise.core.service;

import com.exercise.core.DAO.MultipleChoiceDAO;
import com.exercise.core.MultipleChoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chenbojian on 7/20/15.
 */
@Service
public class MultipleChoiceService {


    private MultipleChoiceDAO multipleChoiceDAO;
    private int count = 0;

    @Autowired
    public MultipleChoiceService(MultipleChoiceDAO multipleChoiceDAO) {
        this.multipleChoiceDAO = multipleChoiceDAO;
    }

    public MultipleChoice getMultipleChoice() {
        List<MultipleChoice> multipleChoices = multipleChoiceDAO.listMultipleChoice();
        if (count >= multipleChoices.size()) {
            count = 0;
        }
        MultipleChoice multipleChoice = multipleChoices.get(count);
        count++;
        return multipleChoice;
    }

    public MultipleChoice findMultipleChoiceById(long id) {
        return multipleChoiceDAO.findMultipleChoiceById(id);
    }

    public List<MultipleChoice> listMultipleChoice() {
        return multipleChoiceDAO.listMultipleChoice();
    }
}
