package com.huatec.hiot_cloud.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.huatec.hiot_cloud.R;
import com.huatec.hiot_cloud.Test.MvpTest.Gson.GsonActivity;
import com.huatec.hiot_cloud.Test.MvpTest.RXJAVA.RxJavaActivity;
import com.huatec.hiot_cloud.Test.MvpTest.TESTPICTURE.TestActivity;
import com.huatec.hiot_cloud.Test.MvpTest.Test.TestNetWorkActivity;
import com.huatec.hiot_cloud.Test.MvpTest.textInternet.TextInterentActivity;
import com.huatec.hiot_cloud.Test.MvpTest.textInternettwo.InternettwoActivity;
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
        Button but_Ok = findViewById(R.id.but_OKHttp);
        but_Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TextInterentActivity.class);
                startActivity(intent);
            }
        });
        Button but_Gson = findViewById(R.id.but_Gson);
        but_Gson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GsonActivity.class);
                startActivity(intent);
            }
        });
        Button but_Rxjava= findViewById(R.id.but_Rxjava);
        but_Rxjava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RxJavaActivity.class);
                startActivity(intent);
            }
        });
        Button but_glide= findViewById(R.id.but_glide);
        but_glide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestActivity.class);
                startActivity(intent);
            }
        });
        Button but_newint= findViewById(R.id.but_newOk);
        but_newint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestNetWorkActivity.class);
                startActivity(intent);
            }
        });
        Button but_Retrofit = findViewById(R.id.but_Retrofit);
        but_Retrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InternettwoActivity.class);
                startActivity(intent);
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
