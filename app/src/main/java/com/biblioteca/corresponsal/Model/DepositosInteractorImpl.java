package com.biblioteca.corresponsal.Model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.biblioteca.corresponsal.DbCorresponsal.DbCorresponsal;
import com.biblioteca.corresponsal.Entidades.Clientes;
import com.biblioteca.corresponsal.Entidades.Corresponsal;

import java.util.ArrayList;

public class DepositosInteractorImpl implements DepositosInteractor {
    Context context;

    public DepositosInteractorImpl(Context context) {
        this.context = context;
    }

    @Override
    public Clientes consultarcedula(String cedula, OnDepositosError listener) {
        DbCorresponsal dbCorresponsal = new DbCorresponsal(context);
        ArrayList<Clientes> listanombre = new ArrayList<>();
        Clientes clientes = null;
        Cursor cursorclientes;
        SQLiteDatabase db = dbCorresponsal.getWritableDatabase();

        cursorclientes = db.rawQuery(" select * from clientes where cedula= '"+cedula+"'", null);

        if(cursorclientes.moveToNext()){
            do{
                clientes = new Clientes();
                clientes.setId(cursorclientes.getInt(0));
                clientes.setNombre(cursorclientes.getString(1));
                clientes.setCedula(cursorclientes.getString(2));
                clientes.setPin(cursorclientes.getString(3));
                clientes.setSaldo(cursorclientes.getString(4));
                clientes.setCuenta(cursorclientes.getString(5));
                listanombre.add(clientes);
            }while (cursorclientes.moveToNext());

        }
        return clientes;
    }


    @Override
    public boolean editarsaldo(String cedula, String saldo, Clientes clientes, OnDepositosError listener) {
        boolean correcto = false;

        DbCorresponsal dbCorresponsal = new DbCorresponsal(context);
        SQLiteDatabase db = dbCorresponsal.getWritableDatabase();

        try {
            db.execSQL(" UPDATE clientes SET Saldo = '"+saldo+"' " +
                    "WHERE cedula= '"+cedula+"' ");
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
