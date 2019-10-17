package com.streetsmart.app.activityUI;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.streetsmart.app.R;
import com.streetsmart.app.utils.IntentWrapper;

public class MainUIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentWrapper.startDashboardActivity(this);
        finish();
    }
}

