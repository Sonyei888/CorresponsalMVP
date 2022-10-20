package com.biblioteca.corresponsal.Presenter;

import com.biblioteca.corresponsal.Entidades.Usuarios;

public interface LoginPresenter {
    void validateCredentials(Usuarios usuarios);

    void onDestroy();
}
