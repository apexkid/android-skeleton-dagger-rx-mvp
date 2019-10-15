package com.streetsmart.app.activity.rewards;

import android.os.Bundle;

import com.streetsmart.app.R;
import com.streetsmart.app.activity.BaseActivity;

public class RewardsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewards);

        initBottomNavigation(this, 1);
    }
}
