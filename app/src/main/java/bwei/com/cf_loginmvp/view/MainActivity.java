package bwei.com.cf_loginmvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import bwei.com.cf_loginmvp.R;
import bwei.com.cf_loginmvp.presenter.LoginPresenterImpl;


public class MainActivity extends AppCompatActivity implements LoginView, View.OnClickListener {


    private Button main_btn;
    private ProgressBar main_pb;
    private String mUser;
    private String mPwd;
    private LoginPresenterImpl mLoginPresenter;
    private EditText main_et_user;
    private EditText main_et_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    public void showProgress() {
        main_pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        main_pb.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        main_et_user.setError(getString(R.string.username_error));
    }

    @Override
    public void setPasswordError() {
        main_et_pwd.setError(getString(R.string.password_error));
    }

    @Override
    public void navigateToHome() {
        submit();
       // Toast.makeText(this, "login success", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        mLoginPresenter.onDestroy();
        super.onDestroy();
    }

    private void initView() {

        main_btn = (Button) findViewById(R.id.main_btn);
        main_pb = (ProgressBar) findViewById(R.id.main_pb);
        mLoginPresenter = new LoginPresenterImpl(this);
        main_btn.setOnClickListener(this);
        main_et_user = (EditText) findViewById(R.id.main_et_user);
        main_et_user.setOnClickListener(this);
        main_et_pwd = (EditText) findViewById(R.id.main_et_pwd);
        main_et_pwd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        mLoginPresenter.validateCredentials(main_et_user.getText().toString(), main_et_pwd.getText().toString());
    }

    private void submit() {
        // validate
        String user = main_et_user.getText().toString().trim();
        String pwd = main_et_pwd.getText().toString().trim();
        if ("cuifan".equals(user)) {
            if ("123456".equals(pwd)) {
                Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
                return;
            }else{
                Toast.makeText(this, "密码错误", Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this, "账号错误", Toast.LENGTH_SHORT).show();
        }




        // TODO validate success, do something


    }
}
