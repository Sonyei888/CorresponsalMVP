package com.biblioteca.corresponsal.Model;

import com.biblioteca.corresponsal.Entidades.Clientes;

public interface DepositosInteractor {
    interface OnDepositosError {
        void OnSucces();
    }

    Clientes consultarcedula(String cedula, OnDepositosError listener);
    boolean editarsaldo(String cedula, String saldo, Clientes clientes, OnDepositosError listener);
}