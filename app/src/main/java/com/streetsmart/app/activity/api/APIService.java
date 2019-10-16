package com.streetsmart.app.activity.api;

import com.streetsmart.app.data.api.QuestionForUser;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

    @GET("getquestionsforuser")
    Observable<List<QuestionForUser>> getQuestionForUser(@Query("userId") String userId);
}
