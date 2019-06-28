package com.apps.myapplication.data.source.remote

import com.apps.myapplication.data.source.remote.response.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiInterfaces {

    @GET("v2/top-headlines/")
    fun doGetIndoNews(@Query("country") country : String,
                      @Query("apiKey") apiKey : String): Call<NewsResponse>

    @GET("v2/top-headlines/")
    fun doGetIndoNewsWithCategory(@Query("country") country : String,
                      @Query("apiKey") apiKey : String, @Query("category") category : String): Call<NewsResponse>

    @GET("v2/top-everything/")
    fun doGetEverything(@Query("apiKey") apiKey : String, @Query("q") q : String): Call<NewsResponse>

}