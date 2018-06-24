package com.ustc.cv.utils.http;

import com.ustc.cv.model.FilterOptions;
import com.ustc.cv.model.http.ResultBase;
import com.ustc.cv.model.http.ResultGetProperties;
import com.ustc.cv.model.http.ResultPostProperties;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ConnInterface {
    @GET("getProperties")
    Call<ResultGetProperties> getProperties();

    @GET("getProperties")
    Call<ResultBase> test();

    @POST("postProperties")
    Call<ResultPostProperties> postProperties(@Body FilterOptions filterOptions);
}
