package com.huatec.hiot_cloud.UI.zhuce;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.huatec.hiot_cloud.R;
import com.huatec.hiot_cloud.UI.Login.LoginActivity;
import com.huatec.hiot_cloud.UI.MainActivity;
import com.huatec.hiot_cloud.UI.base.EaesActivity;
import com.huatec.hiot_cloud.utils.LoadingUtil;
import com.huatec.hiot_cloud.utils.ValidatorUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ZhuceActivity extends EaesActivity<RegisterView, RegisterPresenter> implements RegisterView {

    @BindView(R.id.tiptet_username)
    TextInputEditText tiptetUsername;
    @BindView(R.id.tiptet_email)
    TextInputEditText tiptetEmail;
    @BindView(R.id.tiptet_password)
    TextInputEditText tiptetPassword;
    @BindView(R.id.btn_register)
    Button btnregister;
    @BindView(R.id.tv_link_signup)
    TextView tvLinkSignup;
    @Inject
    RegisterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);
        ButterKnife.bind(this);

    }

    @Override
    public RegisterPresenter createPresenter() {
        return presenter;
    }

    @Override
    public void injectIndependies() {
        getActivityComponent().inject(this);
    }

    /**
     * 校验用户输入
     *
     * @return
     */
    private boolean ValidateSucc(String username, String email, String password) {

        //校验用户名
        if (TextUtils.isEmpty(username)) {
            tiptetUsername.setError("用户名不能为空，请重新输入");
            return false;
        }
        //校验邮箱合规
        if (!ValidatorUtils.isUserName(username)) {
            tiptetUsername.setError("用户名输入不正确，请重新输入");
            return false;
        }

        //校验邮箱非空
        if (TextUtils.isEmpty(email)) {
            tiptetEmail.setError("邮箱不能为空，请重新输入");
            return false;
        }
        //校验邮箱合规
        if (!ValidatorUtils.isEmail(email)) {
            tiptetEmail.setError("邮箱输入不正确，请重新输入");
            return false;
        }

        //校验密码非空
        if (TextUtils.isEmpty(password)) {
            tiptetPassword.setError("密码不能为空，请重新输入");
            return false;
        }

        //校验密码合规
        if (!ValidatorUtils.isPassword(password)) {
            tiptetPassword.setError("密码输入不正确，请重新输入");
            return false;
        }
        return true;
    }

    @OnClick({R.id.btn_register, R.id.tv_link_signup})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_register:
                //注册
                String username = tiptetUsername.getText().toString();
                String password = tiptetPassword.getText().toString();
                String email = tiptetEmail.getText().toString();
                    //请求服务端身份验证
                presenter.register(username,password,email);
                break;
            case R.id.tv_link_signup:
                Intent intent = new Intent(ZhuceActivity.this, LoginActivity.class);
                   startActivity(intent);
                   finish();
                break;
        }
    }

    @Override
    public void registerSuce(String email, String password) {
    presenter.login(email,password);
    }

    @Override
    public void loginSuce() {
        Intent intent = new Intent(ZhuceActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
