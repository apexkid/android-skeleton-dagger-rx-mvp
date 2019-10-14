package com.streetsmart.app.activity.play;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.streetsmart.app.R;
import com.streetsmart.app.activity.play.textquestion.TextQuestionFragment;
import com.streetsmart.app.data.GameQuestionsRecord;
import com.streetsmart.app.root.StreetsmartApp;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayActivity extends AppCompatActivity implements PlayMVP.View, PlayFragmentFlow {

    @Inject
    PlayMVP.Presenter presenter;

    @BindView(R.id.timer)
    TextView timerTextView;

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        ((StreetsmartApp) getApplication())
                .getApplicationComponent()
                .inject(PlayActivity.this);

        ButterKnife.bind(this);

        fragmentManager = getSupportFragmentManager();

    }

    @Override
    public void updateData(GameQuestionsRecord record) {

        launchTextQuestionFragment();

        new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                timerTextView.setText("seconds remaining: " + millisUntilFinished / 1000);
            }
            public void onFinish() {
                timerTextView.setText("done!");
            }
        }.start();


    }

    private void launchTextQuestionFragment() {

        FragmentTransaction ft = fragmentManager.beginTransaction();
        final TextQuestionFragment askPNContentFragment = new TextQuestionFragment();

        ft.replace(R.id.question_layout_container, askPNContentFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

    @Override
    public void showRefreshLoader(boolean loadingStatus) {

    }

    @Override
    public void clearData() {

    }

    @Override
    public void showSnackbar(String msg) {

    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachView(this);
        presenter.subscribeData();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachView();
        presenter.unsubscribeData();
    }

}
