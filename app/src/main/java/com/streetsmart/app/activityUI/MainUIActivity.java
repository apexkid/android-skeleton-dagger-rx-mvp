package com.streetsmart.app.activityUI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.streetsmart.app.R;

import static com.streetsmart.app.activityUI.CreateOnTouchListener.createOnTouchListener;

public class MainUIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout linearLayout = findViewById(R.id.linearLayout);
        linearLayout.setOnTouchListener(createOnTouchListener(linearLayout));
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainUIActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout linearLayout3 = findViewById(R.id.linearLayout3);
        linearLayout3.setOnTouchListener(createOnTouchListener(linearLayout3));
        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainUIActivity.this, StartGameActivity.class);
                startActivity(intent);
            }
        });
    }
}

