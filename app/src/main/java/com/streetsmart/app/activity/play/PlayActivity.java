package com.streetsmart.app.activity.play;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.streetsmart.app.R;
import com.streetsmart.app.activity.play.endgame.EndGameFragment;
import com.streetsmart.app.activity.play.question.AllTextQuestionFragment;
import com.streetsmart.app.activity.play.question.HybridQuestionImageOptionFragment;
import com.streetsmart.app.activity.play.question.HybridQuestionTextOptionFragment;
import com.streetsmart.app.activity.play.question.TextQuestionImageOptionFragment;
import com.streetsmart.app.activity.play.startgame.StartGameFragment;
import com.streetsmart.app.data.api.QuestionForUser;
import com.streetsmart.app.root.StreetsmartApp;
import com.streetsmart.app.utils.IntentWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayActivity extends AppCompatActivity implements PlayMVP.View, PlayFragmentFlow {

    @Inject
    PlayMVP.Presenter presenter;

    @BindView(R.id.timer)
    TextView timerTextView;

    @BindView(R.id.question_count)
    TextView questionCountTextView;

    private FragmentManager fragmentManager;

    private CountDownTimer countdown;

    private static final int GAME_TIME_IN_SECONDS = 30;
    private static final int GAME_QUESTIONS_COUNT = 10;

    private int questionsAnswered = 0;


    private StartGameFragment startGameFragment;

    private List<QuestionForUser> questions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        ((StreetsmartApp) getApplication())
                .getApplicationComponent()
                .inject(PlayActivity.this);

        ButterKnife.bind(this);

        fragmentManager = getSupportFragmentManager();
        timerTextView.setText("seconds remaining: " + GAME_TIME_IN_SECONDS);
        questionCountTextView.setText(questionsAnswered + " / " + GAME_QUESTIONS_COUNT);
    }

    @Override
    public void startGame() {
        presenter.onStartGame();
    }

    @Override
    public void cancelGame() {
        IntentWrapper.startDashboardActivity(this);
        finish();
    }

    @Override
    public void showRefreshLoader(boolean loadingStatus) {

    }

    @Override
    public void clearData() {
        questions.clear();
    }

    @Override
    public void showPrepareGameState(boolean status) {
        if(status) {
            startGameFragment.showLoader(true);
        } else {
            startGameFragment.showLoader(false);
        }
    }

    @Override
    public void updateQuestionData(QuestionForUser record) {
        if(record != null) {
            questions.add(record);
        }
    }

    @Override
    public void launchGame() {
        launchTextQuestionFragment();
        countdown = new CountDownTimer(GAME_TIME_IN_SECONDS * 1000, 1000) {
            public void onTick(long millisUntilFinished) {
                timerTextView.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                timerTextView.setText("Time Up!");
                launchEndGameFragment();
            }
        };
        countdown.start();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachView(this);
        launchStartGameFragment();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachView();
        presenter.unsubscribeData();
        questions.clear();
    }

    @Override
    public void onAnswerSelect(Set<String> selectedAnswer) {
        //launchTextQuestionFragment();
        //launchTextQuestionImageOptionFragment();
        //launchHybridQuestionImageOptionsFragment();
        launchHybridQuestionTextOptionsFragment();
        questionsAnswered++;
        questionCountTextView.setText(questionsAnswered + " / " + GAME_QUESTIONS_COUNT);
        Toast.makeText(this, "Answer selected=" + selectedAnswer.toString(), Toast.LENGTH_SHORT).show();

        if (questionsAnswered == GAME_QUESTIONS_COUNT) {
            countdown.cancel();
            launchEndGameFragment();
        }
    }

    private void launchStartGameFragment() {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        this.startGameFragment = new StartGameFragment();

        ft.replace(R.id.question_layout_container, startGameFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

    private void launchTextQuestionFragment() {

        FragmentTransaction ft = fragmentManager.beginTransaction();
        final AllTextQuestionFragment allTextQuestionFragment = new AllTextQuestionFragment();

        ft.replace(R.id.question_layout_container, allTextQuestionFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

    private void launchTextQuestionImageOptionFragment() {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        final TextQuestionImageOptionFragment textQuestionImageOptionFragment = new TextQuestionImageOptionFragment();

        ft.replace(R.id.question_layout_container, textQuestionImageOptionFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

    private void launchHybridQuestionImageOptionsFragment() {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        final HybridQuestionImageOptionFragment hybridQuestionImageOptionFragment = new HybridQuestionImageOptionFragment();

        ft.replace(R.id.question_layout_container, hybridQuestionImageOptionFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

    private void launchHybridQuestionTextOptionsFragment() {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        final HybridQuestionTextOptionFragment hybridQuestionTextOptionFragment = new HybridQuestionTextOptionFragment();

        ft.replace(R.id.question_layout_container, hybridQuestionTextOptionFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

    private void launchEndGameFragment() {

        FragmentTransaction ft = fragmentManager.beginTransaction();
        final EndGameFragment askPNContentFragment = new EndGameFragment();

        ft.replace(R.id.question_layout_container, askPNContentFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }
}
