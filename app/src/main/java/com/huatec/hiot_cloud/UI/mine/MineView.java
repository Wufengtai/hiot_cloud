package com.huatec.hiot_cloud.UI.mine;

import com.huatec.hiot_cloud.Test.MvpTest.textInternettwo.UserBean;
import com.huatec.hiot_cloud.UI.base.baseView;

public interface MineView extends baseView {
/*
* 刷新用户信息
* */
    void refreshUserInfo(UserBean userBean);
}
