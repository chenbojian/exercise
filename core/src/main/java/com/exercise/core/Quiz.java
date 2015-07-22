package com.exercise.core;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenbojian on 7/22/15.
 */
@Entity
public class Quiz {
    @OneToMany
    private List<MultipleChoice> multipleChoices= new ArrayList<MultipleChoice>();
    private String name;

    public List<MultipleChoice> getMultipleChoices() {
        return multipleChoices;
    }

    public void setMultipleChoices(List<MultipleChoice> multipleChoices) {
        this.multipleChoices = multipleChoices;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
