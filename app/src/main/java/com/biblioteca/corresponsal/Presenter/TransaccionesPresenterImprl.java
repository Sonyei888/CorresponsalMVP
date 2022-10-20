package com.biblioteca.corresponsal.Presenter;

import com.biblioteca.corresponsal.Entidades.Transacciones;
import com.biblioteca.corresponsal.Model.TransaccionesInteractor;
import com.biblioteca.corresponsal.Model.TransaccionesInteractorImpl;
import com.biblioteca.corresponsal.View.TransaccionesView;

public class TransaccionesPresenterImprl implements TransaccionesPresenter, TransaccionesInteractor.OnTransaccionError {
    private TransaccionesView transaccionesView;
    private TransaccionesInteractorImpl transaccionesInteractor;

    public TransaccionesPresenterImprl(TransaccionesView transaccionesView, TransaccionesInteractorImpl transaccionesInteractor) {
        this.transaccionesView = transaccionesView;
        this.transaccionesInteractor = transaccionesInteractor;
    }

    @Override
    public void onsucces() {
        if(transaccionesView != null){
            transaccionesView.navigateTohome();
        }
    }

    @Override
    public void insertTransaccion(Transacciones transacciones) {
        transaccionesInteractor.insert(transacciones, this);
    }
}
