package com.streetsmart.app.activity.play;

import dagger.Module;
import dagger.Provides;

@Module
public class PlayModule {

    @Provides
    public PlayMVP.Presenter providePresenter() {
        return new PlayPresenter();
    }
}
