package com.huatec.hiot_cloud.Test.MvpTest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.huatec.hiot_cloud.R;
import com.huatec.hiot_cloud.Test.MvpTest.modle.User;

public class MvpTestActivity extends AppCompatActivity implements TestView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_test);
       final EditText evpassword = findViewById(R.id.ev_passworld);
       final EditText evusername = findViewById(R.id.ev_username);
        Button bin = findViewById(R.id.bin);
        final User user = new User();
        final TestPresenter presenter = new TestPresenter(this);
        bin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setUserName(evusername.getText().toString());
                user.setPassWorle(evpassword.getText().toString());
                presenter.Login(user);

            }
        });
    }


    @Override
    public void shoumessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
