package com.biblioteca.corresponsal.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.biblioteca.corresponsal.DbCorresponsal.DbCorresponsal;
import com.biblioteca.corresponsal.Entidades.Corresponsal;
import com.biblioteca.corresponsal.Entidades.Pago_tarjeta;

public class PagoTarjetaInteractorImpl implements PagoTarjetaInteractor{
    Context context;

    public PagoTarjetaInteractorImpl(Context context) {
        this.context = context;
    }

    @Override
    public boolean registrarpago(Pago_tarjeta pago_tarjeta, OnPagoError listener) {
        boolean id = false;

        try {


            DbCorresponsal dbAgenda = new DbCorresponsal(context);
            SQLiteDatabase db = dbAgenda.getWritableDatabase();

            ContentValues values = new ContentValues();
            ContentValues values1 = new ContentValues();

            values.put("numero_tarjeta", pago_tarjeta.getNumero_tarjeta());
            values.put("fecha_mm", pago_tarjeta.getFecha_mes());
            values.put("fecha_dd", pago_tarjeta.getFecha_dia());
            values.put("nombre_cliente", pago_tarjeta.getNombre_cliente());
            values.put("coutas", pago_tarjeta.getCuotas());
            values.put("valor", pago_tarjeta.getValor_pago());
            id = (db.insert("pagos_tarjeta", null, values)>0);

        } catch (Exception ex) {
            ex.toString();
        }
        return id;
    }

    @Override
    public boolean editarsaldo(String nit, String saldo, Corresponsal corresponsal, OnPagoError listener) {
        boolean correcto = false;
        String estado = "habilitado";

        DbCorresponsal dbCorresponsal = new DbCorresponsal(context);
        SQLiteDatabase db = dbCorresponsal.getWritableDatabase();

        try {
            db.execSQL(" UPDATE corresponsal SET saldo_corresponsal = '"+saldo+"' " +
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
