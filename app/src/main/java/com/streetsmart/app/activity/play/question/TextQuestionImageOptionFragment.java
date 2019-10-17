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
import com.streetsmart.app.activity.play.PlayConstants;
import com.streetsmart.app.activity.play.PlayFragmentFlow;
import com.streetsmart.app.data.AnswerRecord;
import com.streetsmart.app.data.api.QuestionForUser;
import com.streetsmart.app.modules.GlideApp;

import butterknife.BindView;
import butterknife.ButterKnife;


public class TextQuestionImageOptionFragment extends Fragment {

    private PlayFragmentFlow mFlow;

    @BindView(R.id.question_title)
    TextView questionTextView;

    @BindView(R.id.imageView_option_1)
    ImageView imageViewOption1;

    @BindView(R.id.imageView_option_2)
    ImageView imageViewOption2;

    @BindView(R.id.imageView_option_3)
    ImageView imageViewOption3;

    @BindView(R.id.imageView_option_4)
    ImageView imageViewOption4;

    @BindView(R.id.next_button)
    ImageView nextTextView;
    //TextView nextTextView;

    private String questionText;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    private AnswerRecord answerRecord = new AnswerRecord();


    public TextQuestionImageOptionFragment() {
        // Required empty public constructor
    }

    public static TextQuestionImageOptionFragment newInstance(QuestionForUser question) {
        TextQuestionImageOptionFragment fragment = new TextQuestionImageOptionFragment();
        final Bundle args = new Bundle();
        args.putString(PlayConstants.QUESTION_TEXT, question.getQuestionText());
        args.putString(PlayConstants.OPTION1, question.getOptionList().get(0).getOptionImageUrl());
        args.putString(PlayConstants.OPTION2, question.getOptionList().get(1).getOptionImageUrl());
        args.putString(PlayConstants.OPTION3, question.getOptionList().get(2).getOptionImageUrl());
        args.putString(PlayConstants.OPTION4, question.getOptionList().get(3).getOptionImageUrl());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            questionText = getArguments().getString(PlayConstants.QUESTION_TEXT);
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
        View view = inflater.inflate(R.layout.fragment_text_question_image_option, container, false);

        ButterKnife.bind(this, view);

        questionTextView.setText(questionText);

        GlideApp.with(getActivity())
                .load(option1)
                .into(imageViewOption1);

        GlideApp.with(getActivity())
                .load(option2)
                .into(imageViewOption2);

        GlideApp.with(getActivity())
                .load(option3)
                .into(imageViewOption3);

        GlideApp.with(getActivity())
                .load(option4)
                .into(imageViewOption4);


        setListener(imageViewOption1, option1);
        setListener(imageViewOption2, option2);
        setListener(imageViewOption3, option3);
        setListener(imageViewOption4, option4);
        
        nextTextView.setOnClickListener(v -> mFlow.onAnswerSelect(answerRecord));

        return view;
    }

    private void setListener(ImageView imageViewOption, String url) {
        imageViewOption.setTag(R.string.image_tag, url);
        imageViewOption.setOnClickListener(v -> {
            String ans = (String) v.getTag(R.string.image_tag);
            if(answerRecord.contains(ans)) {
                answerRecord.removeAnswer(ans);
                imageViewOption.setAlpha(255);
            } else {
                answerRecord.addAnswer(ans);
                imageViewOption.setAlpha(100);
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
