package com.streetsmart.app.activity.play;

import java.util.Set;

public interface PlayFragmentFlow {
    void onAnswerSelect(Set<String> selectedAnswer);
    void startGame();
    void cancelGame();
}
