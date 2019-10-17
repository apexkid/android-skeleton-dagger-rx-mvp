package com.streetsmart.app.activity.play.finalstate;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

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

    @BindView(R.id.textView)
    TextView textView;

    @BindView(R.id.textView_score_status)
    TextView textView2;

    @BindView(R.id.textView3)
    TextView textView3;

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
        startCountAnimation(textView3, 10, 14);
        startCountAnimation(textView, 150, 112);
        startCountAnimation(textView2, 1800, 2100);
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
