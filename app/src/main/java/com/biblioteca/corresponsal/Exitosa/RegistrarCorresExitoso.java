package com.biblioteca.corresponsal.Exitosa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.biblioteca.corresponsal.AdminFuncionalidades;
import com.biblioteca.corresponsal.R;

public class RegistrarCorresExitoso extends AppCompatActivity {

    TextView tipo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaccion_exitosa);
        tipo = findViewById(R.id.tipo_transaccion);
        tipo.setText("Creacion exitosa");
        findViewById(R.id.btn_transaccion_exitosa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(RegistrarCorresExitoso.this, AdminFuncionalidades.class);
                startActivity(intent2);
                finish();
            }
        });
    }
}