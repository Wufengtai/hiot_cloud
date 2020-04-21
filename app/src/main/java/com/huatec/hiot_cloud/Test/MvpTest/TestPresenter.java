package com.huatec.hiot_cloud.Test.MvpTest;



import com.huatec.hiot_cloud.Test.MvpTest.modle.User;
import com.huatec.hiot_cloud.base.BasePresenter;

public class TestPresenter extends BasePresenter<TestView> {
    //添加构造方法
    public TestPresenter() {

    }

    public void Login(User user){
        if ("wufengtai".equals(user.getUserName()) && "123".equals(user.getPassWorld())){
                getView().ShowMessage("登录成功");
        }else {
                getView().ShowMessage("登录失败");
        }
    }

}
