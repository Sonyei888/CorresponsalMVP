package com.biblioteca.corresponsal.Model;

import android.content.Context;

import com.biblioteca.corresponsal.Entidades.Corresponsal;
import com.biblioteca.corresponsal.Metodos.MtdCorresponsal;

public class DatosImpl implements DatosInteractor{
    Context context;
    MtdCorresponsal mtdCorresponsal;
    public DatosImpl(Context context) {
        this.context = context;
        mtdCorresponsal = new MtdCorresponsal(context);
    }

    @Override
    public Corresponsal verdatos(String correo, OnDatosError listener) {
        Corresponsal corresponsal= mtdCorresponsal.verdatos(correo);
        return corresponsal;
    }
}
