package com.streetsmart.app.activityUI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.TextView;

import com.streetsmart.app.R;

import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;

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

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        float width = size.x;
        float height = size.y;

        nl.dionsegijn.konfetti.KonfettiView viewKonfetti = findViewById(R.id.viewKonfetti);
        viewKonfetti.build()
                .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
                .setDirection(90.0, 90.0)
                .setSpeed(1f, 5f)
                .setFadeOutEnabled(true)
                .setTimeToLive(1000L)
                .addShapes(Shape.RECT, Shape.CIRCLE)
                .addSizes(new Size(12, 5))
                .setPosition(0, width, 0f, 0f)
                .streamFor(300, 5000L);
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
