package com.streetsmart.app.activity.play.question;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.streetsmart.app.R;
import com.streetsmart.app.activity.play.PlayFragmentFlow;

import java.util.HashSet;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;


public class AllTextQuestionFragment extends Fragment {


    @BindView(R.id.question_option_1)
    TextView option1;

    @BindView(R.id.question_option_2)
    TextView option2;

    @BindView(R.id.question_option_3)
    TextView option3;

    @BindView(R.id.question_option_4)
    TextView option4;

    @BindView(R.id.next_button)
    TextView nextTextView;

    private PlayFragmentFlow mFlow;
    private Set<String> selectedAns = new HashSet<>();

    public AllTextQuestionFragment() {}

    public static AllTextQuestionFragment newInstance(String param1, String param2) {
        AllTextQuestionFragment fragment = new AllTextQuestionFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_text_question, container, false);

        ButterKnife.bind(this, view);

        setListener(option1);
        setListener(option2);
        setListener(option3);
        setListener(option4);

        nextTextView.setOnClickListener(v -> mFlow.onAnswerSelect(selectedAns));

        return view;
    }

    private void setListener(final TextView textView) {
        textView.setOnClickListener(v -> {
            String ans = ((TextView) v).getText().toString();
            if(selectedAns.contains(ans)) {
                selectedAns.remove(ans);
                textView.setBackgroundColor(getResources().getColor(R.color.white));
            } else {
                selectedAns.add(ans);
                textView.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            }
        });
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
