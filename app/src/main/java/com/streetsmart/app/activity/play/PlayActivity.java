package com.streetsmart.app.activity.play;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.streetsmart.app.R;

import javax.inject.Inject;

public class PlayActivity extends AppCompatActivity implements PlayMVP.View {

    @Inject
    PlayMVP.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
    }

    @Override
    public void updateData() {

    }

    @Override
    public void showRefreshLoader(boolean loadingStatus) {

    }

    @Override
    public void clearData() {

    }

    @Override
    public void showSnackbar(String msg) {

    }
}
