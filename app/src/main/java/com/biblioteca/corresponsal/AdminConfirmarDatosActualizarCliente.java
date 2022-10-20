package com.biblioteca.corresponsal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.biblioteca.corresponsal.Entidades.Clientes;
import com.biblioteca.corresponsal.Exitosa.ActualizarCorresponsalExitoso;
import com.biblioteca.corresponsal.Model.ActualizarClientesImpl;
import com.biblioteca.corresponsal.Presenter.ActualizarClientesImprl;
import com.biblioteca.corresponsal.Presenter.ActualizarClientesPresenter;
import com.biblioteca.corresponsal.View.ActualizarClientesView;

public class AdminConfirmarDatosActualizarCliente extends Activity implements ActualizarClientesView, View.OnClickListener {

    private Clientes clientes;
    private TextView nombre_cliente;
    private TextView cedula_cliente;
    private TextView pin_cliente;
    private ActualizarClientesPresenter presenter;
    private boolean correcto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_confirmar_datos_actualizar_cliente);
        nombre_cliente = findViewById(R.id.nombre_cliente_confirmar_datos_actualizar);
        cedula_cliente = findViewById(R.id.numero_cedula_confirmar_datos_actualizar);
        pin_cliente = findViewById(R.id.pin_confirmar_datos_actualizar);
        findViewById(R.id.btn_aceptar_confirmar_datos_actualizar).setOnClickListener(this);
        findViewById(R.id.btn_cancelar_confirmar_datos_actualizar).setOnClickListener(this);
        clientes = new Clientes();
        presenter = new ActualizarClientesImprl(this, new ActualizarClientesImpl(this));

        Bundle extras = getIntent().getExtras();
        clientes = (Clientes) extras.getSerializable("llave12");

        if(clientes != null){
            nombre_cliente.setText(clientes.getNombre());
            cedula_cliente.setText(clientes.getCedula());
            pin_cliente.setText(clientes.getPin());
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_aceptar_confirmar_datos_actualizar:
                int cedula1  = clientes.getId();
                correcto = presenter.editarclientes(cedula1, clientes);
                if(correcto){
                    Toast.makeText(this, "Actualizando...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AdminConfirmarDatosActualizarCliente.this, ActualizarCorresponsalExitoso.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(this, "ERROR AL MODIFICAR REGISTRO", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btn_cancelar_confirmar_datos_actualizar:
                Intent intent2 = new Intent(AdminConfirmarDatosActualizarCliente.this, AdminFuncionalidades.class);
                startActivity(intent2);
                finish();
                break;
        }
    }

    @Override
    public void navigatetohome() {

    }
}