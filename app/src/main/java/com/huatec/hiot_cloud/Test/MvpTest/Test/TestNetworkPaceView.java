package com.huatec.hiot_cloud.Test.MvpTest.Test;

import com.huatec.hiot_cloud.UI.base.baseView;

/*
* 网络封装测试Mvp架构view层接口
* */
public interface TestNetworkPaceView extends baseView {
    void showToken(String token);

    void  showManager(String manager);
}
