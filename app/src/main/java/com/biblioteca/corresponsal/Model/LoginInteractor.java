package com.biblioteca.corresponsal.Model;

import com.biblioteca.corresponsal.Entidades.Usuarios;

public interface LoginInteractor {
    interface  OnLoginFinishedListener {
        void onEmailError();
        void onPasswordError();
        void onSuccescorresponsal();
        void onSuccesbanco();
    }
    void login(Usuarios usuarios, OnLoginFinishedListener listener);

}
