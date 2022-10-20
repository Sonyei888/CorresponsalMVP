package com.biblioteca.corresponsal.Presenter;

import com.biblioteca.corresponsal.Entidades.Clientes;

public interface DepositoPresenter {
    Clientes validarcedula(String cedula);
    boolean editarsaldo(String cedula, String saldo, Clientes clientes);
}
