package com.streetsmart.app.activity.play;

import com.streetsmart.app.activity.api.APIService;

import dagger.Module;
import dagger.Provides;
import lombok.NonNull;

@Module
public class PlayModule {

    @Provides
    public PlayMVP.Presenter providePresenter(@NonNull APIService apiService) {
        return new PlayPresenter(apiService);
    }
}
