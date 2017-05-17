package bwei.com.cf_loginmvp.presenter;

/**
 * 类用途:
 * 作者:崔帆
 * 时间: 2017/5/16 20:16.
 */

public interface OnLoginFinishedListener {
    void onUsernameError();

    void onPasswordError();

    void onSuccess();
}
