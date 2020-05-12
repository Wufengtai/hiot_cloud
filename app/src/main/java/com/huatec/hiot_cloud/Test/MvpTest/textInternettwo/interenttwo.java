package com.huatec.hiot_cloud.Test.MvpTest.textInternettwo;

import com.huatec.hiot_cloud.Test.MvpTest.Gson.ResultBase;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

/*
* two..service接口
* */
public interface interenttwo {
   public static final String baiduurl="http://163.177.151.109";
    public static final String basurl="http://114.67.88.191:8080";
@GET("/")
    Call<ResponseBody> test();
@POST("/auth/login")
Call<ResponseBody> login(@Query("username")String username,
                         @Query("password")String password,@Query("loginCode")String loginCode);

@GET("/user/one")
Call<ResultBase<UserBean>> username2(@Header("Authorization")String authorization );
@GET("/user/one")
    Call<ResponseBody> username(@Header("Authorization")String authorization );
@PUT("/user/email")
Call<ResponseBody> email(@Query("email")String email,@Header("Authorization") String authorization );
@POST("/user/register")
Call<ResponseBody> zhuce(@Body UserBean userBean);
}
