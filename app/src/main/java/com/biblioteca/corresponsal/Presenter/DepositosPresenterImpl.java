package com.biblioteca.corresponsal.Presenter;

import com.biblioteca.corresponsal.Entidades.Clientes;
import com.biblioteca.corresponsal.Model.DepositosInteractor;
import com.biblioteca.corresponsal.View.DepositoView;

public class DepositosPresenterImpl implements DepositoPresenter, DepositosInteractor.OnDepositosError {
    private DepositoView depositoView;
    private DepositosInteractor depositosInteractor;

    public DepositosPresenterImpl(DepositoView depositoView, DepositosInteractor depositosInteractor) {
        this.depositoView = depositoView;
        this.depositosInteractor = depositosInteractor;
    }

    @Override
    public void OnSucces() {
        if(depositoView != null){
            depositoView.nextTohome();
        }
    }

    @Override
    public Clientes validarcedula(String cedula) {
        Clientes clientes = depositosInteractor.consultarcedula(cedula, this);
        return clientes;
    }

    @Override
    public boolean editarsaldo(String cedula, String saldo, Clientes clientes) {
        boolean correcto;
        correcto = depositosInteractor.editarsaldo(cedula, saldo, clientes, this);
        return correcto;
    }
}
