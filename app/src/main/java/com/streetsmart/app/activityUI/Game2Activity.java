package com.streetsmart.app.activityUI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.streetsmart.app.R;

import static com.streetsmart.app.activityUI.CreateOnTouchListener.createOnTouchListener;

public class Game2Activity extends AppCompatActivity {

    private int noOfImagesSelected = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);

        final CardView cardView = findViewById(R.id.cardView);
        cardView.setOnTouchListener(createOnTouchListener(cardView));
        cardView.setOnClickListener(createOnClickListener(R.id.tick1));

        final CardView cardView2 = findViewById(R.id.cardView2);
        cardView2.setOnTouchListener(createOnTouchListener(cardView2));
        cardView2.setOnClickListener(createOnClickListener(R.id.tick2));

        final CardView cardView3 = findViewById(R.id.cardView3);
        cardView3.setOnTouchListener(createOnTouchListener(cardView3));
        cardView3.setOnClickListener(createOnClickListener(R.id.tick3));

        final CardView cardView4 = findViewById(R.id.cardView4);
        cardView4.setOnTouchListener(createOnTouchListener(cardView4));
        cardView4.setOnClickListener(createOnClickListener(R.id.tick4));

        de.hdodenhof.circleimageview.CircleImageView circleImageView = findViewById(R.id.circularImageView);
        circleImageView.setOnTouchListener(createOnTouchListener(circleImageView));
    }

    public View.OnClickListener createOnClickListener(final int id) {
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView imageView = findViewById(id);
                de.hdodenhof.circleimageview.CircleImageView circleImageView = findViewById(R.id.circularImageView);
                if (imageView.getVisibility() == View.VISIBLE) {
                    imageView.setVisibility(View.INVISIBLE);
                    noOfImagesSelected--;
                    if(noOfImagesSelected==0) {
                        circleImageView.setVisibility(View.INVISIBLE);
                    }
                } else if (imageView.getVisibility() == View.INVISIBLE) {
                    imageView.setVisibility(View.VISIBLE);
                    circleImageView.setVisibility(View.VISIBLE);
                    noOfImagesSelected++;
                }
            }
        };
        return onClickListener;
    }

    public void onClickSubmit(View view) {
        Intent intent = new Intent(Game2Activity.this, Game3Activity.class);
        startActivity(intent);
    }
}
