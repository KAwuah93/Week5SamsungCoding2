package com.example.week5samsungcoding.model.datasource.remote.retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {

    public static Retrofit getRetrofitInstance(){

        //Creating and returning the Retrofit
        return new Retrofit.Builder()
                .baseUrl(CONSTANTS.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static AlbumResponseService getService(){
        return getRetrofitInstance().create(AlbumResponseService.class);
    }

}

