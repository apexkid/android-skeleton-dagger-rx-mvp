package com.streetsmart.app.activityUI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.streetsmart.app.R;

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
    }
}
