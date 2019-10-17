package com.streetsmart.app.activity.dashboard;

import android.os.Bundle;
import android.widget.Button;

import com.streetsmart.app.R;
import com.streetsmart.app.activity.BaseActivity;
import com.streetsmart.app.utils.IntentWrapper;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardActivity extends BaseActivity implements DashboardMVP.View {

    @Inject
    DashboardMVP.Presenter presenter;

    @BindView(R.id.button_play_now)
    Button playNowButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        ButterKnife.bind(this);

        initBottomNavigation(this, 0);

        playNowButton.setOnClickListener(v -> IntentWrapper.startPlayActivity(this));
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
