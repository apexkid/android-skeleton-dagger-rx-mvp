package com.streetsmart.app.utils;

import com.streetsmart.app.data.AnswerRecord;
import com.streetsmart.app.data.api.GameResultPOSTBody;
import com.streetsmart.app.data.api.QuestionForUser;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class GameResultPOSTBodyXmer {
    public static GameResultPOSTBody createGameResultPostBody(List<QuestionForUser> questionList,
                                                              List<AnswerRecord> answerList, String userId,
                                                              int scoreForGameSessions) {

        final GameResultPOSTBody output = new GameResultPOSTBody();
        output.setUserid(userId);
        output.setGameid("XXX-YY-11-22");
        output.setTotalpointsforgame(String.valueOf(scoreForGameSessions));
        output.setStarttime(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        output.setEndtime(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        output.setAnswerslist(buildAnswerList(questionList, answerList));

        return output;
    }

    private static List<GameResultPOSTBody.AnswerResult> buildAnswerList(List<QuestionForUser> questionList,
                                                                         List<AnswerRecord> answerList) {
        final List<GameResultPOSTBody.AnswerResult> output = new ArrayList<>();

        for(int i = 0; i < questionList.size(); i++) {
            final List<GameResultPOSTBody.AnswerResult> result;

            if(i < answerList.size()) {
                result = inflateAnswers(questionList.get(i), answerList.get(i));
            } else {
                result = inflateAnswers(questionList.get(i), null);
            }

            if(result != null) {
                output.addAll(result);
            }
        }

        return output;
    }

    private static List<GameResultPOSTBody.AnswerResult> inflateAnswers(QuestionForUser questionForUser,
                                                                        AnswerRecord answerRecord) {
        List<GameResultPOSTBody.AnswerResult> output = new ArrayList<>();
        String correctAnsIds = getCorrectAnswerIdsForQuestion(questionForUser);
        for(QuestionForUser.Options option: questionForUser.getOptionList()) {
            GameResultPOSTBody.AnswerResult ans = transformOptionToAnswer(option, correctAnsIds, questionForUser);

            if(answerRecord != null) {
                // TODO write logic for selected ans.
            }

            output.add(ans);
        }
        return output;
    }

    private static String getCorrectAnswerIdsForQuestion(QuestionForUser questionForUser) {
        StringBuilder str = new StringBuilder();
        for(QuestionForUser.Options option : questionForUser.getOptionList()) {
            if(option.getIsAcceptedAnswer() == true) {
                str.append(option.getOptionId() + ",");
            }
        }
        return str.toString();
    }

    private static GameResultPOSTBody.AnswerResult transformOptionToAnswer(QuestionForUser.Options option,
                                                                           String correctAnsIds, QuestionForUser questionForUser) {
        GameResultPOSTBody.AnswerResult output = new GameResultPOSTBody.AnswerResult();
        output.setCorrect_answer(correctAnsIds);
        output.setOption_image_url(option.getOptionImageUrl());
        output.setOption_text(option.getOptionText());
        output.setPoint_scored(String.valueOf(option.getPointsForThisOption()));
        output.setQuestion_option_id(option.getOptionId());
        output.setQuestion_tag(questionForUser.getQuestionTag());
        output.setQuestion_image_url(questionForUser.getQuestionImageUrl());
        output.setQuestion_type(questionForUser.getQuestionType());

        return output;
    }
}
