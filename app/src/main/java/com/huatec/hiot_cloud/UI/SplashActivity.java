package com.huatec.hiot_cloud.UI;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.widget.ImageView;

import com.huatec.hiot_cloud.R;
import com.huatec.hiot_cloud.UI.Login.LoginActivity;
import com.huatec.hiot_cloud.UI.base.BasePresenter;
import com.huatec.hiot_cloud.UI.base.EaesActivity;
import com.huatec.hiot_cloud.data.SharedPreferencesHelper;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

import javax.inject.Inject;

public class SplashActivity extends EaesActivity {
    private static  final  int HANDLER_MSG_OPEN_NEW = 1;
    @Inject
    SharedPreferencesHelper sharedPreferencesHelper;
private Handler handler = new Handler(){
    @Override
    public void handleMessage(@NonNull Message msg) {
        super.handleMessage(msg);
        //如果以登录，跳转页面
        Intent intent=null;
        if (msg.what == HANDLER_MSG_OPEN_NEW){

            if(!TextUtils.isEmpty(sharedPreferencesHelper.getUserToken())) {
                 intent = new Intent(SplashActivity.this, MainActivity.class);
            }else {
                 intent = new Intent(SplashActivity.this, LoginActivity.class);
            }
            //如果未登录，跳转登录界面
            startActivity(intent);
            finish();
        }

    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(HANDLER_MSG_OPEN_NEW);

            }
        },3000);


    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void injectIndependies() {
        getActivityComponent().inject(this);
    }
}
