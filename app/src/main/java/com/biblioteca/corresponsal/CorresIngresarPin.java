package com.biblioteca.corresponsal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.biblioteca.corresponsal.Entidades.Clientes;
import com.biblioteca.corresponsal.Entidades.Corresponsal;

public class CorresIngresarPin extends AppCompatActivity implements View.OnClickListener {
    private EditText edit_pin;
    Clientes clientes;
    private Corresponsal corresponsal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_ingresar_pin);

        edit_pin = findViewById(R.id.edit_pin);
        findViewById(R.id.btn_aceptar).setOnClickListener(this);
        findViewById(R.id.btn_cancelar_pin).setOnClickListener(this);
        corresponsal = new Corresponsal();
        clientes = new Clientes();
        Bundle extras = getIntent().getExtras();
        clientes = (Clientes) extras.getSerializable("llave");


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_aceptar:
                String pin = edit_pin.getText().toString();
                if (!pin.isEmpty()) {
                    clientes.setPin(pin);
                    Intent intent2 = new Intent(CorresIngresarPin.this, CorresConfirmarPin.class);
                    intent2.putExtra("llave1", clientes);
                    intent2.putExtra("llave29", corresponsal);
                    startActivity(intent2);
                } else {
                    Toast.makeText(this, "Campos vacios", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
            case R.id.btn_cancelar_pin:
                Intent intent = new Intent(CorresIngresarPin.this, CorresFuncionalidades.class);
                startActivity(intent);
                finish();
                break;

        }
    }
}