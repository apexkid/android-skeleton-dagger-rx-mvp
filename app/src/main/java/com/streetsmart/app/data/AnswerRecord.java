package com.streetsmart.app.data;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
public class AnswerRecord {

    @Getter
    private Set<String> answers = new HashSet<>();

    public void addAnswer(String answer) {
        answers.add(answer);
    }

    public void removeAnswer(String answer) {
        if(answers.contains(answer)) {
            answers.remove(answer);
        }
    }

    public boolean contains(String ans) {
        return answers.contains(ans);
    }
}
