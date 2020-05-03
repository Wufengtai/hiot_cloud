package com.huatec.hiot_cloud.Test.MvpTest.textInternet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.huatec.hiot_cloud.R;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TextInterentActivity extends AppCompatActivity {
 private static final String HttpUal="http://114.67.88.191:8080";
    private static final String TAG = "TextInterentActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_interent);
        Button button = findViewById(R.id.but_ton1);
        Button button1 = findViewById(R.id.but_ton2);
        Button login = findViewById(R.id.login);
        Button username = findViewById(R.id.password);
        Button email = findViewById(R.id.email);
        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                testExerute();
            }

        });
        /*
        * 第二种方法
        * */
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textEnquene();
            }


        });
        /*
        * 测试登录
        * */
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Login("1440807980","wft147258","app");
            }
        });

        /*
        * 获取用户信息
        * */
        username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetUserInfo("1d0c78a1c22a4086974e68eee5709cdd_642d30f6a24e49c8aa4c847745591627_use");
            }
        });
        /*
        * 修改邮箱
        * */
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateEmail("wft@qq.com","1d0c78a1c22a4086974e68eee5709cdd_642d30f6a24e49c8aa4c847745591627_use");
            }
        });
    }

    private void UpdateEmail(String NewEmail, String authorization) {
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody body = new FormBody.Builder().build();
        String url =HttpUal + "/user/email?email="+NewEmail;
        Request request = new Request.Builder().put(body).url(url).header("Authorization",authorization).build();
        Callback(okHttpClient, request);

    }

    private void Callback(OkHttpClient okHttpClient, Request request) {
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
                Log.e(TAG, "onFailure" + e.getMessage(), e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Log.d(TAG, "onResponse" + response.body().string());
            }
        });
    }

    /*
* 获取用户信息
* */
    private void GetUserInfo(String authorization) {
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody body = new FormBody.Builder().build();
        String url =HttpUal + "/user/one";
        Request request = new Request.Builder().get().url(url).header("Authorization",authorization).build();
        Callback(okHttpClient, request);

    }

    /*
* 登录的内容
* */
    private void Login(String UserName, String password, String loginCode) {
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody body = new FormBody.Builder().build();
        String url =HttpUal + String.format("/auth/login?username=%s&password=%s&loginCode=%s",UserName,password,loginCode);
        Request request = new Request.Builder().post(body).url(url).build();
        Callback(okHttpClient, request);
    }
    /*
* 测试第一种方法的方式（execute）
* */

            private void testExerute() {
                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        OkHttpClient okHttpClient = new OkHttpClient();
                        Request request = new Request.Builder().url(HttpUal).build();
                        try {
                            Response response = okHttpClient.newCall(request).execute();
                             Log.e(TAG,"run" + response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                            Log.e(TAG,"testexecute"+ e.getMessage(),e);
                        }
                    }
                }.start();


    }

/*
* 测试第二种方法
* 异步方法
* */
    private void textEnquene() {



            }
}
