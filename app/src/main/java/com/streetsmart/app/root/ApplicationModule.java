package com.streetsmart.app.root;

import android.app.Application;
import android.content.Context;

import com.streetsmart.app.modules.RetrofitHelper;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return application;
    }

    @Provides
    @Named("okHttpAuthenticated")
    @Singleton
    public OkHttpClient provideAuthenticatedClient() {
        return RetrofitHelper.getUnauthenticatedDefaultClientBuilder().build();
    }
}
