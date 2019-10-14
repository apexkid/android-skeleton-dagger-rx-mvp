package com.streetsmart.app.activity.dashboard;

public class DashboardMVP {

    interface View {
        void updateData();
        void showRefreshLoader(boolean loadingStatus);
        void clearData();
        void showSnackbar(String msg);
    }

    interface Presenter  {
        void attachView(DashboardMVP.View view);
        void detachView();
        void subscribeData();
        void unsubscribeData();
    }

}
