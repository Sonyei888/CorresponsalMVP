package com.biblioteca.corresponsal.Presenter;

import com.biblioteca.corresponsal.Entidades.Clientes;
import com.biblioteca.corresponsal.Model.CrearClienteImpl;
import com.biblioteca.corresponsal.View.CrearClienteView;

public class CrearClienteImprl implements CrearClientePresenter, CrearClienteImpl.OnCrearError {
    private CrearClienteView crearClienteView;
    private CrearClienteImpl crearCliente;

    public CrearClienteImprl(CrearClienteView crearClienteView, CrearClienteImpl crearCliente) {
        this.crearClienteView = crearClienteView;
        this.crearCliente = crearCliente;
    }

    @Override
    public boolean insertarCLiente(Clientes clientes) {
        boolean correcto = crearCliente.registrar(clientes, this);
        return correcto;
    }


    @Override
    public void onDestroy() {
        crearClienteView = null;
    }

    @Override
    public void onNameError() {
        if(crearClienteView != null){
            crearClienteView.setNameError();
        }
    }

    @Override
    public void onCedulaError() {
        if(crearClienteView != null){
            crearClienteView.setCedulaError();
        }
    }

    @Override
    public void onSaldoError() {
        if(crearClienteView != null){
            crearClienteView.setSaldoError();
        }
    }

    @Override
    public void onSucces() {
        if(crearClienteView != null){
            crearClienteView.navigateTonext();
        }
    }


}
