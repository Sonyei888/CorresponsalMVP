package com.biblioteca.corresponsal.Presenter;

import com.biblioteca.corresponsal.Entidades.Corresponsal;
import com.biblioteca.corresponsal.Model.DatosInteractor;
import com.biblioteca.corresponsal.View.DatosView;

public class DatosImprl implements  DatosPresenter, DatosInteractor.OnDatosError {
    private DatosView datosView;
    private DatosInteractor datosInteractor;

    public DatosImprl(DatosView datosView, DatosInteractor datosInteractor) {
        this.datosView = datosView;
        this.datosInteractor = datosInteractor;
    }

    @Override
    public void OnSucess() {
        if(datosView != null){
            datosView.navigateToHome();
        }
    }

    @Override
    public Corresponsal mostrardatos(String correo) {
        Corresponsal corresponsal = datosInteractor.verdatos(correo, this);
        return corresponsal;
    }
}
