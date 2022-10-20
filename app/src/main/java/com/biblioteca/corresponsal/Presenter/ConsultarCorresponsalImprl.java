package com.biblioteca.corresponsal.Presenter;

import com.biblioteca.corresponsal.Entidades.Corresponsal;
import com.biblioteca.corresponsal.Model.ConsultarCorresponsalInteractor;
import com.biblioteca.corresponsal.View.ConsultarCorresponsalView;

import java.util.ArrayList;

public class ConsultarCorresponsalImprl implements ConsultarCorresponsalPresenter, ConsultarCorresponsalInteractor.OnConsultarError {

    private ConsultarCorresponsalView consultarCorresponsalView;
    private ConsultarCorresponsalInteractor consultarCorresponsalInteractor;

    public ConsultarCorresponsalImprl(ConsultarCorresponsalView consultarCorresponsalView, ConsultarCorresponsalInteractor consultarCorresponsalInteractor) {
        this.consultarCorresponsalView = consultarCorresponsalView;
        this.consultarCorresponsalInteractor = consultarCorresponsalInteractor;
    }

    @Override
    public Corresponsal mostrarcorresponsal(String nit_corresponsal) {
        Corresponsal corresponsal = consultarCorresponsalInteractor.consultar(nit_corresponsal, this);
        return corresponsal;
    }

    @Override
    public ArrayList<Corresponsal> vercorresponsal() {
        ArrayList<Corresponsal> corresponsal;
        corresponsal = consultarCorresponsalInteractor.ver(this);
        return corresponsal;
    }

    @Override
    public void onSucces() {
        if(consultarCorresponsalView != null){
            consultarCorresponsalView.navigateTohome();
        }
    }
}
