package com.biblioteca.corresponsal.Presenter;

import com.biblioteca.corresponsal.Entidades.Corresponsal;
import com.biblioteca.corresponsal.Entidades.Pago_tarjeta;

public interface PagoTarjetaPresenter {
    void insertpago(Pago_tarjeta pago_tarjeta);
    boolean editarsaldo(String nit, String saldo, Corresponsal corresponsal);
    void onDestroy();
}
