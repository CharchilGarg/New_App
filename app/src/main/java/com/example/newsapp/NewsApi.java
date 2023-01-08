package com.example.newsapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {

    @GET("top-headlines")
    Call<NewsSource>getNewsFromResource(@Query("country") String country,
                                           @Query("category") String category,
                                           @Query("apiKey") String apiKey);

}
