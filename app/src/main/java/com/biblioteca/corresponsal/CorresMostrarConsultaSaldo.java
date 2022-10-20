package com.biblioteca.corresponsal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.biblioteca.corresponsal.Entidades.Clientes;

public class CorresMostrarConsultaSaldo extends AppCompatActivity implements View.OnClickListener {
     private Clientes clientes;
     private TextView nombre;
     private TextView cedula;
     private TextView saldo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corres_mostrar_consulta_saldo);
        nombre = findViewById(R.id.nombre_cliente_consulta_saldo);
        cedula = findViewById(R.id.numero_cedula_consulta_saldo);
        saldo = findViewById(R.id.saldo_cliente_consulta_saldo);
        findViewById(R.id.btn_aceptar_confirmar_consulta_saldo).setOnClickListener(this);
        clientes = new Clientes();
        Bundle extras = getIntent().getExtras();
        clientes = (Clientes) extras.getSerializable("llave31");
        if(clientes != null){
            nombre.setText(clientes.getNombre());
            cedula.setText(clientes.getCedula());
            saldo.setText(clientes.getSaldo());
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_aceptar_confirmar_consulta_saldo:
                Intent intent = new Intent(CorresMostrarConsultaSaldo.this, CorresFuncionalidades.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}