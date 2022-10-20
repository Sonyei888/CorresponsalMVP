package com.biblioteca.corresponsal.Model;

import com.biblioteca.corresponsal.Entidades.Corresponsal;

public interface DatosInteractor {
    interface OnDatosError{
        void OnSucess();
    }
    Corresponsal verdatos(String correo, OnDatosError listener);
}
