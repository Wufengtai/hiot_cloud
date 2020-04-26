package com.huatec.hiot_cloud.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.util.Log;
import android.widget.RadioGroup;

import com.huatec.hiot_cloud.R;
import com.huatec.hiot_cloud.UI.base.BasePresenter;
import com.huatec.hiot_cloud.UI.base.EaesActivity;
import com.huatec.hiot_cloud.utils.Contans;

public class MainActivity extends EaesActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("tag", "test");
        final ViewPager VP = findViewById(R.id.VR_view);
        VP.setAdapter(new MainViewPageAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT));
        VP.setOffscreenPageLimit(Contans.MAIN_FRAGMENT_COUNT);
        RadioGroup rgMain = findViewById(R.id.RG_view);
        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.RB_but1:
                        VP.setCurrentItem(Contans.MAIN_FRAGMENT_BUTTON1);
                        break;
                    case R.id.RB_but2:
                        VP.setCurrentItem(Contans.MAIN_FRAGMENT_BUTTON2);
                        break;
                    case R.id.RB_but3:
                        VP.setCurrentItem(Contans.MAIN_FRAGMENT_BUTTON3);
                        break;
                    case R.id.RB_but4:
                        VP.setCurrentItem(Contans.MAIN_FRAGMENT_BUTTON4);
                        break;
                    default:
                }
            }
        });
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void injectIndependies() {
        getActivityComponent().inject(this);
    }
}
