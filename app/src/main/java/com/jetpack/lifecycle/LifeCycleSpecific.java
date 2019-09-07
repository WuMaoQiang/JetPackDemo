package com.jetpack.lifecycle;

import android.util.Log;

/**
 * description ：
 * author : wilfried
 * email : p_maoqwu@tencent.com
 * date : 2019/9/7 15:10
 */
public class LifeCycleSpecific extends LifeCycleBase {
    private static final String TAG = "LifeCycle";

    @Override
    public void BindOnCreat() {
        Log.i(TAG, " Specific BindOnCreat: ");
    }

    @Override
    public void BindOnResume() {
        Log.i(TAG, "Specific BindOnResume: ");
    }

    @Override
    public void BindOnPause() {
        Log.i(TAG, "Specific BindOnPause: ");
    }
}
