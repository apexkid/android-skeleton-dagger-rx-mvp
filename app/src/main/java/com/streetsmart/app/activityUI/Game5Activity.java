package com.streetsmart.app.activityUI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import com.streetsmart.app.R;

import static com.streetsmart.app.activityUI.CreateOnTouchListener.createOnTouchListener;

public class Game5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game5);

        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                TextView textView = findViewById(R.id.textView2);
                textView.setText("$ " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                de.hdodenhof.circleimageview.CircleImageView circleImageView = findViewById(R.id.circularImageView);
                circleImageView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        de.hdodenhof.circleimageview.CircleImageView circleImageView = findViewById(R.id.circularImageView);
        circleImageView.setOnTouchListener(createOnTouchListener(circleImageView));
    }

    public void onClickSubmit(View view) {
        Intent intent = new Intent(Game5Activity.this, EndGameActivity.class);
        startActivity(intent);
    }
}
