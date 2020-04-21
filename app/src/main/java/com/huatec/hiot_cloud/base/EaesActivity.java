package com.huatec.hiot_cloud.base;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/*
* 基类的Activity
* */
//V对应baseView
public abstract class EaesActivity<V extends baseView , P extends BasePresenter > extends AppCompatActivity implements baseView {
    private P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        presenter.setView(this);
    }

    //抽象类
    public abstract P createPresenter();
  //重写onDestroy方法
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destroy();

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
