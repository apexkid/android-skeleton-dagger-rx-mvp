package com.streetsmart.app.activity.dashboard;

import dagger.Module;
import dagger.Provides;

@Module
public class DashboardModule {

    @Provides
    public DashboardMVP.Presenter providePresenter() {
        return new DashboardPresenter();
    }

}
