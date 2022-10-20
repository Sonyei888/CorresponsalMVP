package com.biblioteca.corresponsal.Metodos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.biblioteca.corresponsal.DbCorresponsal.DbCorresponsal;
import com.biblioteca.corresponsal.Entidades.Clientes;
import com.biblioteca.corresponsal.Entidades.Corresponsal;
import com.biblioteca.corresponsal.Model.ConsultarCorresponsalInteractor;

import java.util.ArrayList;

public class MtdCorresponsal {
    ArrayList<Corresponsal> listacorresponsal;
    Context context;

    public MtdCorresponsal(Context context) {
        this.context = context;
    }

    public boolean insertCorresponsal(Corresponsal corresponsal){
        if(buscar(corresponsal.getNit_corresponsal())==0) {


            boolean id = false;

            try {


                DbCorresponsal dbAgenda = new DbCorresponsal(context);
                SQLiteDatabase db = dbAgenda.getWritableDatabase();

                ContentValues values = new ContentValues();
                ContentValues values1 = new ContentValues();

                values.put("nombre_corresponsal", corresponsal.getNombre_corresponsal());
                values.put("nit_corresponsal", corresponsal.getNit_corresponsal());
                values.put("correo_corresponsal", corresponsal.getCorreo_corresponsal());
                values.put("contraseña_corresponsal", corresponsal.getContraseña_corresponsal());
                values.put("saldo_corresponsal", "0");
                values.put("cuenta_corresponsal", "000001");
                values.put("estado", "habilitado");
                values1.put("correo", corresponsal.getCorreo_corresponsal());
                values1.put("contraseña", corresponsal.getContraseña_corresponsal());
                values1.put("Rol", "Corresponsal");

                id = (db.insert("corresponsal", null, values)>0);
                id = (db.insert("usuarios", null, values1)>0);

            } catch (Exception ex) {
                ex.toString();
            }
            return id;
        }else{
            return false;
        }
    }
    //recorrer tabla usuarios
    public ArrayList<Corresponsal> selectUsuarios(){

        Cursor user;
        DbCorresponsal dbCorresponsal= new DbCorresponsal(context);
        SQLiteDatabase db = dbCorresponsal.getWritableDatabase();


        ArrayList<Corresponsal> listauser =new ArrayList<>();
        listauser.clear();

        user = db.rawQuery("SELECT * FROM corresponsal" , null);

        if(user != null && user.moveToFirst()){
            do{
                Corresponsal corresponsal = new Corresponsal();
                corresponsal.setId_corresponsal(user.getInt(0));
                corresponsal.setNombre_corresponsal(user.getString(1));
                corresponsal.setNit_corresponsal(user.getString(2));
                corresponsal.setCorreo_corresponsal(user.getString(3));
                corresponsal.setContraseña_corresponsal(user.getString(4));

                listauser.add(corresponsal);
            }while (user.moveToNext());

        }
        return listauser;
    }
    //buscar usuario ya registrado
    public int buscar (String u){
        int x=0;
        listacorresponsal=selectUsuarios();
        for (Corresponsal us:listacorresponsal) {
            if(us.getNit_corresponsal().equals(u)){
                x++;
            }

        }
        return x;
    }
    //buscar corresponsal con el nit

    public Corresponsal mostrarcorresponsal(String nit_corresponsal){

        Cursor user;
        DbCorresponsal dbCorresponsal= new DbCorresponsal(context);
        SQLiteDatabase db = dbCorresponsal.getWritableDatabase();
        Corresponsal corresponsal = null;

        user = db.rawQuery("SELECT * FROM corresponsal WHERE nit_corresponsal = '"+ nit_corresponsal +"' LIMIT 1 " , null);

        if(user != null && user.moveToFirst()){
            corresponsal = new Corresponsal();
                corresponsal.setId_corresponsal(user.getInt(0));
                corresponsal.setNombre_corresponsal(user.getString(1));
                corresponsal.setNit_corresponsal(user.getString(2));
                corresponsal.setCorreo_corresponsal(user.getString(3));
                corresponsal.setContraseña_corresponsal(user.getString(4));
                corresponsal.setSaldo_corresponsal(user.getString(5));
        }
        return corresponsal;
    }

    //ver nombre, saldo y cuenta

    public Corresponsal verdatos(String nit){
        DbCorresponsal dbCorresponsal = new DbCorresponsal(context);
        ArrayList<Corresponsal> listanombre = new ArrayList<>();
        Corresponsal corresponsal = null;
        Cursor cursorcorresponsal;
        SQLiteDatabase db = dbCorresponsal.getWritableDatabase();

        cursorcorresponsal = db.rawQuery(" select * from corresponsal where correo_corresponsal= '"+nit+"'", null);

        if(cursorcorresponsal.moveToNext()){
            do{
                corresponsal = new Corresponsal();
                corresponsal.setId_corresponsal(cursorcorresponsal.getInt(0));
                corresponsal.setCorreo_corresponsal(cursorcorresponsal.getString(3));
                corresponsal.setNombre_corresponsal(cursorcorresponsal.getString(1));
                corresponsal.setCuenta_corresponsal(cursorcorresponsal.getString(6));
                corresponsal.setContraseña_corresponsal(cursorcorresponsal.getString(4));
                corresponsal.setNit_corresponsal(cursorcorresponsal.getString(2));
                corresponsal.setSaldo_corresponsal(cursorcorresponsal.getString(5));
                listanombre.add(corresponsal);
            }while (cursorcorresponsal.moveToNext());
        }
        return corresponsal;
    }
}
