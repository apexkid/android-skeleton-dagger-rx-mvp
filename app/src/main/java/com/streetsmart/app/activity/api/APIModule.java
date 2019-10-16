package com.streetsmart.app.activity.api;

import com.streetsmart.app.modules.RetrofitHelper;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class APIModule {

    private final String BASE_URL = "https://v1qs7l38n4.execute-api.us-east-1.amazonaws.com/prod/";

    @Singleton
    @Provides
    public APIService provideAPIService(@Named("okHttpAuthenticated") OkHttpClient client) {
        return RetrofitHelper.getNewRetrofitInstance(BASE_URL, client).create(APIService.class);
    }

}
