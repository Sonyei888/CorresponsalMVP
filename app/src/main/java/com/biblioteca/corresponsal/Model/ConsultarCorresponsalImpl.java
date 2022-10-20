package com.biblioteca.corresponsal.Model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.biblioteca.corresponsal.DbCorresponsal.DbCorresponsal;
import com.biblioteca.corresponsal.Entidades.Clientes;
import com.biblioteca.corresponsal.Entidades.Corresponsal;
import com.biblioteca.corresponsal.Metodos.MtdCorresponsal;

import java.util.ArrayList;

public class ConsultarCorresponsalImpl implements ConsultarCorresponsalInteractor{
    Context context;
    MtdCorresponsal mtdCorresponsal;

    public ConsultarCorresponsalImpl(Context context) {
        this.context = context;
        mtdCorresponsal = new MtdCorresponsal(context);
    }

    @Override
    public Corresponsal consultar(String nit_corresponsal, OnConsultarError listener) {
        Corresponsal corresponsal = mtdCorresponsal.mostrarcorresponsal(nit_corresponsal);
        return corresponsal;
    }

    @Override
    public ArrayList<Corresponsal> ver(OnConsultarError listener) {
        DbCorresponsal dbHelper = new DbCorresponsal(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Corresponsal> listaclientes = new ArrayList<>();
        Corresponsal corresponsal;
        Cursor cursorcorresponsal;

        cursorcorresponsal = db.rawQuery("SELECT * FROM corresponsal " , null);
        if(cursorcorresponsal.moveToFirst()){
            do{
                corresponsal = new Corresponsal();
                corresponsal.setId_corresponsal(cursorcorresponsal.getInt(0));
                corresponsal.setNombre_corresponsal(cursorcorresponsal.getString(1));
                corresponsal.setNit_corresponsal(cursorcorresponsal.getString(2));
                corresponsal.setCuenta_corresponsal(cursorcorresponsal.getString(6));
                corresponsal.setEstado_corresponsal(cursorcorresponsal.getString(7));
                corresponsal.setSaldo_corresponsal(cursorcorresponsal.getString(5));

                listaclientes.add(corresponsal);
            }while (cursorcorresponsal.moveToNext());

        }
        cursorcorresponsal.close();
        return listaclientes;
    }
}
