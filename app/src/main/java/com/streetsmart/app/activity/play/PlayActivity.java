package com.streetsmart.app.activity.play;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.streetsmart.app.R;
import com.streetsmart.app.activity.play.endgame.EndGameFragment;
import com.streetsmart.app.activity.play.finalstate.FinalStateFragment;
import com.streetsmart.app.activity.play.question.AllTextQuestionFragment;
import com.streetsmart.app.activity.play.question.HybridQuestionImageOptionFragment;
import com.streetsmart.app.activity.play.question.HybridQuestionTextOptionFragment;
import com.streetsmart.app.activity.play.question.TextQuestionImageOptionFragment;
import com.streetsmart.app.activity.play.startgame.StartGameFragment;
import com.streetsmart.app.data.AnswerRecord;
import com.streetsmart.app.data.api.QuestionForUser;
import com.streetsmart.app.root.StreetsmartApp;
import com.streetsmart.app.utils.IntentWrapper;
import com.streetsmart.app.utils.PlayUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayActivity extends AppCompatActivity implements PlayMVP.View, PlayFragmentFlow {

    private static List<String> hurrayText = new ArrayList<>();

    static {
        hurrayText.add("Yay");
        hurrayText.add("Going well");
        hurrayText.add("Nice!");
        hurrayText.add("Superb");
        hurrayText.add("Awesome..");
    }

    @Inject
    PlayMVP.Presenter presenter;

    @BindView(R.id.timer)
    TextView timerTextView;

    @BindView(R.id.question_count)
    TextView questionCountTextView;

    private FragmentManager fragmentManager;

    private CountDownTimer countdown;

    private static final int GAME_TIME_IN_SECONDS = 60;
    private static int GAME_QUESTIONS_COUNT = 10;

    private int questionsAnswered = 0;
    private long timeRemainingInSeconds;


    private StartGameFragment startGameFragment;
    private EndGameFragment endGameFragment;

    private List<QuestionForUser> questionList = new ArrayList<>();
    private List<AnswerRecord> answerList = new ArrayList<>();

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
    public void clearData() {
        questionList.clear();
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
            questionList.add(record);
            GAME_QUESTIONS_COUNT = questionList.size();
        }
    }

    @Override
    public void launchGame() {
        launchFragmentForQuestion(questionList.get(questionsAnswered));
        countdown = new CountDownTimer(GAME_TIME_IN_SECONDS * 1000, 1000) {
            public void onTick(long millisUntilFinished) {
                timerTextView.setText("seconds remaining: " + millisUntilFinished / 1000);
                timeRemainingInSeconds =  millisUntilFinished / 1000;
            }

            public void onFinish() {
                timerTextView.setText("Time Up!");
                launchEndGameFragment();
            }
        };
        countdown.start();
    }

    @Override
    public void showRefreshLoaderOnEndGame(boolean b) {
        endGameFragment.showEndGameRefreshLoader(b);
    }

    private void launchFragmentForQuestion(QuestionForUser question) {
        switch(PlayUtils.getQuestionViewType(question)) {
            case TT:
                launchTextQuestionFragment(question);
                break;
            case TI:
                launchTextQuestionImageOptionFragment(question);
                break;
            case HT:
                launchHybridQuestionTextOptionsFragment(question);
                break;
            case HI:
                launchHybridQuestionImageOptionsFragment(question);
                break;
        }
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
        questionList.clear();
        questionsAnswered = 0;
    }

    @Override
    public void onAnswerSelect(AnswerRecord answer) {
        updateAnswerIfRange(answer);
        answerList.add(answer);
        questionsAnswered++;
        questionCountTextView.setText(questionsAnswered + " / " + GAME_QUESTIONS_COUNT);
        Toast.makeText(this, getToastText(), Toast.LENGTH_SHORT).show();

        if (questionsAnswered == GAME_QUESTIONS_COUNT) {
            countdown.cancel();
            launchEndGameFragment();
            return;
        }

        launchFragmentForQuestion(questionList.get(questionsAnswered));
    }

    private String getToastText() {
        int index = ThreadLocalRandom.current().nextInt(hurrayText.size());
        return hurrayText.get(index);
    }

    private void updateAnswerIfRange(AnswerRecord answer) {
        try {
            if (answer != null && answer.getAnswers().size() > 0) {
                String ans = answer.getAnswers().iterator().next();
                if (ans.contains("-")) {
                    String[] result = ans.split("-", -1);
                    int x = Integer.parseInt(result[0]);
                    int y = Integer.parseInt(result[1]);
                    answer.clearAndUpdate(String.valueOf((int)((x+y)/2)));
                }
            }
        } catch (Exception e) {
            Log.v("ERROR", "updateAnswerIfRange");
        }
    }

    @Override
    public int getScoreForGameSessions() {
        Log.v("PlayActivity", "QuestionList=" + questionList + " ..Answers:=" + answerList);
        return PlayUtils.getScore(questionList, answerList, (int) timeRemainingInSeconds);
    }

    @Override
    public void submitScore() {
        presenter.submitScore(questionList, answerList, "rahulvallu@gmail.com", getScoreForGameSessions());
    }

    @Override
    public void showFinalGameState() {
        launchFinalStateFragment();
    }

    private void launchStartGameFragment() {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        this.startGameFragment = new StartGameFragment();

        ft.replace(R.id.question_layout_container, startGameFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

    private void launchTextQuestionFragment(QuestionForUser question) {

        FragmentTransaction ft = fragmentManager.beginTransaction();
        final AllTextQuestionFragment allTextQuestionFragment = AllTextQuestionFragment.newInstance(question);

        ft.replace(R.id.question_layout_container, allTextQuestionFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

    private void launchTextQuestionImageOptionFragment(QuestionForUser question) {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        final TextQuestionImageOptionFragment textQuestionImageOptionFragment = TextQuestionImageOptionFragment.newInstance(question);

        ft.replace(R.id.question_layout_container, textQuestionImageOptionFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

    private void launchHybridQuestionImageOptionsFragment(QuestionForUser question) {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        final HybridQuestionImageOptionFragment hybridQuestionImageOptionFragment = HybridQuestionImageOptionFragment.newInstance(question);

        ft.replace(R.id.question_layout_container, hybridQuestionImageOptionFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

    private void launchHybridQuestionTextOptionsFragment(QuestionForUser question) {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        final HybridQuestionTextOptionFragment hybridQuestionTextOptionFragment = HybridQuestionTextOptionFragment.newInstance(question);

        ft.replace(R.id.question_layout_container, hybridQuestionTextOptionFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

    private void launchEndGameFragment() {

        FragmentTransaction ft = fragmentManager.beginTransaction();
        endGameFragment = new EndGameFragment();

        ft.replace(R.id.question_layout_container, endGameFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

    private void launchFinalStateFragment() {

        FragmentTransaction ft = fragmentManager.beginTransaction();
        FinalStateFragment fragment = new FinalStateFragment();

        ft.replace(R.id.question_layout_container, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }
}
