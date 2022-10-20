package com.biblioteca.corresponsal.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.biblioteca.corresponsal.DbCorresponsal.DbCorresponsal;
import com.biblioteca.corresponsal.Entidades.Transacciones;

public class TransaccionesInteractorImpl implements TransaccionesInteractor{
    Context context;

    public TransaccionesInteractorImpl(Context context) {
        this.context = context;
    }

    @Override
    public boolean insert(Transacciones transacciones, OnTransaccionError listener) {
            boolean id = false;
            try {
                DbCorresponsal dbAgenda = new DbCorresponsal(context);
                SQLiteDatabase db = dbAgenda.getWritableDatabase();

                ContentValues values = new ContentValues();

                values.put("tipo_transaccion", transacciones.getTipo_transaccion());
                values.put("monto_transaccion", transacciones.getMonto_trasaccion());
                values.put("numero_tarjeta", transacciones.getNumero_tarjeta());
                values.put("numero_cedula", transacciones.getNumero_cedula());
                values.put("valor", transacciones.getValor());

                id = (db.insert("transacciones", null, values)>0);

            } catch (Exception ex) {
                ex.toString();
            }
            return id;
    }
}
