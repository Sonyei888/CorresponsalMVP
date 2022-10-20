package com.biblioteca.corresponsal.Model;

import com.biblioteca.corresponsal.Entidades.Corresponsal;
import com.biblioteca.corresponsal.Entidades.Pago_tarjeta;

public interface PagoTarjetaInteractor {
    interface OnPagoError{
        void onSucces();
    }
    boolean registrarpago(Pago_tarjeta pago_tarjeta, OnPagoError listener);
    boolean editarsaldo(String nit, String saldo, Corresponsal corresponsal, OnPagoError listener);
}
