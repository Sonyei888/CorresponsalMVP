package com.biblioteca.corresponsal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.biblioteca.corresponsal.Cancelados.RegistroCorresCancelado;
import com.biblioteca.corresponsal.Entidades.Corresponsal;

public class AdminCrearCorresponsal extends AppCompatActivity implements View.OnClickListener{
    private Corresponsal corresponsal;
    private EditText nombre_corresponsal;
    private EditText nit_corresponsal;
    private EditText correo_corresponsal;
    private EditText contrasena_corresponsal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_crear_corresponsal);
        nombre_corresponsal = findViewById(R.id.edit_nombre_corresponsal);
        nit_corresponsal = findViewById(R.id.edit_nit_corresponsal);
        correo_corresponsal = findViewById(R.id.edit_correo_corresponsal);
        contrasena_corresponsal = findViewById(R.id.edit_contraseña_corresponsal);

        findViewById(R.id.btn_confirmar_corresponsal).setOnClickListener(this);
        findViewById(R.id.btn_cancelar_corresponsal).setOnClickListener(this);

    }
    public void devolvercorresponsal(View v){
        switch (v.getId()){
            case R.id.regresar_crear_corresponal:
                Intent intent = new Intent(AdminCrearCorresponsal.this, AdminFuncionalidades.class);
                startActivity(intent);
                finish();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_confirmar_corresponsal:
                Corresponsal corresponsal = new Corresponsal();
                corresponsal.setNombre_corresponsal(nombre_corresponsal.getText().toString());
                corresponsal.setNit_corresponsal(nit_corresponsal.getText().toString());
                corresponsal.setCorreo_corresponsal(correo_corresponsal.getText().toString());
                corresponsal.setContraseña_corresponsal(contrasena_corresponsal.getText().toString());
                if(!corresponsal.getNombre_corresponsal().equals("") && !corresponsal.getNit_corresponsal().equals("") && !corresponsal.getContraseña_corresponsal().isEmpty()){
                    Intent intent = new Intent(AdminCrearCorresponsal.this, AdminConfirmarDatosCorresponsal.class);
                    intent.putExtra("llave6", corresponsal);
                    startActivity(intent);
                }else{
                    Toast.makeText(this, "Campos vacios", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_cancelar_corresponsal:
                Intent intent2 = new Intent(AdminCrearCorresponsal.this, RegistroCorresCancelado.class);
                startActivity(intent2);
                finish();
                break;
        }
    }
}