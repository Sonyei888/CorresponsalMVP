package com.biblioteca.corresponsal.Entidades;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreference {
    Context context;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public SharedPreference(Context context) {
        this.context = context;

        sharedPreferences = context.getSharedPreferences("DatosCorresponsal", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
    public void setCorreoCorresponsal(String nitCorresponsal){
        editor.putString("nit_corresponsal", nitCorresponsal);
        editor.apply();
    }
    public String getCorreoCorresponsal(){
        return sharedPreferences.getString("nit_corresponsal", "NO ENCONTRADO");
    }
}
