package com.huatec.hiot_cloud.Test.MvpTest.dagger2test;

/*
* 测试注入器接口
* */

import com.huatec.hiot_cloud.Test.MvpTest.MvpTestActivity;

import dagger.Component;
/*
* 有module必须添加（）里面的才能找的到目标
* */
@Component(modules = testModule.class)//注解
public interface PersenterComponent {

    void  inject(MvpTestActivity mvpTestActivity);
}
