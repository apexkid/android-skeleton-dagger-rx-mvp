package com.streetsmart.app.utils;

import com.streetsmart.app.data.api.QuestionForUser;

import org.apache.commons.lang3.StringUtils;

public class QuestionViewTypeDecider {

    public static QuestionViewType getQuestionViewType(QuestionForUser question) {
        if(question == null) {
            throw new RuntimeException("Null question passed to getQuestionViewType");
        }

        if(StringUtils.isBlank(question.getQuestionImageUrl())) {
            return decideTextQuestionBasedOnOption(question);
        } else {
            return decideHybridQuestionbasedOnOption(question);
        }
    }

    private static QuestionViewType decideHybridQuestionbasedOnOption(QuestionForUser question) {
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

    public enum QuestionViewType {
        TT,
        TI,
        HT,
        HI
    }
}
