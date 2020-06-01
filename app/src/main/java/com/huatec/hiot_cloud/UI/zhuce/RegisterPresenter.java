package com.huatec.hiot_cloud.UI.zhuce;

import com.huatec.hiot_cloud.Test.MvpTest.Gson.ResultBase;
import com.huatec.hiot_cloud.Test.MvpTest.Gson.loginResultDto;
import com.huatec.hiot_cloud.Test.MvpTest.textInternettwo.UserBean;
import com.huatec.hiot_cloud.UI.base.BasePresenter;
import com.huatec.hiot_cloud.data.DataManager;

import javax.inject.Inject;


/*
* 注册模块presenter类
* */
class RegisterPresenter extends BasePresenter<RegisterView> {
@Inject
    DataManager dataManager;
@Inject
    public RegisterPresenter() {

    }


    public void register(String username, String password, String email ) {
        subscrib(dataManager.zhuce(username, password, email), new RequestCallback<ResultBase<UserBean>>() {
            @Override
            public void onNext(ResultBase<UserBean> resultBase) {
                //判断如果注册成功，吐司成功或者自动登录
                if (resultBase.getStatus() == 1) {
                    if (resultBase != null && resultBase.getData() != null) {
                        //登录成功
                        getView().showManager("注册成功");
                        //跳转到主界面
                        getView().registerSuce(email,password);
                    }
                }
                //如果失败发生服务端信息
                else{
                    if (resultBase != null && resultBase.getMsg() != null) {
                        getView().showManager(resultBase.getMsg());
                    }
                }

            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                //吐司连接失败
                getView().showManager("网络错误，连接失败");
            }
        });
    }

    public void login(String email, String password) {
        subscrib(dataManager.login(email, password), new RequestCallback<ResultBase<loginResultDto>>() {
            @Override
            public void onNext(ResultBase<loginResultDto> resultBase) {
                if (resultBase.getStatus() == 1) {
                    if (resultBase != null && resultBase.getData() != null) {
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
