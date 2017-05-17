package bwei.com.cf_loginmvp.presenter;

/**
 * 类用途:
 * 作者:崔帆
 * 时间: 2017/5/16 20:15.
 */

public interface LoginPresenter {

    void validateCredentials(String username, String password);

    void onDestroy();
}
