package com.apps.myapplication.data.source.remote

import com.apps.myapplication.utils.ConstantUtils
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {

    companion object {
        fun getClient() : Retrofit {
            val mLoggingInterceptor = HttpLoggingInterceptor()
            mLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            val mClient = OkHttpClient.Builder()
                .addInterceptor(mLoggingInterceptor)
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build()

            val mRetrofit = Retrofit.Builder()
                .baseUrl(ConstantUtils.BASE_URL())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(mClient) //Todo comment if app release
                .build()
            return mRetrofit
        }
    }

}