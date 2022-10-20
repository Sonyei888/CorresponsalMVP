package com.biblioteca.corresponsal.Presenter;

import com.biblioteca.corresponsal.Entidades.Clientes;
import com.biblioteca.corresponsal.Entidades.Corresponsal;
import com.biblioteca.corresponsal.Model.TransferenciaInteractor;
import com.biblioteca.corresponsal.View.TransferenciaView;

public class TransferenciaPresenterImpl implements TransferenciaPresenter, TransferenciaInteractor.OnTransferenciaError {
    private TransferenciaView transferenciaView;
    private TransferenciaInteractor transferenciaInteractor;

    public TransferenciaPresenterImpl(TransferenciaView transferenciaView, TransferenciaInteractor transferenciaInteractor) {
        this.transferenciaView = transferenciaView;
        this.transferenciaInteractor = transferenciaInteractor;
    }

    @Override
    public void OnSucces() {
        if(transferenciaView != null){
            transferenciaView.navigateTohome();
        }
    }

    @Override
    public boolean editarsaldocliente1(String cedula1, String saldo1, Clientes clientes) {
        boolean correcto = transferenciaInteractor.editarcliente1(cedula1, saldo1, clientes, this);
        return correcto;
    }

    @Override
    public boolean editarsaldocliente2(String cedula2, String saldo2, Clientes clientes) {
        boolean correcto = transferenciaInteractor.editarcliente2(cedula2, saldo2, clientes, this);
        return correcto;
    }

    @Override
    public boolean editarsaldcorresponsal(String nit, Corresponsal corresponsal) {
        boolean correcto = transferenciaInteractor.saldocorres(nit, corresponsal, this);
        return correcto;
    }
}
