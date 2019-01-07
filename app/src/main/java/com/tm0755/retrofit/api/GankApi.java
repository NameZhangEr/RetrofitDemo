package com.tm0755.retrofit.api;

import com.tm0755.retrofit.GankBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface GankApi {
    //    @GET("api/data/Android/10/1")
//    Call<GankBean> getAndroidInfo();
    @GET("api/data/Android/10/1")
    rx.Observable<GankBean> getAndroidInfo();

    @POST("api/data/Android/10/1")
    rx.Observable<GankBean> getUserInfo();
}
