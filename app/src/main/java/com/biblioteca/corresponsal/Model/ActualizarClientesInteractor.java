package com.biblioteca.corresponsal.Model;

import com.biblioteca.corresponsal.Entidades.Clientes;

public interface ActualizarClientesInteractor {
    interface OnActualizarClientesError{
        void OnSucees();
    }
    boolean editar(int cedula, Clientes clientes, OnActualizarClientesError listener);

}
