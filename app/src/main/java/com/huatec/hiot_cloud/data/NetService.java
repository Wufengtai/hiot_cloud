package com.huatec.hiot_cloud.data;

import android.media.MediaRouter;

import com.huatec.hiot_cloud.Test.MvpTest.Gson.ResultBase;
import com.huatec.hiot_cloud.Test.MvpTest.Gson.loginResultDto;
import com.huatec.hiot_cloud.Test.MvpTest.textInternettwo.UserBean;


import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

/*
* 网络请求接口
* */
public interface NetService {
    public static final String basurl="http://114.67.88.191:8080";
    @POST("/auth/login")
    Observable<ResultBase<loginResultDto>> login(@Query("username")String username,
                                                 @Query("password")String password, @Query("loginCode")String loginCode);
    @GET("/user/one")
    Observable<ResultBase<UserBean>> username(@Header("Authorization")String authorization );
    @PUT("/user/email")
    Observable<ResultBase<String>> email(@Query("email")String email,@Header("Authorization") String authorization );
    @POST("/user/register")
    Observable<ResultBase<UserBean>> zhuce(@Body UserBean userBean);
    @PUT("/user/password")
    Observable<ResultBase<String>> password(@Query("newpassword")String newpassword,@Query("oldpassword")String oldpassword,@Query("confirmpassword")String confirmpassword,
                                            @Header("Authorization") String authorization );

}
