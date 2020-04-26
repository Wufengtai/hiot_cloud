package com.huatec.hiot_cloud.UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.huatec.hiot_cloud.R;
import com.huatec.hiot_cloud.UI.base.BaseFragment;
import com.huatec.hiot_cloud.UI.base.BasePresenter;

public class sceneFragment extends BaseFragment {
    /*
     * 创建fragment实例
     * */
    public static sceneFragment newInstance(){
        sceneFragment fragment = new sceneFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void injectDependencies() {

    }
    /*
     * 实现initView方法。。。
     * */
    @Override
    public View initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        TextView tvfragment1 = view.findViewById(R.id.TV_fragment);
        tvfragment1.setText("消息");


    }
}
