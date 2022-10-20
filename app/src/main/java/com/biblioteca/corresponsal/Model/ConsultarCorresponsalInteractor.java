package com.biblioteca.corresponsal.Model;

import com.biblioteca.corresponsal.Entidades.Corresponsal;

import java.util.ArrayList;

public interface ConsultarCorresponsalInteractor {
    interface OnConsultarError{
        void onSucces();
    }
    Corresponsal consultar(String nit_corresponsal, OnConsultarError listener);
    ArrayList<Corresponsal> ver(OnConsultarError listener);
}
