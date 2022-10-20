package com.biblioteca.corresponsal.Metodos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.biblioteca.corresponsal.DbCorresponsal.DbCorresponsal;
import com.biblioteca.corresponsal.Entidades.Clientes;
import com.biblioteca.corresponsal.Entidades.Corresponsal;

import java.util.ArrayList;

public class MtdClientes {
    ArrayList<Clientes> listaclientes;
    Context context;

    public MtdClientes(Context context) {
        this.context = context;
    }

    public boolean insertClientes(Clientes clientes){
        if(buscar(clientes.getCedula())==0) {


            boolean id = true;

            try {


                DbCorresponsal dbAgenda = new DbCorresponsal(context);
                SQLiteDatabase db = dbAgenda.getWritableDatabase();

                ContentValues values = new ContentValues();

                values.put("nombre", clientes.getNombre());
                values.put("cedula", clientes.getCedula());
                values.put("pin", clientes.getPin());
                values.put("Saldo", clientes.getSaldo());
                values.put("cuenta", numerotarjeta(clientes.getCedula()));

                id = (db.insert("clientes", null, values)>0);

            } catch (Exception ex) {
                ex.toString();
            }
            return id;
        }else{
            return false;
        }
    }
    //recorrer tabla usuarios
    public ArrayList<Clientes> selectUsuarios(){

        Cursor user;
        DbCorresponsal dbCorresponsal= new DbCorresponsal(context);
        SQLiteDatabase db = dbCorresponsal.getWritableDatabase();


        ArrayList<Clientes> listauser =new ArrayList<>();
        listauser.clear();

        user = db.rawQuery("SELECT * FROM clientes" , null);

        if(user != null && user.moveToFirst()){
            do{
                Clientes clientes = new Clientes();
                clientes.setCedula(user.getString(2));
                listauser.add(clientes);
            }while (user.moveToNext());

        }
        return listauser;
    }
    //buscar usuario ya registrado
    public int buscar (String u){
        int x=0;
        listaclientes=selectUsuarios();
        for (Clientes us:listaclientes) {
            if(us.getCedula().equals(u)){
                x++;
            }
        }
        return x;
    }

    //buscar clientes con la cedula

    public Clientes mostrarclientes(String cedula_clientes){

        Cursor user;
        DbCorresponsal dbCorresponsal= new DbCorresponsal(context);
        SQLiteDatabase db = dbCorresponsal.getWritableDatabase();
        Clientes clientes = null;

        user = db.rawQuery("SELECT * FROM clientes WHERE cedula = '"+ cedula_clientes +"' LIMIT 1 " , null);

        if(user != null && user.moveToFirst()){
            clientes = new Clientes();
            clientes.setId(user.getInt(0));
            clientes.setNombre(user.getString(1));
            clientes.setCedula(user.getString(2));
            clientes.setPin(user.getString(3));
            clientes.setCuenta(user.getString(5));
            clientes.setSaldo(user.getString(4));

        }
        return clientes;
    }
    //buscar pin cliente
    public Clientes confirmarpin(String cedula_clientes){

        Cursor user;
        DbCorresponsal dbCorresponsal= new DbCorresponsal(context);
        SQLiteDatabase db = dbCorresponsal.getWritableDatabase();
        Clientes clientes = null;

        user = db.rawQuery("SELECT * FROM clientes WHERE nombre = '"+ cedula_clientes +"' LIMIT 1 " , null);

        if(user != null && user.moveToFirst()){
            clientes = new Clientes();
            clientes.setId(user.getInt(0));
            clientes.setNombre(user.getString(1));
            clientes.setCedula(user.getString(2));
            clientes.setPin(user.getString(3));
            clientes.setSaldo(user.getString(4));

        }
        return clientes;
    }

    public String numerotarjeta(String cedula){
        //numero entre 3-6
        int numeroinicial = (int)(Math.random()*(2-7+1)+7);
        String numerostring = Integer.toString(numeroinicial );
        String numerocedula = numerostring + cedula;
        int tamaño = numerocedula.length();
        int numero16 =0;
        while (16 > tamaño){
            numero16 = (int)(Math.random()*(1-10+1)+10);
            String numero16s = Integer.toString(numero16);
            numerocedula = numerocedula+numero16s;
            tamaño++;
        }

        return numerocedula;
    }

}
