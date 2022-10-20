package com.biblioteca.corresponsal.Presenter;

import com.biblioteca.corresponsal.Entidades.Clientes;
import com.biblioteca.corresponsal.Entidades.Corresponsal;

public interface TransferenciaPresenter {
    boolean editarsaldocliente1(String cedula1, String saldo1, Clientes clientes);
    boolean editarsaldocliente2(String cedula2, String saldo2, Clientes clientes);
    boolean editarsaldcorresponsal(String nit, Corresponsal corresponsal);
}
