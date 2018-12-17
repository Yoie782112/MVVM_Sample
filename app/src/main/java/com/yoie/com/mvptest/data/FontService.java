package com.yoie.com.mvptest.data;

import com.yoie.com.mvptest.model.Font;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface FontService {
    @GET("webfonts?key=AIzaSyBbfap0P27GphwHMWB9OHSYXG_wnrAAklo")
    Observable<Font> fetchFont();

}
