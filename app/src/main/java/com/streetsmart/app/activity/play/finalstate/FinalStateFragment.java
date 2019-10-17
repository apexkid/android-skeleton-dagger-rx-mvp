package com.streetsmart.app.activity.play.finalstate;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.streetsmart.app.R;
import com.streetsmart.app.activity.play.PlayFragmentFlow;
import com.streetsmart.app.utils.IntentWrapper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FinalStateFragment extends Fragment {

    private PlayFragmentFlow mFlow;

    @BindView(R.id.button_home)
    Button goHomeButton;

    public static FinalStateFragment newInstance(String param1, String param2) {
        FinalStateFragment fragment = new FinalStateFragment();
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
        View view =  inflater.inflate(R.layout.fragment_final_state, container, false);

        ButterKnife.bind(this, view);

        goHomeButton.setOnClickListener(v -> {
            IntentWrapper.startDashboardActivity(getActivity());
            getActivity().finish();
        });
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