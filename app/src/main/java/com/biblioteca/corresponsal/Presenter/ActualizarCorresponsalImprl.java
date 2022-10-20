package com.biblioteca.corresponsal.Presenter;

import com.biblioteca.corresponsal.Entidades.Corresponsal;
import com.biblioteca.corresponsal.Model.ActualizarCorresponsalInteractor;
import com.biblioteca.corresponsal.View.ActualizarCorresponsalView;

public class ActualizarCorresponsalImprl implements ActualizarCorresponsalPresenter, ActualizarCorresponsalInteractor.OnActualizarError, ActualizarCorresponsalInteractor.OnActualizarestadohabilitarError, ActualizarCorresponsalInteractor.OnActualizarestadodeshabilitarError {
    private ActualizarCorresponsalView actualizarCorresponsalView;
    private ActualizarCorresponsalInteractor actualizarCorresponsalInteractor;

    public ActualizarCorresponsalImprl(ActualizarCorresponsalView actualizarCorresponsalView, ActualizarCorresponsalInteractor actualizarCorresponsalInteractor) {
        this.actualizarCorresponsalView = actualizarCorresponsalView;
        this.actualizarCorresponsalInteractor = actualizarCorresponsalInteractor;
    }
    @Override
    public void onSucces() {
        if(actualizarCorresponsalView != null){
            actualizarCorresponsalView.navigateTohome();
        }
    }

    @Override
    public boolean editarCorresponsal(int nit, Corresponsal corresponsal) {
        boolean correcto;
        correcto = actualizarCorresponsalInteractor.editar(nit, corresponsal, this);
        return correcto;
    }

    @Override
    public boolean editarestadohabilitar(int nit, Corresponsal corresponsal) {
        boolean correcto;
        correcto = actualizarCorresponsalInteractor.editarhabilitar(nit, corresponsal, this);
        return correcto;
    }

    @Override
    public boolean editarestadodeshabilitar(int nit, Corresponsal corresponsal) {
        boolean correcto;
        correcto = actualizarCorresponsalInteractor.editardeshabilitar(nit, corresponsal, this);
        return correcto;
    }
}
