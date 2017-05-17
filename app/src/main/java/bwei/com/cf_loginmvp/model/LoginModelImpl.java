package bwei.com.cf_loginmvp.model;

import android.os.Handler;
import android.text.TextUtils;

import bwei.com.cf_loginmvp.presenter.OnLoginFinishedListener;


/**
 * 类用途:
 * 作者:崔帆
 * 时间: 2017/5/16 20:07.
 */

public class LoginModelImpl implements LoginModel {

    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                boolean error = false;
                if (TextUtils.isEmpty(username)){
                    listener.onUsernameError();//model层里面回调listener
                    error = true;
                }
                if (TextUtils.isEmpty(password)){
                    listener.onPasswordError();
                    error = true;
                }
                if (!error){
                    listener.onSuccess();
                }
            }
        }, 2000);
    }

}
