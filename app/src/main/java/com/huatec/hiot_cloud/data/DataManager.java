package com.huatec.hiot_cloud.data;

import com.huatec.hiot_cloud.Test.MvpTest.Gson.ResultBase;
import com.huatec.hiot_cloud.Test.MvpTest.Gson.loginResultDto;
import com.huatec.hiot_cloud.Test.MvpTest.textInternettwo.UserBean;
import com.huatec.hiot_cloud.utils.Contans;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

/*
* 网络请求封装类
* */
public class DataManager {
private NetService service;
//获取token
private SharedPreferencesHelper sharedPreferencesHelper;
    @Inject
    public  DataManager(NetService service,SharedPreferencesHelper sharedPreferencesHelper){
    this.service = service;
    this.sharedPreferencesHelper=sharedPreferencesHelper;

}

   public Observable<ResultBase<loginResultDto>> login(String username, String password)
    {
       return service.login(username,password, Contans.LOGIN_CODE_APP).doOnNext(new Consumer<ResultBase<loginResultDto>>() {
           @Override
           public void accept(ResultBase<loginResultDto> resultBase) throws Exception {
               if (resultBase.getStatus() == 1) {
                   if (resultBase != null && resultBase.getData() != null) {
                       sharedPreferencesHelper.setUserToken(resultBase.getData().getTokenValue());
                   }
               }
           }
       });

    }

    public Observable<ResultBase<UserBean>> username( )
    {
        return service.username(sharedPreferencesHelper.getUserToken());
    }

    public Observable<ResultBase<String>> email(String email)
    {
        return  service.email(email,sharedPreferencesHelper.getUserToken());
    }

    public  Observable<ResultBase<UserBean>> zhuce(String userName,String password,String email)
    {
        UserBean userBean = new UserBean();
        userBean.setUsername(userName);
        userBean.setPassword(password);
        userBean.setEmail(email);
        userBean.setUserType(Contans.REGISTYPE_CODE_NORMAL);
       return service.zhuce(userBean);
    }

    public Observable<ResultBase<String>> password(String newpassword,String oldpassword,String confirmpassword)
    {
        return service.password(newpassword,oldpassword,confirmpassword,sharedPreferencesHelper.getUserToken());
    }


}
