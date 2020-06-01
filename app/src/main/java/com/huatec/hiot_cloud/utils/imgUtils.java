package com.huatec.hiot_cloud.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.huatec.hiot_cloud.R;
import com.huatec.hiot_cloud.data.NetService;

/*
* 图片工具类
* */
public class imgUtils {
    public static String getFullUrl(String url){
        return NetService.basurl + url;
    }
    public  static  void  show(Context context, ImageView imageView, String url){
        Glide.with(context).load(url).apply(getCommonOptions().centerCrop()).into(imageView);
    }
    public  static  void  showCircle(Context context, ImageView imageView, String url){
        Glide.with(context).load(url).apply(getCommonOptions().circleCrop()).into(imageView);
    }
    private static RequestOptions getCommonOptions(){
       RequestOptions options = new RequestOptions();
       options.placeholder(R.mipmap.wft);

       return  options;
    }
}
