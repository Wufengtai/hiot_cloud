package com.huatec.hiot_cloud.Test.MvpTest.RXJAVA;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.huatec.hiot_cloud.R;
import com.huatec.hiot_cloud.Test.MvpTest.Gson.GsonActivity;
import com.huatec.hiot_cloud.Test.MvpTest.Gson.ResultBase;
import com.huatec.hiot_cloud.Test.MvpTest.Gson.loginResultDto;
import com.huatec.hiot_cloud.Test.MvpTest.textInternettwo.UserBean;
import com.huatec.hiot_cloud.Test.MvpTest.textInternettwo.interenttwo;
import com.huatec.hiot_cloud.UI.MainActivity;
import com.huatec.hiot_cloud.data.NetService;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RxJavaActivity extends AppCompatActivity {
    private static final String TAG = "RxJavaActivity";
    private Retrofit retrofit;
    private NetService service;
    private EditText rxtoken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);
        Button but5 = findViewById(R.id.Rx_but5);
        but5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RxJavaActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        //创建Retrofit和internettwo对象
        createRetrofit();
        //登录
        Button but1 = findViewById(R.id.RX_but1);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login("wufengtai", "wft123456");
            }
        });
        //用户信息
        Button but2 = findViewById(R.id.RX_but3);
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUsername(rxtoken.getText().toString());
            }
        });
        //用户token
        rxtoken = findViewById(R.id.RX_but2);

        //修改邮箱
        Button but3 = findViewById(R.id.RX_but4);
        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email("1440807980@qq.com", rxtoken.getText().toString());
            }
        });
        //修改密码
        Button but6 = findViewById(R.id.RX_but6);
        but6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password("wft147258", "wft123456", "wft147258", rxtoken.getText().toString());
            }
        });
    }

    private void password(String newpassword, String oldpassword, String confirmpassword, String authorization) {

        Observable<ResultBase<String>> observable = service.password(newpassword, oldpassword, confirmpassword, authorization);
        observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ResultBase<String>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResultBase<String> resultBase) {
                        if (resultBase != null && resultBase.getData() != null) {
                            String str = String.format("用户：%s,email：%s", resultBase.getData(), resultBase.getData());

                            Toast.makeText(RxJavaActivity.this, str, Toast.LENGTH_SHORT).show();

                        } else if (resultBase != null && !TextUtils.isEmpty(resultBase.getMsg())) {
                            Toast.makeText(RxJavaActivity.this, resultBase.getMsg(), Toast.LENGTH_SHORT).show();

                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError:" + e.getMessage(), e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void email(String newemail, String authorization) {
        Observable<ResultBase<String>> observable = service.email(newemail, authorization);
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResultBase<String>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResultBase<String> resultBase) {
                        if (resultBase != null && resultBase.getData() != null) {
                            String str = String.format("用户：%s,email：%s", resultBase.getData(), resultBase.getData());

                            Toast.makeText(RxJavaActivity.this, str, Toast.LENGTH_SHORT).show();

                        } else if (resultBase != null && !TextUtils.isEmpty(resultBase.getMsg())) {
                            Toast.makeText(RxJavaActivity.this, resultBase.getMsg(), Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError:" + e.getMessage(), e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void getUsername(String authorization) {
        Observable<ResultBase<UserBean>> observable = service.username(authorization);
        observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ResultBase<UserBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResultBase<UserBean> resultBase) {
                        if (resultBase != null && resultBase.getData() != null) {
                            String str = String.format("用户：%s,email：%s", resultBase.getData().getUsername(),
                                    resultBase.getData().getEmail());
                            Toast.makeText(RxJavaActivity.this, str, Toast.LENGTH_SHORT).show();
                        } else if (resultBase != null && !TextUtils.isEmpty(resultBase.getMsg())) {
                            Toast.makeText(RxJavaActivity.this, resultBase.getMsg(), Toast.LENGTH_SHORT).show();

                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError:" + e.getMessage(), e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void login(String Username, String Password) {
        service.login(Username, Password, "app")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResultBase<loginResultDto>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResultBase<loginResultDto> resultBase) {
                        if (resultBase != null && resultBase.getData() != null) {
                            loginResultDto loginResultDto = resultBase.getData();
                            Log.d(TAG, "onNext:" + loginResultDto.getTokenValue());
                            rxtoken.setText(loginResultDto.getTokenValue());
                        } else if (resultBase != null && !TextUtils.isEmpty(resultBase.getMsg())) {
                            Toast.makeText(RxJavaActivity.this, resultBase.getMsg(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError:" + e.getMessage(), e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    /*
     * 创建retrofit
     * */
    private void createRetrofit() {
        retrofit = new Retrofit.Builder().baseUrl(interenttwo.basurl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        service = retrofit.create(NetService.class);
    }
}
