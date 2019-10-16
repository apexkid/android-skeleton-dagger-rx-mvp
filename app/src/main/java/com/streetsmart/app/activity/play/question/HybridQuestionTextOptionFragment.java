package com.streetsmart.app.activity.play.question;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.streetsmart.app.R;
import com.streetsmart.app.activity.play.PlayFragmentFlow;
import com.streetsmart.app.data.AnswerRecord;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HybridQuestionTextOptionFragment extends Fragment {


    @BindView(R.id.question_option_1)
    TextView option1;

    @BindView(R.id.question_option_2)
    TextView option2;

    @BindView(R.id.question_option_3)
    TextView option3;

    @BindView(R.id.question_option_4)
    TextView option4;

    @BindView(R.id.imageView_question)
    ImageView questionImage;

    @BindView(R.id.next_button)
    TextView nextTextView;

    private AnswerRecord answerRecord = new AnswerRecord();

    private PlayFragmentFlow mFlow;

    public HybridQuestionTextOptionFragment() {}

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
        final View view = inflater.inflate(R.layout.fragment_hybrid_question_text_option, container, false);

        ButterKnife.bind(this, view);

        setListener(option1);
        setListener(option2);
        setListener(option3);
        setListener(option4);

        nextTextView.setOnClickListener(v -> mFlow.onAnswerSelect(answerRecord));

        return view;
    }

    private void setListener(final TextView textView) {
        textView.setOnClickListener(v -> {
            String ans = ((TextView) v).getText().toString();
            if(answerRecord.contains(ans)) {
                answerRecord.removeAnswer(ans);
                textView.setBackgroundColor(getResources().getColor(R.color.white));
            } else {
                answerRecord.addAnswer(ans);
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
