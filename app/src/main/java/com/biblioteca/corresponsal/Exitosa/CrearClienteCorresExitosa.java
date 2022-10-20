package com.biblioteca.corresponsal.Exitosa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.biblioteca.corresponsal.CorresFuncionalidades;
import com.biblioteca.corresponsal.CorresMostrarConsultaSaldo;
import com.biblioteca.corresponsal.Entidades.Clientes;
import com.biblioteca.corresponsal.R;

public class CrearClienteCorresExitosa extends AppCompatActivity {

    TextView tipo;
    private Clientes clientes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaccion_exitosa);
        tipo = findViewById(R.id.tipo_transaccion);
        tipo.setText("Consulta saldo exitosa");

        findViewById(R.id.btn_transaccion_exitosa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(CrearClienteCorresExitosa.this, CorresFuncionalidades.class);
                startActivity(intent2);
                finish();
            }
        });
    }
}