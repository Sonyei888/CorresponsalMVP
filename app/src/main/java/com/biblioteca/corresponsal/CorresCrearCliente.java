package com.biblioteca.corresponsal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.biblioteca.corresponsal.Cancelados.CrearClienteCancelaodo;
import com.biblioteca.corresponsal.DbCorresponsal.DbCorresponsal;
import com.biblioteca.corresponsal.Entidades.Clientes;
import com.biblioteca.corresponsal.Entidades.Corresponsal;
import com.biblioteca.corresponsal.Presenter.CrearClientePresenter;

public class CorresCrearCliente extends Activity implements View.OnClickListener {

    private EditText edit_nombre_crear_cliente;
    private EditText edit_cedula_crear_cliente;
    private EditText edit_saldo_crear_cliente;
    private CrearClientePresenter presenter;
    private Corresponsal corresponsal;
    DbCorresponsal dbCorresponsal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_crear_cliente);

        edit_nombre_crear_cliente = findViewById(R.id.edit_nombre_crear_cliente);
        edit_cedula_crear_cliente = findViewById(R.id.edit_cedula_crear_cliente);
        edit_saldo_crear_cliente = findViewById(R.id.edit_saldo_iniciar_cliente);
        corresponsal = new Corresponsal();
        findViewById(R.id.btn_confirmar).setOnClickListener(this);
        findViewById(R.id.btn_cancelar).setOnClickListener(this);
        Bundle extras = getIntent().getExtras();

    }
    public void devolver(View v){
        switch (v.getId()){
            case R.id.regresar_crear_cliente:
                Intent intent = new Intent(CorresCrearCliente.this, CorresFuncionalidades.class);
                startActivity(intent);
                finish();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_confirmar:
                Clientes clientes = new Clientes();
                clientes.setNombre(edit_nombre_crear_cliente.getText().toString());
                clientes.setCedula(edit_cedula_crear_cliente.getText().toString());
                clientes.setSaldo(edit_saldo_crear_cliente.getText().toString());
                if (!clientes.getNombre().isEmpty() && !clientes.getCedula().isEmpty() && !clientes.getSaldo().isEmpty()) {
                    Intent intent = new Intent(CorresCrearCliente.this, CorresIngresarPin.class);
                    intent.putExtra("llave", clientes);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Campos vacios", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.btn_cancelar:
                Intent intent2 = new Intent(CorresCrearCliente.this, CrearClienteCancelaodo.class);
                startActivity(intent2);
                finish();
                break;
        }
    }

}
