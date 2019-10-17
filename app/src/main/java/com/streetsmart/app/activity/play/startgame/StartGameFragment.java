package com.streetsmart.app.activity.play.startgame;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.streetsmart.app.R;
import com.streetsmart.app.activity.play.PlayFragmentFlow;

import butterknife.BindView;
import butterknife.ButterKnife;


public class StartGameFragment extends Fragment {


    @BindView(R.id.button_start_play)
    Button startButton;

    @BindView(R.id.button_cancel_play)
    Button cancelButton;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.textView_preparing_game)
    TextView preparingGameTextView;

    @BindView(R.id.textView_hint_text)
    TextView hintText;

    @BindView(R.id.imageView_start_game_animation)
    ImageView loaderImageView;

    private PlayFragmentFlow mFlow;
    private AnimatorSet scaleDown;

    public StartGameFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_start_game, container, false);

        ButterKnife.bind(this, view);
        startButton.setOnClickListener(v -> mFlow.startGame());
        cancelButton.setOnClickListener(v -> mFlow.cancelGame());

        ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(
                loaderImageView, "scaleX", 1f, 0.8f, 1f);
        ObjectAnimator scaleDownY = ObjectAnimator.ofFloat(
                loaderImageView, "scaleY", 1f, 0.8f, 1f);
        scaleDownX.setDuration(1500).setRepeatCount(100);
        scaleDownY.setDuration(1500).setRepeatCount(100);

        this.scaleDown = new AnimatorSet();
        scaleDown.play(scaleDownX).with(scaleDownY);

        hintText.setText("Lets play Street Smart!!");

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mFlow = (PlayFragmentFlow) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString() + " must implement PlayFragmentFlow");
        }
    }


    public void showLoader(boolean status) {
        if(status) {
            //progressBar.setVisibility(View.VISIBLE);
            //preparingGameTextView.setVisibility(View.VISIBLE);
            hintText.setText("Getting smart questions for you..");
            scaleDown.start();
        } else {
            //progressBar.setVisibility(View.GONE);
            //preparingGameTextView.setVisibility(View.GONE);
            hintText.setText("Lets play Street Smart!!");
            scaleDown.end();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
