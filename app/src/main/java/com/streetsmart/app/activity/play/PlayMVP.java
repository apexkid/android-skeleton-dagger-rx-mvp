package com.streetsmart.app.activity.play;

import com.streetsmart.app.data.AnswerRecord;
import com.streetsmart.app.data.api.QuestionForUser;

import java.util.List;

public interface PlayMVP {

    interface View {
        void clearData();
        void showPrepareGameState(boolean status);
        void updateQuestionData(QuestionForUser record);
        void launchGame();
        void showRefreshLoaderOnEndGame(boolean b);
    }

    interface Presenter  {
        void attachView(PlayMVP.View view);
        void detachView();
        void unsubscribeData();
        void onStartGame();
        void submitScore(List<QuestionForUser> questionList, List<AnswerRecord> answerList, String userId, int scoreForGameSessions);
    }
}
