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


public class TextQuestionImageOptionFragment extends Fragment {

    private PlayFragmentFlow mFlow;

    @BindView(R.id.imageView_option_1)
    ImageView option1;

    @BindView(R.id.imageView_option_2)
    ImageView option2;

    @BindView(R.id.imageView_option_3)
    ImageView option3;

    @BindView(R.id.imageView_option_4)
    ImageView option4;

    @BindView(R.id.next_button)
    TextView nextTextView;

    private AnswerRecord answerRecord = new AnswerRecord();

    public TextQuestionImageOptionFragment() {
        // Required empty public constructor
    }

    public static TextQuestionImageOptionFragment newInstance(String param1, String param2) {
        TextQuestionImageOptionFragment fragment = new TextQuestionImageOptionFragment();
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
        View view = inflater.inflate(R.layout.fragment_text_question_image_option, container, false);

        ButterKnife.bind(this, view);

        nextTextView.setOnClickListener(v -> mFlow.onAnswerSelect(answerRecord));

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
