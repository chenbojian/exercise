package com.exercise.core;

import com.exercise.core.jsonView.Views;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by chenbojian on 7/22/15.
 */
@Entity
@Table(name = "quiz")
public class Quiz {
    @Id
    @GeneratedValue
    @JsonView(Views.QuizInfo.class)
    private long id;

    @Column(name = "name")
    @JsonView(Views.QuizInfo.class)
    private String name;

    @OneToMany
    @JoinTable(
            name = "multiple_choice_of_quiz",
            joinColumns = @JoinColumn(name = "quiz_id"),
            inverseJoinColumns = @JoinColumn(name = "multiple_choice_id")
    )
    @JsonView
    private Set<MultipleChoice> multipleChoices = new HashSet<MultipleChoice>();


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

    public Set<MultipleChoice> getMultipleChoices() {
        return multipleChoices;
    }

    public void setMultipleChoices(Set<MultipleChoice> multipleChoices) {
        this.multipleChoices = multipleChoices;
    }
}
