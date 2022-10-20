package com.biblioteca.corresponsal.Model;

import com.biblioteca.corresponsal.Entidades.Clientes;

public interface CrearClienteImpl {
    interface OnCrearError{
        void onNameError();
        void onCedulaError();
        void onSaldoError();
        void onSucces();
    }

    boolean registrar(Clientes clientes, OnCrearError listener);

}
