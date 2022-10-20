package com.biblioteca.corresponsal.Presenter;

import com.biblioteca.corresponsal.Entidades.Clientes;

import java.util.ArrayList;

public interface ConsultarClientesPresenter {
    Clientes mostrarclinetes(String cedula_clientes);
    ArrayList<Clientes> verclientes();
}
