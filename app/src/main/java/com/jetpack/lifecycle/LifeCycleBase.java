package com.jetpack.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

/**
 * description ：
 * author : wilfried
 * email : p_maoqwu@tencent.com
 * date : 2019/9/7 15:06
 */
public abstract class LifeCycleBase implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public abstract void BindOnCreat();

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public abstract void BindOnResume();

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public abstract void BindOnPause();
}
