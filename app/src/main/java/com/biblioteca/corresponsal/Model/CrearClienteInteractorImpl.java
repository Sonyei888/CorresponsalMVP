package com.biblioteca.corresponsal.Model;

import android.content.Context;
import android.text.TextUtils;

import com.biblioteca.corresponsal.Entidades.Clientes;
import com.biblioteca.corresponsal.Metodos.MtdClientes;

public class CrearClienteInteractorImpl implements CrearClienteImpl{
    Context context;
    MtdClientes mtdClientes;

    public CrearClienteInteractorImpl(Context context) {
        this.context = context;

    }

    @Override
    public boolean registrar(Clientes clientes, OnCrearError listener) {
        boolean correcto;
        if(TextUtils.isEmpty(clientes.getNombre())){
            listener.onNameError();
            return false;
        }
        if(TextUtils.isEmpty(clientes.getCedula())){
            listener.onCedulaError();
            return false;
        }
        if(TextUtils.isEmpty(clientes.getSaldo())){
            listener.onSaldoError();
            return false;
        }
        if(clientes != null){
            mtdClientes = new MtdClientes(context);
            correcto = mtdClientes.insertClientes(clientes);
            listener.onSucces();
            return correcto;
        }else{
            return false;
        }

    }
    

}
