package com.jetpack.livedata.viewmodel;

import android.annotation.SuppressLint;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.jetpack.livedata.bean.User;
import com.jetpack.livedata.model.UserModel;

import io.reactivex.functions.Consumer;

/**
 * description ： TODO:
 * author : wilfried
 * email : p_maoqwu@tencent.com
 * date : 2019/8/3 16:01
 */
public class UserViewModel extends ViewModel {
    private static UserViewModel mUserViewModel;
    MutableLiveData<User> mUserMutableLiveData;

    public static UserViewModel getInstance() {
        if (mUserViewModel == null) {
            synchronized (ViewModel.class) {
                if (mUserViewModel == null) {
                    mUserViewModel = new UserViewModel();
                }
            }
        }
        return mUserViewModel;
    }


    public MutableLiveData<User> getUserMutableLiveData() {
        if (mUserMutableLiveData == null) {
            mUserMutableLiveData = new MutableLiveData<>();
        }
        return mUserMutableLiveData;
    }

    public void setUsetableLiveData(User user) {
        if (mUserMutableLiveData == null) {
            mUserMutableLiveData = new MutableLiveData<>();
        }
        mUserMutableLiveData.postValue(user);
    }

    @SuppressLint("CheckResult")
    public void loadInfo() {

        UserModel.getInstance().getInfo().subscribe((Consumer<User>) user -> setUsetableLiveData(user));

    }


}
