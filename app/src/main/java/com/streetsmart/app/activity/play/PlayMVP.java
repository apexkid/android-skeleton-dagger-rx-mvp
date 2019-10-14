package com.streetsmart.app.activity.play;

public interface PlayMVP {

    interface View {
        void updateData();
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
