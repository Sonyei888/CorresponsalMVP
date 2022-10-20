package com.biblioteca.corresponsal.DbCorresponsal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbCorresponsal extends SQLiteOpenHelper {

    public DbCorresponsal(Context context) {
        super(context, "corresponsal.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table usuarios(" +
                "id INTEGER primary key autoincrement, " +
                "correo TEXT," +
                "contraseña TEXT," +
                "Rol Text)");

        db.execSQL("create table clientes(" +
                "id INTEGER primary key autoincrement," +
                "nombre TEXT," +
                "cedula TEXT," +
                "pin TEXT, " +
                "Saldo TEXT," +
                "cuenta TEXT)");

        db.execSQL("create table corresponsal(" +
                "id INTEGER primary key autoincrement," +
                "nombre_corresponsal TEXT," +
                "nit_corresponsal TEXT," +
                "correo_corresponsal TEXT, " +
                "contraseña_corresponsal TEXT," +
                "saldo_corresponsal TEXT, " +
                "cuenta_corresponsal TEXT," +
                "estado TEXT)");

        db.execSQL("create table pagos_tarjeta(" +
                "id INTEGER primary key autoincrement," +
                "numero_tarjeta TEXT," +
                "fecha_mm TEXT," +
                "fecha_dd TEXT," +
                "nombre_cliente TEXT, " +
                "coutas TEXT," +
                "valor TEXT)");

        db.execSQL("create table transacciones(" +
                "id INTEGER primary key autoincrement," +
                "fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                "tipo_transaccion TEXT," +
                "monto_transaccion TEXT DEFAULT '0', " +
                "numero_tarjeta TEXT DEFAULT '0'," +
                "numero_cedula TEXT," +
                "valor TEXT DEFAULT '0')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists usuarios");
        db.execSQL("drop table if exists clientes");
        db.execSQL("drop table if exists corresponsal");
        db.execSQL("drop table if exists pagos_tarjeta");
        db.execSQL("drop table if exists transacciones");
    }
}
