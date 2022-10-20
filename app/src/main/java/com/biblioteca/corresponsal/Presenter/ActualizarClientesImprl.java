package com.biblioteca.corresponsal.Presenter;

import com.biblioteca.corresponsal.Entidades.Clientes;
import com.biblioteca.corresponsal.Model.ActualizarClientesInteractor;
import com.biblioteca.corresponsal.View.ActualizarClientesView;

public class ActualizarClientesImprl implements ActualizarClientesPresenter, ActualizarClientesInteractor.OnActualizarClientesError {
   private ActualizarClientesView actualizarClientesView;
   private ActualizarClientesInteractor actualizarClientesInteractor;

    public ActualizarClientesImprl(ActualizarClientesView actualizarClientesView, ActualizarClientesInteractor actualizarClientesInteractor) {
        this.actualizarClientesView = actualizarClientesView;
        this.actualizarClientesInteractor = actualizarClientesInteractor;
    }

    @Override
    public void OnSucees() {
        if(actualizarClientesView != null){
            actualizarClientesView.navigatetohome();
        }
    }

    @Override
    public boolean editarclientes(int cedula, Clientes clientes) {
        boolean correcto;
        correcto = actualizarClientesInteractor.editar(cedula, clientes, this);
        return correcto;
    }
}
