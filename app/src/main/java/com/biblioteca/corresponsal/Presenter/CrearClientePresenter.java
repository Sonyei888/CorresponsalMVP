package com.biblioteca.corresponsal.Presenter;

import com.biblioteca.corresponsal.Entidades.Clientes;

public interface CrearClientePresenter {
    boolean insertarCLiente(Clientes clientes);
    void onDestroy();
}
