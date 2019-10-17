package com.streetsmart.app.activityUI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.streetsmart.app.R;

public class EndGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        TextView textView3 = findViewById(R.id.textView3);
        startCountAnimation(textView3, 0, 1);

        CardView cardView = findViewById(R.id.cardView);
        cardView.setVisibility(View.VISIBLE);

        TextView textView = findViewById(R.id.textView);
        startCountAnimation(textView, 10, 1);

        TextView textView2 = findViewById(R.id.textView2);
        startCountAnimation(textView2, 0, 50);
    }

    public void onClickSubmit(View view) {
        Intent intent = new Intent(EndGameActivity.this, MainUIActivity.class);
        startActivity(intent);
    }

    private void startCountAnimation(final TextView textView, int init, int fin) {
        ValueAnimator animator = ValueAnimator.ofInt(init, fin);
        animator.setDuration(2000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                textView.setText(animation.getAnimatedValue().toString());
            }
        });
        animator.start();
    }
}
