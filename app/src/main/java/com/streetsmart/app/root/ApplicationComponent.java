package com.streetsmart.app.root;

import com.streetsmart.app.activity.dashboard.DashboardActivity;
import com.streetsmart.app.activity.dashboard.DashboardModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        DashboardModule.class
})
public interface ApplicationComponent {

    void inject(DashboardActivity target);
}
