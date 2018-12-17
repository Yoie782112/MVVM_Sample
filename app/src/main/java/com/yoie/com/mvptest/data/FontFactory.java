package com.yoie.com.mvptest.data;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.yoie.com.mvptest.R;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FontFactory {
    public final static String BASE_URL = "https://www.googleapis.com/webfonts/v1/";


    public static FontService create() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(FontService.class);
    }
}
