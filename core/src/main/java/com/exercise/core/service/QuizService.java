package com.exercise.core.service;

import com.exercise.core.DAO.QuizDAO;
import com.exercise.core.MultipleChoice;
import com.exercise.core.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chenbojian on 7/22/15.
 */
@Service
public class QuizService {
    private QuizDAO quizDAO;

    @Autowired
    public QuizService(QuizDAO quizDAO) {
        this.quizDAO = quizDAO;
    }

    public Quiz findQuizById(long id) {
        return quizDAO.findQuizById(id);
    }

    public List<Quiz> listQuiz() {
        return quizDAO.listQuiz();
    }

    public void save(Quiz quiz) {
        quizDAO.save(quiz);
    }
}
