package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;

public interface ApiInterface {
@GET("v2/5a8e5b372f000048004f25fc")
Call<List<PostPojo>> getposts();
}
