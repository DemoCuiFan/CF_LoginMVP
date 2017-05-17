package bwei.com.cf_loginmvp.presenter;


import bwei.com.cf_loginmvp.model.LoginModel;
import bwei.com.cf_loginmvp.model.LoginModelImpl;
import bwei.com.cf_loginmvp.view.LoginView;

/**
 * 类用途:
 * 作者:崔帆
 * 时间: 2017/5/16 20:15.
 */

public class LoginPresenterImpl implements LoginPresenter,OnLoginFinishedListener{
    private LoginView loginView;
    private LoginModel loginModel;
    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginModel = new LoginModelImpl();
    }

    @Override
    public void validateCredentials(String username, String password) {
        if (loginView != null) {
            loginView.showProgress();
        }

        loginModel.login(username, password,this);
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void onUsernameError() {
        if (loginView != null) {
            loginView.setUsernameError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if (loginView != null) {
            loginView.setPasswordError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if (loginView != null) {
            loginView.navigateToHome();
        }
    }
}
