package com.streetsmart.app.activity.dashboard;

import android.os.Bundle;

import com.streetsmart.app.R;
import com.streetsmart.app.activity.BaseActivity;

import javax.inject.Inject;

public class DashboardActivity extends BaseActivity implements DashboardMVP.View {

    @Inject
    DashboardMVP.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        initBottomNavigation(this, 0);
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
