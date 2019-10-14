package com.streetsmart.app.root;

import com.streetsmart.app.activity.dashboard.DashboardActivity;
import com.streetsmart.app.activity.dashboard.DashboardModule;
import com.streetsmart.app.activity.play.PlayActivity;
import com.streetsmart.app.activity.play.PlayModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        DashboardModule.class,
        PlayModule.class
})
public interface ApplicationComponent {

    void inject(DashboardActivity target);
    void inject(PlayActivity target);
}
