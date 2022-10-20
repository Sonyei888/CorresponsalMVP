package com.biblioteca.corresponsal.Model;

import android.content.Context;
import android.text.TextUtils;

import com.biblioteca.corresponsal.Entidades.Usuarios;
import com.biblioteca.corresponsal.Metodos.MtdLogin;

public class LoginInteractorImpl implements LoginInteractor{
    Context context;
    MtdLogin mtdLogin;

    public LoginInteractorImpl(Context context) {
        this.context = context;

    }

    @Override
    public void login(Usuarios usuarios, OnLoginFinishedListener listener) {
        mtdLogin = new MtdLogin(context);
        String rol1 ="Corresponsal";
        String rol2 = "Banco";
        if(TextUtils.isEmpty(usuarios.getCorreo())){
            listener.onEmailError();
            return;
        }
        if(TextUtils.isEmpty(usuarios.getContrasena())){
            listener.onPasswordError();
            return;
        }

        if(mtdLogin.login(usuarios, rol1)==1){
            listener.onSuccescorresponsal();
        }else if(mtdLogin.login(usuarios, rol2)==1){
           listener.onSuccesbanco();
        } else{
            listener.onEmailError();
            listener.onPasswordError();
            return;
        }
    }


}
