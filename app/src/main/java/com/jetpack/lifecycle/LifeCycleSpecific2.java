package com.jetpack.lifecycle;

import android.util.Log;

/**
 * description ：
 * author : wilfried
 * email : p_maoqwu@tencent.com
 * date : 2019/9/7 15:16
 */
public class LifeCycleSpecific2 extends LifeCycleBase {
    private static final String TAG = "LifeCycle";

    @Override
    public void BindOnCreat() {
        Log.i(TAG, " Specific2 BindOnCreat: ");
    }

    @Override
    public void BindOnResume() {
        Log.i(TAG, "Specific2 BindOnResume: ");
    }

    @Override
    public void BindOnPause() {
        Log.i(TAG, "Specific2 BindOnPause: ");
    }
}

