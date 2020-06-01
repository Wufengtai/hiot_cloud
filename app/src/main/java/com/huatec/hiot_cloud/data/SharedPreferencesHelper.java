package com.huatec.hiot_cloud.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.huatec.hiot_cloud.injection.ApplicationContext;
import com.huatec.hiot_cloud.utils.Contans;

import javax.inject.Inject;

/*
* SharedPreferencesHelper类
* */

public class SharedPreferencesHelper {
    private static final String PREF_FILE_NAME = "userconfig";

    private static final String PREF_KEY_USER_TOKEN = "PREF_KEY_USER_TOKEN";

    private Context context;
    private final SharedPreferences mpref;

@Inject
    public SharedPreferencesHelper(@ApplicationContext Context context) {
        this.context = context;
        mpref = context.getSharedPreferences(PREF_KEY_USER_TOKEN, context.MODE_PRIVATE);
    }

    public void setUserToken(String value){
        mpref.edit().putString(PREF_KEY_USER_TOKEN, value).apply();
    }

    public String getUserToken(){
       return mpref.getString(PREF_KEY_USER_TOKEN,"");


    }
}
