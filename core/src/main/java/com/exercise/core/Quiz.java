package com.exercise.core;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenbojian on 7/22/15.
 */
@Entity
@Table(name = "quiz")
public class Quiz {
    @Id
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany
    @JoinTable(
            name = "multiple_choice_of_quiz",
            joinColumns = @JoinColumn(name = "quiz_id"),
            inverseJoinColumns = @JoinColumn(name = "multiple_choice_id")
    )
    private List<MultipleChoice> multipleChoices = new ArrayList<MultipleChoice>();

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
