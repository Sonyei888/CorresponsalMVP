package com.biblioteca.corresponsal.Metodos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.biblioteca.corresponsal.DbCorresponsal.DbCorresponsal;
import com.biblioteca.corresponsal.Entidades.Usuarios;

public class MtdLogin {
    Context context;

    public MtdLogin(Context context) {
        this.context = context;
    }

    public int login(Usuarios usuarios, String rol){
        int a = 0;
        Cursor user;
        DbCorresponsal dbCorresponsal = new DbCorresponsal(context);
        SQLiteDatabase db = dbCorresponsal.getWritableDatabase();

        user = db.rawQuery(" select * from usuarios", null);
        if(user != null && user.moveToFirst()){
            do{
                if(user.getString(1).equals(usuarios.getCorreo()) && user.getString(2).equals(usuarios.getContrasena()) && user.getString(3).equals(rol)){
                    a++;
                }
            }while (user.moveToNext());
        }
        return a;
    }

    public boolean insertUsuario(Usuarios u){

            boolean id = false;

            try {


                DbCorresponsal dbCorresponsal= new DbCorresponsal(context);
                SQLiteDatabase db = dbCorresponsal.getWritableDatabase();

                ContentValues values = new ContentValues();


                values.put("correo", u.getCorreo());
                values.put("contraseña", u.getContrasena());
                values.put("Rol", "Banco");

                id = (db.insert("usuarios", null, values)>0);

            } catch (Exception ex) {
                ex.toString();
            }
            return id;
    }

}
