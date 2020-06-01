package com.huatec.hiot_cloud.UI.Login;

import android.widget.Toast;

import com.huatec.hiot_cloud.Test.MvpTest.Gson.ResultBase;
import com.huatec.hiot_cloud.Test.MvpTest.Gson.loginResultDto;
import com.huatec.hiot_cloud.UI.base.BasePresenter;
import com.huatec.hiot_cloud.data.DataManager;

import javax.inject.Inject;

/*
* 登录模块Presenter类
* */
class LoginPresenter extends BasePresenter<LoginView> {
    @Inject
    DataManager dataManager;
   @Inject
    public LoginPresenter() {

    }

    public void login(String email, String password) {
        subscrib(dataManager.login(email, password), new RequestCallback<ResultBase<loginResultDto>>() {
            @Override
            public void onNext(ResultBase<loginResultDto> resultBase) {
                if (resultBase.getStatus() == 1) {

                    if (resultBase != null && resultBase.getData() != null) {
                        //登录成功
                        getView().showManager("登录成功");
                        //跳转到主界面
                        getView().loginSuce();
                    }
                } else{
                    if (resultBase != null && resultBase.getMsg() != null) {
                        getView().showManager(resultBase.getMsg());
                }
                }

            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                getView().showManager("当前网络无法访问");
            }
        });
    }
}
