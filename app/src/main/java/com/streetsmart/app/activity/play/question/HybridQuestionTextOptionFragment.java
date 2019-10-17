package com.streetsmart.app.activity.play.question;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.streetsmart.app.R;
import com.streetsmart.app.activity.play.PlayConstants;
import com.streetsmart.app.activity.play.PlayFragmentFlow;
import com.streetsmart.app.data.AnswerRecord;
import com.streetsmart.app.data.api.QuestionForUser;
import com.streetsmart.app.modules.GlideApp;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HybridQuestionTextOptionFragment extends Fragment {

    @BindView(R.id.question_title)
    TextView questionTextView;

    @BindView(R.id.question_option_1)
    Button optionTextView1;

    @BindView(R.id.question_option_2)
    Button optionTextView2;

    @BindView(R.id.question_option_3)
    Button optionTextView3;

    @BindView(R.id.question_option_4)
    Button optionTextView4;

    @BindView(R.id.imageView_question)
    ImageView questionImageImageView;

    @BindView(R.id.next_button)
    ImageView nextTextView;

    private String questionText;
    private String questionImageUrl;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    private AnswerRecord answerRecord = new AnswerRecord();

    private PlayFragmentFlow mFlow;

    public HybridQuestionTextOptionFragment() {}

    public static HybridQuestionTextOptionFragment newInstance(QuestionForUser question) {

        Log.v("HybridQuestionTextO", "" + question);

        final HybridQuestionTextOptionFragment fragment = new HybridQuestionTextOptionFragment();
        final Bundle args = new Bundle();
        args.putString(PlayConstants.QUESTION_TEXT, question.getQuestionText());
        args.putString(PlayConstants.QUESTION_IMAGE, question.getQuestionImageUrl());
        args.putString(PlayConstants.OPTION1, question.getOptionList().get(0).getOptionText());
        args.putString(PlayConstants.OPTION2, question.getOptionList().get(1).getOptionText());
        args.putString(PlayConstants.OPTION3, question.getOptionList().get(2).getOptionText());
        args.putString(PlayConstants.OPTION4, question.getOptionList().get(3).getOptionText());
        fragment.setArguments(args);

        Log.v("HybridQuestionTextO", "D:questionText=" + question.getQuestionText());
        Log.v("HybridQuestionTextO", "D:questionImageImageView=" + question.getQuestionImageUrl());

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            questionText = getArguments().getString(PlayConstants.QUESTION_TEXT);
            questionImageUrl = getArguments().getString(PlayConstants.QUESTION_IMAGE);
            option1 = getArguments().getString(PlayConstants.OPTION1);
            option2 = getArguments().getString(PlayConstants.OPTION2);
            option3 = getArguments().getString(PlayConstants.OPTION3);
            option4 = getArguments().getString(PlayConstants.OPTION4);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.activity_game3, container, false);

        ButterKnife.bind(this, view);

        Log.v("HybridQuestionTextO", "questionText=" + questionText);
        Log.v("HybridQuestionTextO", "questionImageImageView=" + questionImageUrl);


        questionTextView.setText(questionText);

        optionTextView1.setText(option1);
        optionTextView2.setText(option2);
        optionTextView3.setText(option3);
        optionTextView4.setText(option4);

        GlideApp.with(getActivity())
                .load(questionImageUrl)
                .into(questionImageImageView);

        setListener(optionTextView1);
        setListener(optionTextView2);
        setListener(optionTextView3);
        setListener(optionTextView4);

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
