package com.biblioteca.corresponsal.Cancelados;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.biblioteca.corresponsal.CorresFuncionalidades;
import com.biblioteca.corresponsal.R;

public class TransferenciaCancelada extends AppCompatActivity {

    private TextView tipo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaccion_cancelada);
        tipo = findViewById(R.id.tipo_transaccion_cancelada);
        tipo.setText("Transferencia cancelada");
        findViewById(R.id.btn_transaccion_cancelada).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(TransferenciaCancelada.this, CorresFuncionalidades.class);
                startActivity(intent2);
                finish();
            }
        });
    }
}