package com.streetsmart.app.utils;

import com.streetsmart.app.data.AnswerRecord;
import com.streetsmart.app.data.QuestionViewType;
import com.streetsmart.app.data.api.QuestionForUser;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayUtils {

    private static final int SCORE_FACTOR = 20;
    private static final int TIME_FACTOR = 5;

    public int getScore(List<QuestionForUser> questions, List<AnswerRecord> answers, int timeRemainingInSeconds) {
        int numberOfCorrectAnswers = 0;
        for(int i = 0; i < questions.size(); i++) {
            QuestionForUser ques = questions.get(i);
            AnswerRecord ans = answers.get(i);

            if(isCorrectAnswer(ques, ans)) {
                numberOfCorrectAnswers++;
            }
        }

        return (numberOfCorrectAnswers * SCORE_FACTOR) + (timeRemainingInSeconds * TIME_FACTOR);
    }

    private boolean isCorrectAnswer(QuestionForUser ques, AnswerRecord ans) {
        Set<String> correctAnswersForQuestion = new HashSet<>();
        for(QuestionForUser.Options option : ques.getOptionList()) {
            if(option.getIsAcceptedAnswer() == true) {
                correctAnswersForQuestion.add(option.getOptionText());
            }
        }

        if(ans.getAnswers().containsAll(correctAnswersForQuestion)) {
            return true;
        } else {
            return false;
        }
    }

    public static QuestionViewType getQuestionViewType(QuestionForUser question) {
        if(question == null) {
            throw new RuntimeException("Null question passed to getQuestionViewType");
        }

        if(StringUtils.isBlank(question.getQuestionImageUrl())) {
            return decideTextQuestionBasedOnOption(question);
        } else {
            return decideHybridQuestionBasedOnOption(question);
        }
    }

    private static QuestionViewType decideHybridQuestionBasedOnOption(QuestionForUser question) {
        QuestionForUser.Options option = question.getOptionList().get(0);
        if(StringUtils.isBlank(option.getOptionImageUrl())) {
            return QuestionViewType.HT;
        } else {
            return QuestionViewType.HI;
        }
    }

    private static QuestionViewType decideTextQuestionBasedOnOption(QuestionForUser question) {
        QuestionForUser.Options option = question.getOptionList().get(0);
        if(StringUtils.isBlank(option.getOptionImageUrl())) {
            return QuestionViewType.TT;
        } else {
            return QuestionViewType.TI;
        }
    }
}