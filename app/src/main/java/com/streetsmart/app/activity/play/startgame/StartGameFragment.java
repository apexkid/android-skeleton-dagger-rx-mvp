package com.streetsmart.app.activity.play.startgame;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

    private PlayFragmentFlow mFlow;

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
            progressBar.setVisibility(View.VISIBLE);
            preparingGameTextView.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
            preparingGameTextView.setVisibility(View.GONE);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
