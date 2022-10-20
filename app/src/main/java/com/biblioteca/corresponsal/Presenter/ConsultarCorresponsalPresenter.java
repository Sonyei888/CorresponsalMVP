package com.biblioteca.corresponsal.Presenter;

import com.biblioteca.corresponsal.Entidades.Corresponsal;

import java.util.ArrayList;

public interface ConsultarCorresponsalPresenter {
    Corresponsal mostrarcorresponsal(String nit_corresponsal);
    ArrayList<Corresponsal> vercorresponsal();

}
