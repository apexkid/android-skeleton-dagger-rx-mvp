package com.streetsmart.app.activity.leaderboard;

import android.os.Bundle;

import com.streetsmart.app.R;
import com.streetsmart.app.activity.BaseActivity;

public class LeaderboardActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        initBottomNavigation(this, 2);
    }
}
