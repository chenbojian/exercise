package com.exercise.core.DAO;

import com.exercise.core.Quiz;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by chenbojian on 7/22/15.
 */
@Repository
@Transactional
public class QuizDAO {
    public Quiz findQuizById(long id) {
        return null;
    }
}
