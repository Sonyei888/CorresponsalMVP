package com.biblioteca.corresponsal.Presenter;

import com.biblioteca.corresponsal.Entidades.Usuarios;
import com.biblioteca.corresponsal.Model.LoginInteractor;
import com.biblioteca.corresponsal.View.LoginView;

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishedListener {
    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView, LoginInteractor loginInteractor) {
        this.loginView = loginView;
        this.loginInteractor = loginInteractor;
    }
    @Override
    public void validateCredentials(Usuarios usuarios) {
        loginInteractor.login(usuarios, this);
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }
    @Override
    public void onEmailError() {
        if(loginView!=null){
            loginView.setEmailError();
        }
    }

    @Override
    public void onPasswordError() {
        if(loginView!=null){
            loginView.setPasswordError();
        }
    }

    @Override
    public void onSuccescorresponsal() {
        if(loginView !=null){
            loginView.navigateToCorresponsal();
        }
    }

    @Override
    public void onSuccesbanco() {
        if(loginView != null){
            loginView.navigateToBanco();
        }
    }


}
