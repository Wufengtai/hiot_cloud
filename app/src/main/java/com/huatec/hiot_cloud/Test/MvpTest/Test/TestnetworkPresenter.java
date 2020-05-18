package com.huatec.hiot_cloud.Test.MvpTest.Test;

import android.widget.Toast;

import com.huatec.hiot_cloud.Test.MvpTest.Gson.ResultBase;
import com.huatec.hiot_cloud.Test.MvpTest.Gson.loginResultDto;
import com.huatec.hiot_cloud.Test.MvpTest.textInternettwo.UserBean;
import com.huatec.hiot_cloud.UI.base.BasePresenter;
import com.huatec.hiot_cloud.data.DataManager;

import javax.inject.Inject;

public class TestnetworkPresenter extends BasePresenter<TestNetworkPaceView> {
    @Inject
    DataManager dataManager;

    @Inject
    public TestnetworkPresenter() {
    }

    public void login(String username, String password) {
        subscrib(dataManager.login(username, password), new RequestCallback<ResultBase<loginResultDto>>() {
            @Override
            public void onNext(ResultBase<loginResultDto> resultBase) {
                if (resultBase != null && resultBase.getData() != null) {
                    getView().showToken(resultBase.getData().getTokenValue());
                } else if (resultBase != null && resultBase.getMsg() != null) {
                    getView().showManager(resultBase.getMsg());
                }
            }
        });
    }

    public  void username(String authorization){
        subscrib(dataManager.username(authorization), new RequestCallback<ResultBase<UserBean>>() {
            @Override
            public void onNext(ResultBase<UserBean> resultBase) {
                if (resultBase != null && resultBase.getData() != null) {
                    String str = String.format("用户：%s,email：%s", resultBase.getData().getUsername(),
                            resultBase.getData().getEmail());
                    getView().showManager(str);
                } else if (resultBase != null && resultBase.getMsg() != null) {
                    getView().showManager(resultBase.getMsg());
                }
            }
        });
    }
    public void  email(String newemail, String authorization){
        subscrib(dataManager.email(newemail, authorization), new RequestCallback<ResultBase<String>>() {
            @Override
            public void onNext(ResultBase<String> resultBase) {
                if (resultBase != null && resultBase.getData() != null) {
                    String str = String.format("用户：%s,email：%s", resultBase.getData(), resultBase.getData());
                    getView().showManager(str);
                } else if (resultBase != null && resultBase.getMsg() != null) {
                    getView().showManager(resultBase.getMsg());
                }
            }
        });
    }

    public void password(String newpassword, String oldpassword, String confirmpassword, String authorization){
        subscrib(dataManager.password(newpassword,oldpassword, confirmpassword, authorization), new RequestCallback<ResultBase<String>>() {
            @Override
            public void onNext(ResultBase<String> resultBase) {
                if (resultBase != null && resultBase.getData() != null) {
                    String str = String.format("用户：%s,email：%s", resultBase.getData(), resultBase.getData());
                    getView().showManager(str);
                } else if (resultBase != null && resultBase.getMsg() != null) {
                    getView().showManager(resultBase.getMsg());
                }
            }
        });

    }
}
