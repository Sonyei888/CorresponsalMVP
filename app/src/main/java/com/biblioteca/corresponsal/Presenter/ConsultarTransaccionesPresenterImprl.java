package com.biblioteca.corresponsal.Presenter;

import com.biblioteca.corresponsal.Entidades.Transacciones;
import com.biblioteca.corresponsal.Model.ConsultarTransaccionesInteractor;
import com.biblioteca.corresponsal.View.ConsultarTransaccionesView;

import java.util.ArrayList;

public class ConsultarTransaccionesPresenterImprl implements ConsultarTransaccionesPresenter, ConsultarTransaccionesInteractor.OnTransaccionesError {
    private ConsultarTransaccionesView transaccionesView;
    private ConsultarTransaccionesInteractor consultarTransaccionesInteractor;

    public ConsultarTransaccionesPresenterImprl(ConsultarTransaccionesView transaccionesView, ConsultarTransaccionesInteractor consultarTransaccionesInteractor) {
        this.transaccionesView = transaccionesView;
        this.consultarTransaccionesInteractor = consultarTransaccionesInteractor;
    }

    @Override
    public void onSucces() {
        if(transaccionesView != null){
            transaccionesView.navigatetohome();
        }
    }

    @Override
    public ArrayList<Transacciones> vertransacciones() {
        ArrayList<Transacciones> transacciones;
        transacciones = consultarTransaccionesInteractor.ver(this);
        return transacciones;
    }
}
