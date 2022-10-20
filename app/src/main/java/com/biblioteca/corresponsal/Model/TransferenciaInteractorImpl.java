package com.biblioteca.corresponsal.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.biblioteca.corresponsal.DbCorresponsal.DbCorresponsal;
import com.biblioteca.corresponsal.Entidades.Clientes;
import com.biblioteca.corresponsal.Entidades.Corresponsal;

public class TransferenciaInteractorImpl implements TransferenciaInteractor{
    Context context;

    public TransferenciaInteractorImpl(Context context) {
        this.context = context;
    }

    @Override
    public boolean editarcliente1(String cedula1, String saldo1, Clientes clientes, OnTransferenciaError listener) {
        boolean correcto = false;

        DbCorresponsal dbCorresponsal = new DbCorresponsal(context);
        SQLiteDatabase db = dbCorresponsal.getWritableDatabase();

        try {
            db.execSQL(" UPDATE clientes SET Saldo = '"+saldo1+"' " +
                    "WHERE cedula= '"+cedula1+"' ");
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

    @Override
    public boolean editarcliente2(String cedula2, String saldo2, Clientes clientes, OnTransferenciaError listener) {
        boolean correcto = false;

        DbCorresponsal dbCorresponsal = new DbCorresponsal(context);
        SQLiteDatabase db = dbCorresponsal.getWritableDatabase();

        try {
            db.execSQL(" UPDATE clientes SET Saldo = '"+saldo2+"' " +
                    "WHERE cedula= '"+cedula2+"' ");
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

    @Override
    public boolean saldocorres(String nit, Corresponsal corresponsal, OnTransferenciaError listener) {
        boolean correcto = false;
        String estado = "habilitado";
        int saldo = Integer.parseInt(corresponsal.getSaldo_corresponsal());
        int saldoint = saldo + 1000;
        String saldo_total = Integer.toString(saldoint);

        DbCorresponsal dbCorresponsal = new DbCorresponsal(context);
        SQLiteDatabase db = dbCorresponsal.getWritableDatabase();

        try {
            db.execSQL(" UPDATE corresponsal SET saldo_corresponsal = '"+saldo_total+"' " +
                    "WHERE nit_corresponsal= '"+nit+"' ");
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
