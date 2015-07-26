package com.exercise.core.DAO;

import com.exercise.core.Quiz;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by chenbojian on 7/22/15.
 */
@Repository
@Transactional
public class QuizDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public QuizDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Quiz findQuizById(long id) {
        return (Quiz) sessionFactory.getCurrentSession().get(Quiz.class, id);
    }

    public List<Quiz> listQuiz() {
        return sessionFactory.getCurrentSession().createQuery("from Quiz")
                .list();
    }

    public void save(Quiz quiz) {
        sessionFactory.getCurrentSession().save(quiz);
    }
}
