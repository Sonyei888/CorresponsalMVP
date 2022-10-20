package com.biblioteca.corresponsal.Model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.biblioteca.corresponsal.DbCorresponsal.DbCorresponsal;
import com.biblioteca.corresponsal.Entidades.Clientes;
import com.biblioteca.corresponsal.Entidades.Corresponsal;

import java.util.ArrayList;

public class RetirosInteractorImpl implements RetirosInteractor{
    Context context;

    public RetirosInteractorImpl(Context context) {
        this.context = context;
    }

    @Override
    public Clientes verdatos(String cedula, RetiroError listener) {
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
    public boolean editarsaldo(Corresponsal corresponsal, RetiroError listener) {
        boolean correcto = false;
        String nit = corresponsal.getNit_corresponsal();
        int saldo_inicial = Integer.parseInt(corresponsal.getSaldo_corresponsal());
        int resultado = saldo_inicial + 2000;
        String saldo_final = Integer.toString(resultado);

        DbCorresponsal dbCorresponsal = new DbCorresponsal(context);
        SQLiteDatabase db = dbCorresponsal.getWritableDatabase();

        try {
            db.execSQL(" UPDATE corresponsal SET saldo_corresponsal = '"+saldo_final+"' " +
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

    @Override
    public boolean editar(String monto, Clientes clientes, RetiroError listener) {
        boolean correcto = false;
        int monto_retiro = Integer.parseInt(monto);
        String cedula = clientes.getCedula();
        int saldo_inicial = Integer.parseInt(clientes.getSaldo());
        int resultado_inicial = saldo_inicial - 2000;
        int resultado = resultado_inicial - monto_retiro;
        String saldo_final = Integer.toString(resultado);

        DbCorresponsal dbCorresponsal = new DbCorresponsal(context);
        SQLiteDatabase db = dbCorresponsal.getWritableDatabase();

        try {
            db.execSQL(" UPDATE clientes SET Saldo = '"+saldo_final+"' " +
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
