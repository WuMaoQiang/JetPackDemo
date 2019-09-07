package com.jetpack.livedata.request;

import com.jetpack.livedata.bean.User;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * description ： TODO:
 * author : wilfried
 * email : p_maoqwu@tencent.com
 * date : 2019/8/3 16:54
 * author : wilfried
 */
public interface Request {
    @GET(value = "banner/json")
    Observable<User> getBanner();
}
