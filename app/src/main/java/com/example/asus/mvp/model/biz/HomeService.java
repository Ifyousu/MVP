package com.example.asus.mvp.model.biz;

import com.example.asus.mvp.config.Urls;
import com.example.asus.mvp.model.entity.NewsBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface HomeService {
    @FormUrlEncoded
    @POST(Urls.NEWS)
    Observable<NewsBean> newsList(@Field("type")String type , @Field("key")String key);
}
