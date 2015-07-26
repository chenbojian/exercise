package com.exercise.core.DAO;

import com.exercise.core.Quiz;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;

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
    @Autowired
    private MultipleChoiceDAO multipleChoiceDAO;
    @Autowired
    private SessionFactory sessionFactory;

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

    @Test
    public void should_insert_quiz_correctly() {
        Quiz quiz = new Quiz();
        quiz.setName("abc");
        quiz.getMultipleChoices().add(multipleChoiceDAO.findMultipleChoiceById(1));
        quiz.getMultipleChoices().add(multipleChoiceDAO.findMultipleChoiceById(2));
        quiz.getMultipleChoices().add(multipleChoiceDAO.findMultipleChoiceById(3));
        quizDAO.save(quiz);
        sessionFactory.getCurrentSession().flush();


    }

}