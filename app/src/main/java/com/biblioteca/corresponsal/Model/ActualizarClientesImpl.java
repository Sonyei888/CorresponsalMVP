package com.biblioteca.corresponsal.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.biblioteca.corresponsal.DbCorresponsal.DbCorresponsal;
import com.biblioteca.corresponsal.Entidades.Clientes;
import com.biblioteca.corresponsal.Entidades.Corresponsal;

public class ActualizarClientesImpl implements ActualizarClientesInteractor{
    Context context;

    public ActualizarClientesImpl(Context context) {
        this.context = context;
    }


    @Override
    public boolean editar(int cedula, Clientes clientes, OnActualizarClientesError listener) {
        boolean correcto = false;


        DbCorresponsal dbCorresponsal = new DbCorresponsal(context);
        SQLiteDatabase db = dbCorresponsal.getWritableDatabase();

        try {
            db.execSQL(" UPDATE clientes SET nombre = '"+clientes.getNombre()+"',  " +
                    "cedula = '"+clientes.getCedula()+"', " +
                    "pin = '"+clientes.getPin()+"', " +
                    "Saldo = '"+clientes.getSaldo()+"' " +
                    "WHERE id= '"+cedula+"' ");
            correcto = true;

        } catch (Exception ex){
            ex.toString();
            correcto = false;
        }finally {
            {
                db.close();
            }
        }
        return correcto;
    }
}

