package com.huatec.hiot_cloud.base;

import android.app.Application;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.huatec.hiot_cloud.App;
import com.huatec.hiot_cloud.injection.Component.ActivityComponent;
import com.huatec.hiot_cloud.injection.Component.ApplicationComponent;
import com.huatec.hiot_cloud.injection.Component.DaggerActivityComponent;
import com.huatec.hiot_cloud.injection.module.ActivityModule;

/*
* 基类的Activity
* */
//V对应baseView
public abstract class EaesActivity<V extends baseView , P extends BasePresenter > extends AppCompatActivity implements baseView {
    private P presenter;
    /*
    * 活动注入器
    * */
    private ActivityComponent mActivityComponent;
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


    public ActivityComponent getActivityComponent() {
        if (null == mActivityComponent) {
            mActivityComponent = DaggerActivityComponent.builder()
                    .activityModule(getActivityModule())
                    .applicationComponent(getApplicationComponent())
                    .build();
        }
        return mActivityComponent;
    }

    public ApplicationComponent getApplicationComponent() {

        Application application = getApplication();
        App app = (App) application;
        return app.component();
    }

    /**
     * Get an Activity module for dependency injection.
     */
    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}
