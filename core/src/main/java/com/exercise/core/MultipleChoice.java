package com.exercise.core;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.*;

/**
 * Created by chenbojian on 7/20/15.
 */

@Entity
@Table(name = "multiple_choice")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class MultipleChoice {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "content")
    private String content;

    @OneToMany(mappedBy = "multipleChoice", fetch = FetchType.EAGER)
    private List<MultipleChoiceSelection> multipleChoiceSelections = new ArrayList<MultipleChoiceSelection>();

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

    public MultipleChoiceSelection getSelectionById(long selectionId) {
        for (MultipleChoiceSelection multipleChoiceSelection : multipleChoiceSelections) {
            if (multipleChoiceSelection.getId() == selectionId) {
                return multipleChoiceSelection;
            }
        }
        return null;
    }

    public void setMultipleChoiceSelections(List<MultipleChoiceSelection> multipleChoiceSelections) {
        this.multipleChoiceSelections = multipleChoiceSelections;
    }

    public List<MultipleChoiceSelection> getMultipleChoiceSelections() {
        return multipleChoiceSelections;
    }
}
