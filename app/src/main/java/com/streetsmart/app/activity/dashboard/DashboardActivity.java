package com.streetsmart.app.activity.dashboard;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.streetsmart.app.R;

import javax.inject.Inject;

public class DashboardActivity extends AppCompatActivity implements DashboardMVP.View {

    @Inject
    DashboardMVP.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
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
