package com.huatec.hiot_cloud.Test.MvpTest.dagger2test;

import dagger.Module;
import dagger.Provides;

/*
* dagger2测试module类
* */
@Module
public class testModule {

    @Provides
    public  ThirdObj getThirdObj(){
        return  new ThirdObj();
    }
}
