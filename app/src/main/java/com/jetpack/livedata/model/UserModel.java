package com.jetpack.livedata.model;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.jetpack.livedata.bean.User;
import com.jetpack.livedata.request.Request;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * description ： TODO:Model 数据请求
 * author : wilfried
 * email : maoqwu@tencent.com
 * date : 2019/8/3 16:48
 */
public class UserModel {
    //
    private static Request mRequest = null;
    private static Retrofit mRetrofit;
    private static Observable<User> mObservable;
    private static UserModel mUserModel;

    public static UserModel getInstance() {
        if (mUserModel == null) {
            synchronized (UserModel.class) {
                if (mUserModel == null) {
                    mUserModel = new UserModel();
                }
            }
        }
        return mUserModel;
    }

    public UserModel() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://www.wanandroid.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mRequest = mRetrofit.create(Request.class);

    }

    public Observable getInfo() {
        mObservable = mRequest.getBanner().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());
        return mObservable;
    }
}
