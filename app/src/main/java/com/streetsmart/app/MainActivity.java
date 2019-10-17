package com.streetsmart.app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.streetsmart.app.utils.IntentWrapper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //IntentWrapper.startDashboardActivity(this);
        //IntentWrapper.startRewardsActivity(this);
        IntentWrapper.startPlayActivity(this);
        //IntentWrapper.startLeaderboardActivity(this);

        finish();
    }
}
