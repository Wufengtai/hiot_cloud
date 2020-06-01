package com.huatec.hiot_cloud.UI.zhuce;

import com.huatec.hiot_cloud.UI.base.baseView;

/*
* 注册模块view层接口
* */
interface RegisterView extends baseView {

    void registerSuce(String email,String password);

    void loginSuce();
}
