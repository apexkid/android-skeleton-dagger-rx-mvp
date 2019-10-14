package com.streetsmart.app.activity.play;

import com.streetsmart.app.data.GameQuestionsRecord;

public interface PlayMVP {

    interface View {
        void updateData(GameQuestionsRecord record);
        void showRefreshLoader(boolean loadingStatus);
        void clearData();
        void showSnackbar(String msg);
    }

    interface Presenter  {
        void attachView(PlayMVP.View view);
        void detachView();
        void subscribeData();
        void unsubscribeData();
    }
}
