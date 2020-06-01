package com.huatec.hiot_cloud.UI.mine;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.huatec.hiot_cloud.R;
import com.huatec.hiot_cloud.Test.MvpTest.textInternettwo.UserBean;
import com.huatec.hiot_cloud.UI.base.BaseFragment;
import com.huatec.hiot_cloud.UI.base.BasePresenter;
import com.huatec.hiot_cloud.UI.base.EaesActivity;
import com.huatec.hiot_cloud.utils.imgUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class mineFragment extends BaseFragment<MineView,MinePresenter> implements MineView{
   @Inject
    MinePresenter presenter;
    @BindView(R.id.Img_user)
    ImageView ImgUser;
    @BindView(R.id.T_N)
    TextView TN;
    @BindView(R.id.T_X)
    TextView TX;
    @BindView(R.id.T_M)
    TextView TM;
    @BindView(R.id.T_E)
    TextView TE;
    @BindView(R.id.T_Y)
    TextView TY;
    @BindView(R.id.T_G)
    TextView TG;
    @BindView(R.id.But_T)
    Button ButT;

    /*
     * 创建fragment实例
     * */
    public static mineFragment newInstance() {
        mineFragment fragment = new mineFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public MinePresenter createPresenter() {
        return presenter;
    }

    @Override
    public void injectDependencies() {
        if (getActivity() instanceof EaesActivity) {
            ((EaesActivity) getActivity()).getActivityComponent().inject(this);
        }
    }

    /*
     * 实现initView方法。。。
     * */
    @Override
    public View initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        ButterKnife.bind(this,view);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.loadUserInfo();


    }

    @OnClick({R.id.Img_user, R.id.T_M, R.id.T_E, R.id.T_Y, R.id.T_G, R.id.But_T})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Img_user:
                break;
            case R.id.T_M:
                break;
            case R.id.T_E:
                break;
            case R.id.T_Y:
                break;
            case R.id.T_G:
                break;
            case R.id.But_T:
                break;
        }
    }

    @Override
    public void refreshUserInfo(UserBean userBean) {
        imgUtils.showCircle(getActivity(),ImgUser,imgUtils.getFullUrl(userBean.getImg()));
        TN.setText(userBean.getUsername());
        TX.setText(userBean.getEmail());
    }
}
