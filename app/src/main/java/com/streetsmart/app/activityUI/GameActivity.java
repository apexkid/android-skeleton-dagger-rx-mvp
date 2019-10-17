
package com.streetsmart.app.activityUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.streetsmart.app.R;

import static com.streetsmart.app.activityUI.CreateOnTouchListener.createOnTouchListener;

public class GameActivity extends AppCompatActivity {

    private int noOfTextOptionsSelected = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Button button = findViewById(R.id.question_option_1);
        button.setOnTouchListener(createOnTouchListener(button));
        button.setOnClickListener(createOnClickListener());

        Button button2 = findViewById(R.id.question_option_2);
        button2.setOnTouchListener(createOnTouchListener(button2));
        button2.setOnClickListener(createOnClickListener());

        Button button3 = findViewById(R.id.question_option_3);
        button3.setOnTouchListener(createOnTouchListener(button3));
        button3.setOnClickListener(createOnClickListener());

        Button button4 = findViewById(R.id.question_option_4);
        button4.setOnTouchListener(createOnTouchListener(button4));
        button4.setOnClickListener(createOnClickListener());

        de.hdodenhof.circleimageview.CircleImageView circleImageView = findViewById(R.id.circularImageView);
        circleImageView.setOnTouchListener(createOnTouchListener(circleImageView));
    }

    public View.OnClickListener createOnClickListener() {
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                de.hdodenhof.circleimageview.CircleImageView circleImageView = findViewById(R.id.circularImageView);
                int textColor = button.getTextColors().getDefaultColor();
                if (textColor == ResourcesCompat.getColor(getResources(), R.color.colorPrimaryDark, null)) {
                    button.setTextColor(ResourcesCompat.getColor(getResources(), R.color.colorWhite, null));
                    button.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.rounded_corner_colored, null));
                    circleImageView.setVisibility(View.VISIBLE);
                    noOfTextOptionsSelected++;
                } else if (textColor == ResourcesCompat.getColor(getResources(), R.color.colorWhite, null)) {
                    button.setTextColor(ResourcesCompat.getColor(getResources(), R.color.colorPrimaryDark, null));
                    button.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.rounded_corner, null));
                    noOfTextOptionsSelected--;
                    if (noOfTextOptionsSelected == 0) {
                        circleImageView.setVisibility(View.INVISIBLE);
                    }
                }
            }
        };
        return onClickListener;
    }

    public void onClickSubmit(View view) {
        Intent intent = new Intent(GameActivity.this, Game2Activity.class);
        startActivity(intent);
    }
}
