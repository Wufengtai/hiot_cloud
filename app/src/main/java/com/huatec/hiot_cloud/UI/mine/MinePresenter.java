package com.huatec.hiot_cloud.UI.mine;

import com.huatec.hiot_cloud.Test.MvpTest.Gson.ResultBase;
import com.huatec.hiot_cloud.Test.MvpTest.textInternettwo.UserBean;
import com.huatec.hiot_cloud.UI.base.BasePresenter;
import com.huatec.hiot_cloud.data.DataManager;

import javax.inject.Inject;

public class MinePresenter extends BasePresenter<MineView> {
   @Inject
   DataManager dataManager;

    @Inject

    public MinePresenter() {

    }
/*
* 获取用户信息
* */
    public void loadUserInfo() {
        subscrib(dataManager.username(), new RequestCallback<ResultBase<UserBean>>() {
            @Override
            public void onNext(ResultBase<UserBean> resultBase) {
                if (resultBase == null){
                    getView().showManager("网络请求失败");
                    return;
                }
                if (resultBase.getStatus()==0){
                    getView().showManager(resultBase.getMsg());
                    return;

                }
                if (resultBase.getData()==null){
                    getView().showManager("网络请求失败");
                    return;
                }
              UserBean userBean =  resultBase.getData();
                getView().refreshUserInfo(userBean);
            }


        });
    }
}
