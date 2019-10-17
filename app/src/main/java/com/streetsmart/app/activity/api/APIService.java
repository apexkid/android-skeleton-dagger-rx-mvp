package com.streetsmart.app.activity.api;

import com.streetsmart.app.data.api.GameResultPOSTBody;
import com.streetsmart.app.data.api.QuestionForUser;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface APIService {

    @GET("getquestionsforuser")
    Observable<List<QuestionForUser>> getQuestionForUser(@Query("userid") String userId);

    @PUT("postresults")
    Completable submitGameResults(@Body GameResultPOSTBody result);
}
