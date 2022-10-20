package com.biblioteca.corresponsal.Presenter;

import com.biblioteca.corresponsal.Entidades.Clientes;
import com.biblioteca.corresponsal.Entidades.Corresponsal;
import com.biblioteca.corresponsal.Model.RetirosInteractor;
import com.biblioteca.corresponsal.View.RetirosView;

public class RetirosPresenterImprl implements RetirosPresenter, RetirosInteractor.RetiroError {
    private RetirosView retirosView;
    private RetirosInteractor retirosInteractor;

    public RetirosPresenterImprl(RetirosView retirosView, RetirosInteractor retirosInteractor) {
        this.retirosView = retirosView;
        this.retirosInteractor = retirosInteractor;
    }

    @Override
    public void onSucess() {
        if(retirosView != null){
            retirosView.navigatetTohome();
        }
    }

    @Override
    public Clientes mostrardatos(String cedula) {
        Clientes clientes = retirosInteractor.verdatos(cedula, this);
        return clientes;
    }

    @Override
    public boolean editarclientes(String monto, Clientes clientes) {
        boolean correcto;
        correcto = retirosInteractor.editar(monto, clientes, this);
        return correcto;
    }

    @Override
    public boolean editarCorresponsalSaldo( Corresponsal corresponsal) {
        boolean correcto;
        correcto = retirosInteractor.editarsaldo(corresponsal, this);
        return correcto;
    }
}
