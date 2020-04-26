package com.huatec.hiot_cloud.Test.MvpTest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.huatec.hiot_cloud.R;
import com.huatec.hiot_cloud.Test.MvpTest.modle.User;
import com.huatec.hiot_cloud.UI.base.EaesActivity;

import javax.inject.Inject;

public class MvpTestActivity extends EaesActivity<TestView, TestPresenter> implements TestView{
   /*
   * 调用@inject类
   * */
    @Inject
    TestPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_test);
       final EditText evpassword = findViewById(R.id.ev_passworld);
       final EditText evusername = findViewById(R.id.ev_username);
        Button bin = findViewById(R.id.bin);
        final User user = new User();
        bin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setUserName(evusername.getText().toString());
                user.setPassWorle(evpassword.getText().toString());
                presenter.Login(user);

            }
        });
    }

    @Override
    public void ShowMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    @Override
    public TestPresenter createPresenter() {
        return presenter;
    }

    @Override
    public void injectIndependies() {
        getActivityComponent().inject(this);
    }
    /*
* 创建注入器
* *//*
    public PersenterComponent getComponent(){
        return DaggerPersenterComponent.builder().build();
    }*/
}
