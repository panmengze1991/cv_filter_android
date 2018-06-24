package com.ustc.cv.utils.http;

import android.util.Log;
import com.google.gson.Gson;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ConnectionFactory {
//    private static final String BASE_URL = "http://192.168.209.1:5000/";
//
//    private static OkHttpClient getOkHttpClient() {
//        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
//        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        //定制OkHttp
//        OkHttpClient.Builder builder = new OkHttpClient.Builder()
//                .connectTimeout(5, TimeUnit.MINUTES)
//                .readTimeout(5, TimeUnit.MINUTES)
//                .writeTimeout(5, TimeUnit.MINUTES)
//                .addInterceptor(loggingInterceptor);
//        return builder.build();
//    }
//
//    //创建Retrofit
//    private static Retrofit retrofit = new Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .client(getOkHttpClient())
//            .addConverterFactory(GsonConverterFactory.create())
//            .build();

    public static ConnInterface getConnection(Retrofit retrofit) {
        return retrofit.create(ConnInterface.class);
    }
}
