package com.biblioteca.corresponsal.Presenter;

import com.biblioteca.corresponsal.Entidades.Clientes;
import com.biblioteca.corresponsal.Entidades.Corresponsal;

public interface RetirosPresenter {
    Clientes mostrardatos(String cedula);
    boolean editarclientes(String monto, Clientes clientes);
    boolean editarCorresponsalSaldo(Corresponsal corresponsal);
}
