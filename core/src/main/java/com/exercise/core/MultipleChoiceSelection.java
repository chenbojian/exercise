package com.exercise.core;

import javax.persistence.*;

/**
 * Created by chenbojian on 7/20/15.
 */
@Entity
@Table(name = "multiple_choice_selection")
public class MultipleChoiceSelection {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "content")
    private String content;

    @Column(name = "is_answer")
    private boolean answer;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @Column(name = "multiple_choice_id")
    private MultipleChoice multipleChoice;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipleChoice getMultipleChoice() {
        return multipleChoice;
    }

    public void setMultipleChoice(MultipleChoice multipleChoice) {
        this.multipleChoice = multipleChoice;
    }
}
