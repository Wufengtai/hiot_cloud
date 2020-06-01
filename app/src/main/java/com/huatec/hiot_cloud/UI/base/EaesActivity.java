package com.huatec.hiot_cloud.UI.base;

import android.app.Application;
import android.os.Bundle;
import android.widget.Toast;

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
public abstract class EaesActivity<V extends baseView , P extends BasePresenter<V> > extends AppCompatActivity implements baseView {
    private P presenter;
    /*
    * 活动注入器
    * */
    private ActivityComponent mActivityComponent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectIndependies();
        presenter = createPresenter();
        if (presenter !=null) {
            presenter.setView((V) this);
        }
    }

    //抽象类
    public abstract P createPresenter();
    public abstract void injectIndependies();
  //重写onDestroy方法
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.destroy();
        }
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

    @Override
    public void showManager(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
