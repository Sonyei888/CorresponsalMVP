package com.biblioteca.corresponsal.Model;

import com.biblioteca.corresponsal.Entidades.Clientes;
import com.biblioteca.corresponsal.Entidades.Corresponsal;

public interface TransferenciaInteractor {
    interface OnTransferenciaError{
        void OnSucces();
    }
    boolean editarcliente1(String cedula1, String saldo1, Clientes clientes, OnTransferenciaError listener);
    boolean editarcliente2(String cedula2, String saldo2, Clientes clientes, OnTransferenciaError listener);
    boolean saldocorres(String nit, Corresponsal corresponsal, OnTransferenciaError listener);
}
