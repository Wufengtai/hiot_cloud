package com.huatec.hiot_cloud.Test.MvpTest.modle;

import java.io.Serializable;

public class User implements Serializable {
    private String UserName;
    private String PassWorld;



    public String getPassWorld() {
        return PassWorld;
    }

    public void setPassWorle(String passWorld) {
        PassWorld = passWorld;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }
}
