package com.streetsmart.app.activityUI;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.streetsmart.app.R;

import static com.streetsmart.app.activityUI.CreateOnTouchListener.createOnTouchListener;

public class StartGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);

        Button button = findViewById(R.id.button);
        button.setOnTouchListener(createOnTouchListener(button));

        ImageView imageView = findViewById(R.id.imageView);

        ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(
                imageView, "scaleX", 1f, 0.8f, 1f);
        ObjectAnimator scaleDownY = ObjectAnimator.ofFloat(
                imageView, "scaleY", 1f, 0.8f, 1f);
        scaleDownX.setDuration(1500).setRepeatCount(100);
        scaleDownY.setDuration(1500).setRepeatCount(100);

        AnimatorSet scaleDown = new AnimatorSet();
        scaleDown.play(scaleDownX).with(scaleDownY);

        scaleDown.start();
    }

    public void onClickSubmit(View view) {
        Intent intent = new Intent(StartGameActivity.this, GameActivity.class);
        startActivity(intent);
    }
}
