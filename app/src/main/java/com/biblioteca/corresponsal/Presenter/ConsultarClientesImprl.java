package com.biblioteca.corresponsal.Presenter;

import com.biblioteca.corresponsal.Entidades.Clientes;
import com.biblioteca.corresponsal.Model.ConsultarClientesInteractor;
import com.biblioteca.corresponsal.View.ConsultarClientesView;

import java.util.ArrayList;

public class ConsultarClientesImprl implements ConsultarClientesPresenter, ConsultarClientesInteractor.OnConsultaClientesError {
    private ConsultarClientesView consultarClientesView;
    private ConsultarClientesInteractor consultarClientesInteractor;

    public ConsultarClientesImprl(ConsultarClientesView consultarClientesView, ConsultarClientesInteractor consultarClientesInteractor) {
        this.consultarClientesView = consultarClientesView;
        this.consultarClientesInteractor = consultarClientesInteractor;
    }

    @Override
    public void OnSucess() {
        if(consultarClientesView != null){
            consultarClientesView.navigatetohome();
        }
    }

    @Override
    public Clientes mostrarclinetes(String cedula_clientes) {
        Clientes clientes = consultarClientesInteractor.consultar(cedula_clientes, this);
        return clientes;
    }

    @Override
    public ArrayList<Clientes> verclientes() {
        ArrayList<Clientes> clientes;
        clientes = consultarClientesInteractor.ver(this);
        return clientes;
    }
}
