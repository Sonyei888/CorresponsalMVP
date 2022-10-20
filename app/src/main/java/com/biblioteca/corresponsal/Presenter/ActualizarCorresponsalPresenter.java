package com.biblioteca.corresponsal.Presenter;

import com.biblioteca.corresponsal.Entidades.Corresponsal;

public interface ActualizarCorresponsalPresenter {
    boolean editarCorresponsal(int nit, Corresponsal corresponsal);
    boolean editarestadohabilitar(int nit, Corresponsal corresponsal);
    boolean editarestadodeshabilitar(int nit, Corresponsal corresponsal);
}
