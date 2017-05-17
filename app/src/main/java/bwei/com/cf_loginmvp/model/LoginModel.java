package bwei.com.cf_loginmvp.model;


import bwei.com.cf_loginmvp.presenter.OnLoginFinishedListener;

/**
 * 类用途:
 * 作者:崔涵淞
 * 时间: 2017/5/16 20:08.
 */

public interface LoginModel {
    void login(String username, String password, OnLoginFinishedListener listener);
}
