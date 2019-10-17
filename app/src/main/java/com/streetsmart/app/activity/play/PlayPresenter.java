package com.streetsmart.app.activity.play;

import android.util.Log;

import com.streetsmart.app.activity.api.APIService;
import com.streetsmart.app.data.AnswerRecord;
import com.streetsmart.app.data.api.GameResultPOSTBody;
import com.streetsmart.app.data.api.QuestionForUser;
import com.streetsmart.app.utils.GameResultPOSTBodyXmer;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import lombok.NonNull;

public class PlayPresenter implements PlayMVP.Presenter {

    private final static String TAG = PlayPresenter.class.getName();

    private PlayMVP.View view;
    private APIService apiService;

    private Disposable disposable;

    public PlayPresenter(@NonNull APIService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void attachView(PlayMVP.View view) {
        this.view = view;
        Log.v(TAG, "Attach view done. View=" + view);
    }

    @Override
    public void detachView() {
        this.view = null;
    }


    @Override
    public void unsubscribeData() {
        if(disposable != null) {
            disposable.dispose();
        }
    }

    @Override
    public void onStartGame() {
        if(view != null) {

            view.showPrepareGameState(true);
            view.clearData();
            disposable = getQuestionForUser("rahulvallu@gmail.com")
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableObserver<QuestionForUser>() {
                        @Override
                        public void onNext(QuestionForUser record) {
                            Log.v(TAG, "Got data for questionForUser=" + record);
                            view.updateQuestionData(record);
                        }

                        @Override
                        public void onError(Throwable e) {
                            view.showPrepareGameState(false);
                            Log.e(TAG, "Error in getQuestionForuser", e);
                            e.printStackTrace();
                        }

                        @Override
                        public void onComplete() {
                            view.showPrepareGameState(false);
                            view.launchGame();
                        }
                    });
        }
    }

    @Override
    public void submitScore(List<QuestionForUser> questionList, List<AnswerRecord> answerList, String userId, int scoreForGameSessions) {
        final GameResultPOSTBody result = GameResultPOSTBodyXmer.createGameResultPostBody(questionList, answerList, userId, scoreForGameSessions);

        Log.v(TAG, "Result to submit=" + result);
        view.showRefreshLoaderOnEndGame(true);
        disposable = apiService.submitGameResults(result)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    Log.v(TAG, "Successfully submitted result");
                    view.showRefreshLoaderOnEndGame(false);
                }, error -> {
                    view.showRefreshLoaderOnEndGame(true);
                    Log.e(TAG, "Error in submit game result", error);
                    error.printStackTrace();
                });
    }

    private Observable<QuestionForUser> getQuestionForUser(String userId) {
        final Observable<QuestionForUser> output = apiService.getQuestionForUser(userId).flatMapIterable(r -> r);
        return output;
    }
}
