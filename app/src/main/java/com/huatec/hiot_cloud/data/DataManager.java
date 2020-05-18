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
    @Inject
    public  DataManager(NetService service){
    this.service = service;

}

   public Observable<ResultBase<loginResultDto>> login(String username, String password)
    {
       return service.login(username,password, Contans.LOGIN_CODE_APP);

    }

    public Observable<ResultBase<UserBean>> username(String authorization )
    {
        return service.username(authorization);
    }

    public Observable<ResultBase<String>> email(String email, String authorization )
    {
        return  service.email(email,authorization);
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

    public Observable<ResultBase<String>> password(String newpassword,String oldpassword,String confirmpassword, String authorization )
    {
        return service.password(newpassword,oldpassword,confirmpassword,authorization);
    }


}
