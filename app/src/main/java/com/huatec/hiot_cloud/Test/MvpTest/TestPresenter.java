package com.huatec.hiot_cloud.Test.MvpTest;



import com.huatec.hiot_cloud.Test.MvpTest.modle.User;

public class TestPresenter {
private TestView view;
    public TestPresenter(TestView view) {
        this.view=view;
    }

    public void Login(User user){
        if ("wufengtai".equals(user.getUserName()) && "123".equals(user.getPassWorld())){
                view.shoumessage("登录成功");
        }else {
                view.shoumessage("登录失败");
        }
    }
}
