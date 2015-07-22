package com.exercise.core.DAO;

import com.exercise.core.Quiz;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by chenbojian on 7/22/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration
@Transactional
public class QuizDAOTest {

    @Autowired
    private QuizDAO quizDAO;

    @Test
    public void should_get_name_of_quiz() {
        Quiz quiz = quizDAO.findQuizById(1);
        assertThat(quiz.getName(),is("abc"));
    }

    @Test
    public void should_get_correct_multiple_choice() {
        Quiz quiz = quizDAO.findQuizById(1);
        assertThat(quiz.getMultipleChoices().size(), is(3));

    }

}