package com.biblioteca.corresponsal.Model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.biblioteca.corresponsal.DbCorresponsal.DbCorresponsal;
import com.biblioteca.corresponsal.Entidades.Clientes;
import com.biblioteca.corresponsal.Metodos.MtdClientes;

import java.util.ArrayList;

public class ConsultarClientesImpl implements ConsultarClientesInteractor{
    Context context;
    MtdClientes mtdClientes;

    public ConsultarClientesImpl(Context context) {
        this.context = context;
        mtdClientes = new MtdClientes(context);
    }

    @Override
    public Clientes consultar(String cedula_clientes, OnConsultaClientesError listener) {
        Clientes clientes = mtdClientes.mostrarclientes(cedula_clientes);
        return clientes;
    }

    @Override
    public ArrayList<Clientes> ver(OnConsultaClientesError listener) {
        DbCorresponsal dbHelper = new DbCorresponsal(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Clientes> listaclientes = new ArrayList<>();
        Clientes clientes;
        Cursor cursorclientes;

        cursorclientes = db.rawQuery("SELECT * FROM clientes " , null);
        if(cursorclientes.moveToFirst()){
            do{
                clientes = new Clientes();
                clientes.setId(cursorclientes.getInt(0));
                clientes.setNombre(cursorclientes.getString(1));
                clientes.setCuenta(cursorclientes.getString(5));
                clientes.setCedula(cursorclientes.getString(2));
                clientes.setSaldo(cursorclientes.getString(4));

                listaclientes.add(clientes);
            }while (cursorclientes.moveToNext());

        }
        cursorclientes.close();
        return listaclientes;
    }
}
