package com.streetsmart.app.activity.play;

import com.streetsmart.app.data.api.QuestionForUser;

public interface PlayMVP {

    interface View {
        void showRefreshLoader(boolean loadingStatus);
        void clearData();
        void showPrepareGameState(boolean status);
        void updateQuestionData(QuestionForUser record);
        void launchGame();
    }

    interface Presenter  {
        void attachView(PlayMVP.View view);
        void detachView();
        void subscribeData();
        void unsubscribeData();
        void onStartGame();
    }
}
