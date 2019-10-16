package com.streetsmart.app.activity.play;

import com.streetsmart.app.data.AnswerRecord;

public interface PlayFragmentFlow {
    void startGame();
    void cancelGame();
    void onAnswerSelect(AnswerRecord answer);
    int getScoreForGameSessions();
}
