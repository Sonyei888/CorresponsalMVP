package com.biblioteca.corresponsal.Model;

import com.biblioteca.corresponsal.Entidades.Clientes;
import com.biblioteca.corresponsal.Entidades.Corresponsal;

public interface ActualizarCorresponsalInteractor {
    interface OnActualizarError{
        void onSucces();
    }
    interface OnActualizarestadohabilitarError{
        void onSucces();
    }
    interface OnActualizarestadodeshabilitarError{
        void onSucces();
    }
    boolean editar(int nit, Corresponsal corresponsal, OnActualizarError listener);
    boolean editarhabilitar(int nit, Corresponsal corresponsal, OnActualizarestadohabilitarError listener);
    boolean editardeshabilitar(int nit, Corresponsal corresponsal, OnActualizarestadodeshabilitarError listener);
}
