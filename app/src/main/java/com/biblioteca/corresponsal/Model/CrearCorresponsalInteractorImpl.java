package com.biblioteca.corresponsal.Model;

import android.content.Context;

import com.biblioteca.corresponsal.Entidades.Corresponsal;
import com.biblioteca.corresponsal.Metodos.MtdClientes;
import com.biblioteca.corresponsal.Metodos.MtdCorresponsal;

public class CrearCorresponsalInteractorImpl implements CrearCorresponsalInteractor{
    Context context;
    MtdCorresponsal mtdCorresponsal;

    public CrearCorresponsalInteractorImpl(Context context) {
        this.context = context;
    }

    @Override
    public boolean registrarcorresponsal(Corresponsal corresponsal, OnCrearError listener) {
        if(corresponsal != null){
            mtdCorresponsal = new MtdCorresponsal(context);
            mtdCorresponsal.insertCorresponsal(corresponsal);
            listener.onSucces();
        }else{
            return false;
        }

        return false;
    }
}
