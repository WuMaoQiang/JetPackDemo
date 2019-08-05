package com.jetpack.viewmodel;

import android.annotation.SuppressLint;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.jetpack.bean.User;
import com.jetpack.model.UserModel;

import io.reactivex.functions.Consumer;

/**
 * description ： TODO:
 * author : wilfried
 * email : p_maoqwu@tencent.com
 * date : 2019/8/3 16:01
 */
public class UserViewModel extends ViewModel {
    private static UserViewModel userViewModel;
    MutableLiveData<User> userMutableLiveData = new MutableLiveData<>();

    public static UserViewModel getInstance() {
        if (userViewModel == null) {
            synchronized (ViewModel.class) {
                if (userViewModel == null) {
                    userViewModel = new UserViewModel();
                }
            }
        }
        return userViewModel;
    }


    public MutableLiveData<User> getUserMutableLiveData() {
        return userMutableLiveData;
    }

    @SuppressLint("CheckResult")
    public void loadInfo() {

        UserModel.getInfo().subscribe(new Consumer<User>() {
            @Override
            public void accept(User user) throws Exception {
                setUsetableLiveData(user);
            }
        });

    }

    public void setUsetableLiveData(User user) {
        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        userMutableLiveData.postValue(user);
    }
}
