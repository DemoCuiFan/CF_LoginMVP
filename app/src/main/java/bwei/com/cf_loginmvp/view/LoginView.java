package bwei.com.cf_loginmvp.view;

/**
 * 类用途:
 * 作者:崔帆
 * 时间: 2017/5/16 20:17.
 */

public interface LoginView {
    void showProgress();
    void hideProgress();
    void setUsernameError();
    void setPasswordError();
    void navigateToHome();
}
