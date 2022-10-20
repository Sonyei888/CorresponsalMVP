package com.biblioteca.corresponsal.Model;

import com.biblioteca.corresponsal.Entidades.Transacciones;

import java.util.ArrayList;

public interface ConsultarTransaccionesInteractor {
    interface OnTransaccionesError{
        void onSucces();
    }
    ArrayList<Transacciones> ver(OnTransaccionesError listener);
}
