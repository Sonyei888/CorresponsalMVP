package com.biblioteca.corresponsal.Exitosa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.biblioteca.corresponsal.CorresFuncionalidades;
import com.biblioteca.corresponsal.R;

public class DepositoExitoso extends AppCompatActivity {

    TextView tipo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaccion_exitosa);
        tipo = findViewById(R.id.tipo_transaccion);
        tipo.setText("Deposito exitoso");
        findViewById(R.id.btn_transaccion_exitosa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(DepositoExitoso.this, CorresFuncionalidades.class);
                startActivity(intent2);
                finish();
            }
        });
    }
}