package com.example.asus.mvp.model.network;

import com.example.asus.mvp.config.Urls;
import com.example.asus.mvp.model.biz.HomeService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {
    private static RetrofitUtils retrofitUtils;
    private HttpLoggingInterceptor loggingInterceptor;
    private OkHttpClient okHttpClient;
    private final Retrofit retrofit;

    public RetrofitUtils() {
        loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(loggingInterceptor)
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(Urls.NEWSURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    public static RetrofitUtils getInstance(){
        if(retrofitUtils == null){
            synchronized (RetrofitUtils.class){
                if (retrofitUtils == null)
                    retrofitUtils = new RetrofitUtils();
            }
        }
        return retrofitUtils;
    }
    public HomeService getHomeService(){
        return retrofit.create(HomeService.class);
    }
}
