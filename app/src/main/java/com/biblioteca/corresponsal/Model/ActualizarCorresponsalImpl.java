package com.biblioteca.corresponsal.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.biblioteca.corresponsal.DbCorresponsal.DbCorresponsal;
import com.biblioteca.corresponsal.Entidades.Clientes;
import com.biblioteca.corresponsal.Entidades.Corresponsal;
import com.biblioteca.corresponsal.Presenter.ActualizarCorresponsalPresenter;

public class ActualizarCorresponsalImpl implements ActualizarCorresponsalInteractor{
    ActualizarCorresponsalPresenter presenter;
    Context context;

    public ActualizarCorresponsalImpl(Context context) {
        this.context = context;

    }

    @Override
    public boolean editar(int nit, Corresponsal corresponsal, OnActualizarError listener) {
        boolean correcto = false;

        DbCorresponsal dbCorresponsal = new DbCorresponsal(context);
        SQLiteDatabase db = dbCorresponsal.getWritableDatabase();

        try {
            db.execSQL(" UPDATE corresponsal SET nombre_corresponsal = '"+corresponsal.getNombre_corresponsal()+"',  " +
                    "nit_corresponsal = '"+corresponsal.getNit_corresponsal()+"', " +
                    "correo_corresponsal = '"+corresponsal.getCorreo_corresponsal()+"', " +
                    "saldo_corresponsal = '"+corresponsal.getSaldo_corresponsal()+"', " +
                    "contraseña_corresponsal = '"+corresponsal.getContraseña_corresponsal()+"' " +
                    "WHERE id= '"+nit+"' ");

            db.execSQL(" UPDATE usuarios SET correo = '"+corresponsal.getCorreo_corresponsal()+"', " +
                    "contraseña = '"+corresponsal.getContraseña_corresponsal()+"' " +
                    "WHERE correo= '"+corresponsal.getCorreo_corresponsal()+"' ");
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
    public boolean editarhabilitar(int nit, Corresponsal corresponsal, OnActualizarestadohabilitarError listener) {
        boolean correcto = false;
        String estado = "habilitado";

        DbCorresponsal dbCorresponsal = new DbCorresponsal(context);
        SQLiteDatabase db = dbCorresponsal.getWritableDatabase();

        try {
            db.execSQL(" UPDATE corresponsal SET estado = '"+estado+"' " +
                    "WHERE id= '"+nit+"' ");
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
    public boolean editardeshabilitar(int nit, Corresponsal corresponsal, OnActualizarestadodeshabilitarError listener) {
        boolean correcto = false;
        String estado = "deshabilitado";

        DbCorresponsal dbCorresponsal = new DbCorresponsal(context);
        SQLiteDatabase db = dbCorresponsal.getWritableDatabase();

        try {
            db.execSQL(" UPDATE corresponsal SET estado = '"+estado+"' " +
                    "WHERE id= '"+nit+"' ");
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
