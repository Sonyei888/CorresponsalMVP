package com.biblioteca.corresponsal.Presenter;

import com.biblioteca.corresponsal.Entidades.Corresponsal;
import com.biblioteca.corresponsal.Entidades.Pago_tarjeta;
import com.biblioteca.corresponsal.Model.PagoTarjetaInteractor;
import com.biblioteca.corresponsal.View.PagoTarjetaView;

public class PagoTarjetaPresenterImpl implements PagoTarjetaPresenter, PagoTarjetaInteractor.OnPagoError {
    private PagoTarjetaView pagoTarjetaView;
    private PagoTarjetaInteractor pagoTarjetaInteractor;

    public PagoTarjetaPresenterImpl(PagoTarjetaView pagoTarjetaView, PagoTarjetaInteractor pagoTarjetaInteractor) {
        this.pagoTarjetaView = pagoTarjetaView;
        this.pagoTarjetaInteractor = pagoTarjetaInteractor;
    }

    @Override
    public void onSucces() {
        if(pagoTarjetaView != null){
            pagoTarjetaView.navigatetohome();
        }
    }

    @Override
    public void insertpago(Pago_tarjeta pago_tarjeta) {
        pagoTarjetaInteractor.registrarpago(pago_tarjeta, this);
    }

    @Override
    public boolean editarsaldo(String nit, String saldo, Corresponsal corresponsal) {
        boolean correcto;
        correcto = pagoTarjetaInteractor.editarsaldo(nit, saldo, corresponsal, this);
        return correcto;
    }

    @Override
    public void onDestroy() {

    }
}
