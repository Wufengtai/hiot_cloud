package com.huatec.hiot_cloud.Test.MvpTest.TESTPICTURE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.huatec.hiot_cloud.R;
import com.huatec.hiot_cloud.Test.MvpTest.RXJAVA.RxJavaActivity;
import com.huatec.hiot_cloud.UI.MainActivity;
import com.huatec.hiot_cloud.utils.imgUtils;

public class TestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        final ImageView img = findViewById(R.id.glide_img1);
        Button but1 = findViewById(R.id.glide_but1);
        Button but3 = findViewById(R.id.glide_but3);
      final   String url ="http://p1.pstatp.com/large/166200019850062839d3";
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Glide.with(TestActivity.this)
                        .asGif()
                        .load(url)
                        .placeholder(R.drawable.loading)
                        .error(R.drawable.error)
                        .transition(new DrawableTransitionOptions().crossFade(1000))
                        .centerCrop()

                        .into(img);
            }
        });
        Button but2 = findViewById(R.id.glide_but2);
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgUtils.show(TestActivity.this,img,url);
            }
        });
    }
}
