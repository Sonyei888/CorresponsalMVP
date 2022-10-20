package com.biblioteca.corresponsal.Model;

import com.biblioteca.corresponsal.Entidades.Clientes;
import com.biblioteca.corresponsal.Entidades.Corresponsal;

public interface CrearCorresponsalInteractor {
    interface OnCrearError{
        void onSucces();
    }
    boolean registrarcorresponsal(Corresponsal corresponsal, OnCrearError listener);
}
