package com.jetpack;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.jetpack.bean.User;
import com.jetpack.viewmodel.UserViewModel;

public class MainActivity extends AppCompatActivity {

    private UserViewModel userViewModel;
    MutableLiveData<User> userMutableLiveData;
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Log.i("xiaoqiang", "onCreate: " + BuildConfig.VENDER);
        userViewModel = UserViewModel.getInstance();
        userMutableLiveData = userViewModel.getUserMutableLiveData();

        userMutableLiveData.observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                mTv.setText(user.getData().get(0).getDesc());
            }
        });
    }

    public void testClick(View view) {

        userViewModel.loadInfo();
    }


    private void initView() {
        mTv = (TextView) findViewById(R.id.tv);
    }
}
