package com.biblioteca.corresponsal.Model;

import com.biblioteca.corresponsal.Entidades.Clientes;

import java.util.ArrayList;

public interface ConsultarClientesInteractor {
    interface OnConsultaClientesError{
        void OnSucess();
    }
    Clientes consultar(String cedula_clientes, OnConsultaClientesError listener);
    ArrayList<Clientes> ver(OnConsultaClientesError listener);
}
