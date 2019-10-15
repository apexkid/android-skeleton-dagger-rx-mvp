package com.streetsmart.app.activity.play.startgame;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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

    private PlayFragmentFlow mFlow;

    public StartGameFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static StartGameFragment newInstance(String param1, String param2) {
        StartGameFragment fragment = new StartGameFragment();
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

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
