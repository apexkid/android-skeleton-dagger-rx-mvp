package com.streetsmart.app.activity.play.endgame;

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
import com.streetsmart.app.utils.IntentWrapper;

import butterknife.BindView;
import butterknife.ButterKnife;


public class EndGameFragment extends Fragment {

    private PlayFragmentFlow mFlow;


    @BindView(R.id.button_end_play)
    Button endPlay;

    @BindView(R.id.progressBar_end_game)
    ProgressBar progressBar;

    @BindView(R.id.textView_score_status)
    TextView endGameStatusTextView;

    public EndGameFragment() {
        // Required empty public constructor
    }

    public static EndGameFragment newInstance(String param1, String param2) {
        EndGameFragment fragment = new EndGameFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_end_game, container, false);
        ButterKnife.bind(this, view);


        endPlay.setOnClickListener(v -> {
            IntentWrapper.startDashboardActivity(getActivity());
            getActivity().finish();
        });

        fetchScore();

        return view;
    }

    private void fetchScore() {
        progressBar.setVisibility(View.VISIBLE);
        int score = mFlow.getScoreForGameSessions();
        endGameStatusTextView.setText("Your score: " + score);
        progressBar.setVisibility(View.GONE);
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

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
