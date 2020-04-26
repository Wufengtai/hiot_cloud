package com.huatec.hiot_cloud.UI;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import com.huatec.hiot_cloud.utils.Contans;

class MainViewPageAdapter extends FragmentPagerAdapter {

    public MainViewPageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        switch (position) {
            case Contans.MAIN_FRAGMENT_BUTTON1:
                //创建设备fragment TODO
                fragment = EquipmentFragment.newInstance();
                break;
            case Contans.MAIN_FRAGMENT_BUTTON2:
                fragment = sceneFragment.newInstance();
                break;
            case Contans.MAIN_FRAGMENT_BUTTON3:
                fragment = fuwuqiFragment.newInstance();
                break;
            case Contans.MAIN_FRAGMENT_BUTTON4:
                fragment = mineFragment.newInstance();
                break;
            default:
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return Contans.MAIN_FRAGMENT_COUNT;
    }
}
