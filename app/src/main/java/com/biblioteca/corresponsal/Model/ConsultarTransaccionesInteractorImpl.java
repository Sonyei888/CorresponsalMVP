package com.biblioteca.corresponsal.Model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.biblioteca.corresponsal.DbCorresponsal.DbCorresponsal;
import com.biblioteca.corresponsal.Entidades.Corresponsal;
import com.biblioteca.corresponsal.Entidades.Transacciones;

import java.util.ArrayList;

public class ConsultarTransaccionesInteractorImpl implements ConsultarTransaccionesInteractor{
    Context context;

    public ConsultarTransaccionesInteractorImpl(Context context) {
        this.context = context;
    }

    @Override
    public ArrayList<Transacciones> ver(OnTransaccionesError listener) {

        DbCorresponsal dbHelper = new DbCorresponsal(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Transacciones> listatransacciones = new ArrayList<>();
        Corresponsal corresponsal;
        Transacciones transacciones;
        Cursor cursorcorresponsal;

        cursorcorresponsal = db.rawQuery("SELECT * FROM transacciones " , null);
        if(cursorcorresponsal.moveToFirst()){
            do{
                transacciones = new Transacciones();
                transacciones.setId(cursorcorresponsal.getInt(0));
                transacciones.setFecha(cursorcorresponsal.getString(1));
                transacciones.setTipo_transaccion(cursorcorresponsal.getString(2));
                transacciones.setMonto_trasaccion(cursorcorresponsal.getString(3));
                transacciones.setNumero_tarjeta(cursorcorresponsal.getString(4));
                transacciones.setNumero_cedula(cursorcorresponsal.getString(5));
                transacciones.setValor(cursorcorresponsal.getString(6));

                listatransacciones.add(transacciones);
            }while (cursorcorresponsal.moveToNext());

        }
        cursorcorresponsal.close();
        return listatransacciones;
    }
}
