package com.biblioteca.corresponsal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.biblioteca.corresponsal.Entidades.Clientes;
import com.biblioteca.corresponsal.Entidades.Corresponsal;

import java.util.Objects;

public class AdminConfirmarPin extends AppCompatActivity implements View.OnClickListener{

    private EditText edit_pin_confirmar;
    Clientes clientes;
    private Corresponsal corresponsal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_confirmar_pin);

        edit_pin_confirmar = findViewById(R.id.edit_pin_confirmar);
        findViewById(R.id.btn_aceptar_confirmar).setOnClickListener(this);
        findViewById(R.id.btn_cancelar_pin_confirmar).setOnClickListener(this);
        clientes = new Clientes();
        corresponsal = new Corresponsal();
        Bundle extras = getIntent().getExtras();
        clientes = (Clientes) extras.getSerializable("llave1");
        /*corresponsal = (Corresponsal) extras.getSerializable("llave29");*/


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_aceptar_confirmar:
                String confirmarpin = edit_pin_confirmar.getText().toString();
                String confirmar = clientes.getPin();
                if(Objects.equals(confirmar, confirmarpin)){
                    Intent intent2 = new Intent(AdminConfirmarPin.this, AdminConfirmarDatosClientes.class);
                    intent2.putExtra("llave3", clientes);
                    startActivity(intent2);
                }else {
                    Toast.makeText(this, "pin incorrecto", Toast.LENGTH_SHORT).show();
                    Intent intent3 = new Intent(AdminConfirmarPin.this, AdminCrearCliente.class);
                    startActivity(intent3);
                    finish();
                    return;
                }
                break;
            case R.id.btn_cancelar_pin_confirmar:
                Intent intent2 = new Intent(AdminConfirmarPin.this, AdminFuncionalidades.class);
                startActivity(intent2);
                finish();
                break;
        }
    }
}