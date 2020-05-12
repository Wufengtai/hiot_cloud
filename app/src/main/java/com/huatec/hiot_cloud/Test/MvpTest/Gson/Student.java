package com.huatec.hiot_cloud.Test.MvpTest.Gson;

import java.io.Serializable;
/*
* 学生实体类
* */
class Student implements Serializable {
    private String name;
    private int	age;
    private Boolean   married;


    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
