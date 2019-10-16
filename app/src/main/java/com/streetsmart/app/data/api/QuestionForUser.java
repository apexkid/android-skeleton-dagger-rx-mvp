package com.streetsmart.app.data.api;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuestionForUser {

    private String questionText;
    private String questionId;
    private String questionTag;
    private String questionImageUrl;
    private List<Options> optionList;


    @NoArgsConstructor
    @Data
    public static class Options {
        private String optionId;
        private String optionText;
        private String optionImageUrl;
        private Boolean isAcceptedAnswer;
        private int pointsForThisOption;
    }
}
