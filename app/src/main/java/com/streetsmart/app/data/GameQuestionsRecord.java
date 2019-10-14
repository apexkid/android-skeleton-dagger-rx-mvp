package com.streetsmart.app.data;

import java.util.List;

public class GameQuestionsRecord {

    private String id;
    private List<Question> questions;

    public static class Question {
        private String content;
        private String contentImage;
        private List<String> answers;
        private String answerType;
        private List<String> correctAnswers;
    }
}
