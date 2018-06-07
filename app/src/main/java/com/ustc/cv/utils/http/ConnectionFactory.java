package com.ustc.cv.utils.http;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConnectionFactory {
    //创建Retrofit
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.3.237:5000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static ConnInterface connInterface = retrofit.create(ConnInterface.class);

    public static ConnInterface getConnection(){
        return connInterface;
    }
}
