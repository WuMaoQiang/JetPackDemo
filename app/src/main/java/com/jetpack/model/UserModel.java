package com.jetpack.model;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.jetpack.bean.User;
import com.jetpack.request.Request;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * description ： TODO:Model 数据请求
 * author : wilfried
 * email : p_maoqwu@tencent.com
 * date : 2019/8/3 16:48
 */
public class UserModel {
    //
    private static Request request = null;
    private static Retrofit retrofit;

    public UserModel() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.wanandroid.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        request = retrofit.create(Request.class);

    }

    public static Observable getInfo() {
        Observable<User> observable = request.getBanner().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());
        return observable;
    }


}
