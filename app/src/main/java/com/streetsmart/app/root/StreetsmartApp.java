package com.streetsmart.app.root;

import android.app.Application;
import android.content.Context;

import com.streetsmart.app.activity.dashboard.DashboardModule;
import com.streetsmart.app.activity.play.PlayModule;

import lombok.Getter;

public class StreetsmartApp extends Application {

    @Getter
    private ApplicationComponent applicationComponent;

    @Getter
    private static Context context;


    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .dashboardModule(new DashboardModule())
                .playModule(new PlayModule())
                .build();

        if (context == null) {
            context = getApplicationContext();
        }
    }
}
