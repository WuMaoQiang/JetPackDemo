package com.jetpack;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.jetpack.lifecycle.LifeCycleBase;
import com.jetpack.lifecycle.LifeCycleSpecific;
import com.jetpack.lifecycle.LifeCycleSpecific2;
import com.jetpack.livedata.viewmodel.UserViewModel;

public class MainActivity extends AppCompatActivity {

    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        testLifeCycle();
        UserViewModel.getInstance().getUserMutableLiveData().observe(this, user ->
                mTv.setText(user.getData().get(0).getDesc()));
    }

    private void initView() {
        mTv = findViewById(R.id.tv);
        mTv.setOnClickListener(view -> UserViewModel.getInstance().loadInfo());

    }

    private void testLifeCycle() {
        LifeCycleBase lifeCycleSpecific = new LifeCycleSpecific();
        LifeCycleBase lifeCycleSpecific2 = new LifeCycleSpecific2();
        getLifecycle().addObserver(lifeCycleSpecific);
        getLifecycle().addObserver(lifeCycleSpecific2);
    }
}
