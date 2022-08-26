package com.example.myapplication;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static Retrofit retrofit;
    private static final String baseurl="https://www.mocky.io/";

    public static Retrofit getRetrofit() {
        if(retrofit==null){
            retrofit=new Retrofit.Builder().
                    baseUrl(baseurl).
                    addConverterFactory(GsonConverterFactory.create()).
                    build();
        }
        return retrofit;
    }
}
