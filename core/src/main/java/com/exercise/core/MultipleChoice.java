package com.exercise.core;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by chenbojian on 7/20/15.
 */

@Entity
@Table(name = "multiple_choice")
public class MultipleChoice {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "content")
    private String content;

    @OneToMany(mappedBy = "multiple_choice")
    private Set<MultipleChoiceSelection> multipleChoiceSelections = new HashSet<MultipleChoiceSelection>();

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<MultipleChoiceSelection> getMultipleChoiceSelections() {
        return multipleChoiceSelections;
    }

    public void setMultipleChoiceSelections(Set<MultipleChoiceSelection> multipleChoiceSelections) {
        this.multipleChoiceSelections = multipleChoiceSelections;
    }
}
