package com.biblioteca.corresponsal.Presenter;

import com.biblioteca.corresponsal.Entidades.Corresponsal;
import com.biblioteca.corresponsal.Model.CrearClienteImpl;
import com.biblioteca.corresponsal.Model.CrearCorresponsalInteractor;
import com.biblioteca.corresponsal.View.CrearCorresponsalView;

public class CrearCorresponsalPresenterImpl implements CrearCorresponsalPresenter, CrearCorresponsalInteractor.OnCrearError{
    private CrearCorresponsalView crearCorresponsalView;
    private CrearCorresponsalInteractor crearCorresponsalInteractor;

    public CrearCorresponsalPresenterImpl(CrearCorresponsalView crearCorresponsalView, CrearCorresponsalInteractor crearCorresponsalInteractor) {
        this.crearCorresponsalView = crearCorresponsalView;
        this.crearCorresponsalInteractor = crearCorresponsalInteractor;
    }

    @Override
    public void onSucces() {
        if(crearCorresponsalView != null){
            crearCorresponsalView.navigateTonext();
        }
    }

    @Override
    public void insertarCorresponsal(Corresponsal corresponsal) {
        crearCorresponsalInteractor.registrarcorresponsal(corresponsal, this);
    }

    @Override
    public void onDestroy() {
        crearCorresponsalInteractor = null;
    }
}
