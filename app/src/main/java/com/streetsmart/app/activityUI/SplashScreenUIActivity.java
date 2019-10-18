package com.streetsmart.app.activityUI;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.streetsmart.app.R;
import com.streetsmart.app.utils.IntentWrapper;

public class SplashScreenUIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_ui);

        Animation a = AnimationUtils.loadAnimation(this, R.anim.zoom_animation);
        a.reset();

        ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout_splash);
        constraintLayout.clearAnimation();
        constraintLayout.startAnimation(a);


        new CountDownTimer(3 * 1000, 1000) {
            public void onTick(long millisUntilFinished) {
                Log.v("SplashScreenUIActivity", "countdown" + millisUntilFinished);
            }
            public void onFinish() {
                IntentWrapper.startDashboardActivity(SplashScreenUIActivity.this);
            }
        }.start();
    }
}
