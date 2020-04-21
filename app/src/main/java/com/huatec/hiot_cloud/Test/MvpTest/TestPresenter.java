package com.huatec.hiot_cloud.Test.MvpTest;



import com.huatec.hiot_cloud.Test.MvpTest.dagger2test.ThirdObj;
import com.huatec.hiot_cloud.Test.MvpTest.modle.User;
import com.huatec.hiot_cloud.base.BasePresenter;

import javax.inject.Inject;

public class TestPresenter extends BasePresenter<TestView> {
    //添加构造方法

    /*
    * 注入@inject类
    * */
    @Inject
    ThirdObj thirdObj;

    @Inject
    public TestPresenter() {

    }

    public void Login(User user){
        //调用thirdobj
        thirdObj.thirdAction();
        if ("wufengtai".equals(user.getUserName()) && "123".equals(user.getPassWorld())){
                getView().ShowMessage("登录成功");
        }else {
                getView().ShowMessage("登录失败");
        }
    }

}
