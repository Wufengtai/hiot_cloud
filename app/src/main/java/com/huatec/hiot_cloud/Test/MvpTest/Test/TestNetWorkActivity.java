package com.huatec.hiot_cloud.Test.MvpTest.Test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.huatec.hiot_cloud.R;
import com.huatec.hiot_cloud.Test.MvpTest.Gson.ResultBase;
import com.huatec.hiot_cloud.Test.MvpTest.Gson.loginResultDto;
import com.huatec.hiot_cloud.Test.MvpTest.RXJAVA.RxJavaActivity;
import com.huatec.hiot_cloud.Test.MvpTest.textInternet.TextInterentActivity;
import com.huatec.hiot_cloud.Test.MvpTest.textInternettwo.UserBean;
import com.huatec.hiot_cloud.Test.MvpTest.textInternettwo.interenttwo;
import com.huatec.hiot_cloud.UI.MainActivity;
import com.huatec.hiot_cloud.UI.base.BasePresenter;
import com.huatec.hiot_cloud.UI.base.EaesActivity;
import com.huatec.hiot_cloud.data.DataManager;
import com.huatec.hiot_cloud.data.NetService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/*
* 网络框架测试
* */
public class TestNetWorkActivity extends EaesActivity implements  TestNetworkPaceView{
    private static final String TAG = "RxJavaActivity";
    private EditText rxtoken;
    @Inject
    DataManager dataManager;

    @Inject
    TestnetworkPresenter testnetworkPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_net_work);
        Button but5 = findViewById(R.id.net_but5);
        but5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestNetWorkActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
  
        //登录
        Button but1 = findViewById(R.id.net_but1);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testnetworkPresenter.login("wufengtai", "wft147258");
               // login("wufengtai", "wft147258");
            }
        });
        //用户信息
        Button but2 = findViewById(R.id.net_but3);
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            testnetworkPresenter.username(rxtoken.getText().toString());
            }
        });
        //用户token
        rxtoken = findViewById(R.id.net_but2);

        //修改邮箱
        Button but3 = findViewById(R.id.net_but4);
        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
         testnetworkPresenter.email("1440807980@qq.com", rxtoken.getText().toString());
            }
        });
        //修改密码
        Button but6 = findViewById(R.id.net_but6);
        but6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               testnetworkPresenter.password("wft147258", "wft123456", "wft147258", rxtoken.getText().toString());
            }
        });
    }

    @Override
    public BasePresenter createPresenter() {
        return testnetworkPresenter;
    }

    @Override
    public void injectIndependies() {
        getActivityComponent().inject(this);
    }

    private void login(String username, String password) {

        /*dataManager.login(username,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<ResultBase<loginResultDto>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResultBase<loginResultDto> resultBase) {
                       if(resultBase != null && resultBase.getData()!= null) {
                           rxtoken.setText(resultBase.getData().getTokenValue());
                       }else if(resultBase != null && resultBase.getMsg() != null){
                           Toast.makeText(TestNetWorkActivity.this, resultBase.getMsg(), Toast.LENGTH_SHORT).show();
                       }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });*/
    }


    @Override
    public void showToken(String token) {
        rxtoken.setText(token);
    }

    @Override
    public void showManager(String manager) {
        Toast.makeText(this, manager, Toast.LENGTH_SHORT).show();
    }
}

