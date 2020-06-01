package com.huatec.hiot_cloud.UI.base;

import android.util.Log;

import com.huatec.hiot_cloud.utils.LoadingUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/*
* MVP架构Presenter层基类
* */
public class BasePresenter <V extends baseView>{
    private V view;
    private static final String TAG = "BasePresenter";
    public BasePresenter() {

    }
    public void setView(V view){
        this.view=view;
    }
    public V getView(){
        return view;
    }
    //定义销毁方法，释放view
    public void destroy(){
       if (viewAttached()){
           view = null;
       }
    }
    public  boolean viewAttached(){
        return  view !=null;
    }

    public  <T>void subscrib(Observable<T> observable, final RequestCallback<T> callback){
             observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<T>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        callback.onSubscribe(d);
                    }

                    @Override
                    public void onNext(T t) {
                    callback.onNext(t);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(e);
                    }

                    @Override
                    public void onComplete() {
                    callback.onComplete();
                    }
                });
    }
    /*回调类*/
    public abstract class  RequestCallback<T>{

        public void onSubscribe(Disposable d) {

        }


        public abstract void onNext(T t);


        public void onError(Throwable e) {
            /*
            * 对话框
            * */
            LoadingUtil.hideLoading();
            Log.e(TAG,"onError",e);
            getView().showManager("网络错误!!!!!!!");
        }


        public void onComplete() {

        }
    }
}
