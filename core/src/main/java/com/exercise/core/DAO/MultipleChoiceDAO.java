package com.exercise.core.DAO;

import com.exercise.core.MultipleChoice;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by chenbojian on 7/20/15.
 */
@Repository
@Transactional
public class MultipleChoiceDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public MultipleChoiceDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public MultipleChoice findMultipleChoiceById(long id) {
        return (MultipleChoice) sessionFactory.getCurrentSession()
                .get(MultipleChoice.class, id);
    }

    public List<MultipleChoice> listMultipleChoice() {
        return sessionFactory.getCurrentSession()
                .createQuery("from MultipleChoice")
                .list();
    }
}
