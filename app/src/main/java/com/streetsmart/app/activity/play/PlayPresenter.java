package com.streetsmart.app.activity.play;

import android.util.Log;

public class PlayPresenter implements PlayMVP.Presenter {

    private final static String TAG = PlayPresenter.class.getName();

    private PlayMVP.View view;

    @Override
    public void attachView(PlayMVP.View view) {
        this.view = view;
        Log.v(TAG, "Attach view done. View=" + view);
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void subscribeData() {
        view.updateData(null);
    }

    @Override
    public void unsubscribeData() {

    }
}
