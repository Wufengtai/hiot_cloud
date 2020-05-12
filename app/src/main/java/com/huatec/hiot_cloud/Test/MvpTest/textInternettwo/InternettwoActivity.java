package com.huatec.hiot_cloud.Test.MvpTest.textInternettwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huatec.hiot_cloud.R;
import com.huatec.hiot_cloud.Test.MvpTest.Gson.ResultBase;
import com.huatec.hiot_cloud.Test.MvpTest.Gson.loginResultDto;
import com.huatec.hiot_cloud.Test.MvpTest.textInternet.TextInterentActivity;
import com.huatec.hiot_cloud.UI.MainActivity;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InternettwoActivity extends AppCompatActivity {


    private static final String TAG ="InternettwoActivity";
    private Retrofit retrofit;
    private com.huatec.hiot_cloud.Test.MvpTest.textInternettwo.interenttwo interenttwo;
    private Retrofit retrofit1;
    private com.huatec.hiot_cloud.Test.MvpTest.textInternettwo.interenttwo interenttwo1;
    private EditText etoken;
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internettwo);
        Button button1 = findViewById(R.id.but_baidu);
        Button login1 = findViewById(R.id.login1);
        Button username1 = findViewById(R.id.password1);
        Button email1 = findViewById(R.id.email1);
        Button zhuce = findViewById(R.id.zhuce);
        Button but2 = findViewById(R.id.but_Retrofit1);
        etoken = findViewById(R.id.Edit_but1);
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InternettwoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        //创建Retrofit和internettwo对象
        createRetrofit();
        createRetrofit1();

        //打开百度
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaiDu();
            }
        });
        //登录
        login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login1();
                text = etoken.getText().toString();
            }
        });
        //用户信息
        username1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Username(etoken.getText().toString());

            }
        });
        //修改邮箱
        email1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email1("","");
            }
        });
        //注册
        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zhuce();
            }
        });
    }

    private void zhuce() {
        UserBean userBean = new UserBean();
        userBean.setUsername("wufengtai1");
        userBean.setPassword("wft123456");
        userBean.setEmail("wufengtai@qq.com");
        userBean.setUserType("1");
        Call<ResponseBody> call = interenttwo.zhuce(userBean);
        CallBackGetUserIn(call);

    }

    private void email1(String email,String authorization ) {
        Call<ResponseBody> call = interenttwo.email("1440807980@qq.com","1d0c78a1c22a4086974e68eee5709cdd_bbd34243a741432284d4b53322060411_use");
        CallBackGetUserIn(call);
    }

    private void Username(String authorization) {
        Call<ResponseBody> call = interenttwo.username(etoken.getText().toString());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Gson gson = new Gson();
                    Type type = new TypeToken<ResultBase<UserBean>>(){}.getType();
                    ResultBase<UserBean> resultBase = gson.fromJson(response.body().string(),type);
                    if(resultBase != null && resultBase.getData() != null) {
                        String str = String.format("用户名：%s,密码：%s,email:%s,用户类型:%s",
                                resultBase.getData().getUsername(),  resultBase.getData().getPassword(),  resultBase.getData().getEmail(),  resultBase.getData().getUserType());
                        Toast.makeText(InternettwoActivity.this, str, Toast.LENGTH_SHORT).show();
                    }

                    if (resultBase != null && resultBase.getMsg() != null){
                        String str = String.format("用户名：%s,密码：%s,email:%s,用户类型:%s",
                                resultBase.getData().getUsername(),  resultBase.getData().getPassword(),  resultBase.getData().getEmail(),  resultBase.getData().getUserType());
                        Toast.makeText(InternettwoActivity.this, str, Toast.LENGTH_SHORT).show();
                    }
                } catch (IOException e) {
                    Log.e(TAG, "onResponse" + e.getMessage(), e);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
              Log.e(TAG, "onFailure" + t.getMessage(), t);
            }
        });
       //内部解析
/*    Call<ResultBase<UserBean>> call =  interenttwo.username2(authorization);
  call.enqueue(new Callback<ResultBase<UserBean>>() {
      @Override
      public void onResponse(Call<ResultBase<UserBean>> call, Response<ResultBase<UserBean>> response) {
         ResultBase<UserBean> resultBase = response.body();
         if (resultBase != null && resultBase.getData() != null){
             resultBase.getData();
             String str = resultBase.getData().getUsername()+","+resultBase.getData().getEmail();
             Toast.makeText(InternettwoActivity.this, str, Toast.LENGTH_SHORT).show();
         }
      }

      @Override
      public void onFailure(Call<ResultBase<UserBean>> call, Throwable t) {

      }
  });*/
    }

    private void CallBackGetUserIn(Call<ResponseBody> call) {
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                   Log.d(TAG, "onResponse" + response.body().string());

                } catch (IOException e) {
                   e.printStackTrace();
                   Log.e(TAG, "onResponse" + e.getMessage(), e);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e(TAG, "onFailure" + t.getMessage(), t);
            }
        });
    }


    private void login1() {
        Call<ResponseBody> call = interenttwo.login("wufengtai","wft123456","app");
//        CallBackGetUserIn(call);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                   Gson gson = new Gson();

                       Type type = new TypeToken<ResultBase<loginResultDto>>() {}.getType();
                       ResultBase<loginResultDto> loginresult= gson.fromJson(response.body().string(), type);
                    if ( loginresult != null && loginresult.getData() != null) {
                      String token = loginresult.getData().getTokenValue();
                        etoken.setText(token);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e(TAG, "onResponse" + e.getMessage(), e);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void BaiDu() {
       Call<ResponseBody> call =  interenttwo1.test();
        CallBackGetUserIn(call);
    }

    private void createRetrofit(){
        retrofit = new  Retrofit.Builder().baseUrl(interenttwo.basurl)
                .addConverterFactory(GsonConverterFactory.create()).build();
        interenttwo = retrofit.create(interenttwo.class);
    }
    private void createRetrofit1(){
        retrofit1 = new  Retrofit.Builder().baseUrl(interenttwo.baiduurl)
                  .addConverterFactory(GsonConverterFactory.create()).build();
        interenttwo1 = retrofit1.create(interenttwo.class);
    }

}
