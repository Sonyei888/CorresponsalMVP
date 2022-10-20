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

public class AdminActualizarClientes extends AppCompatActivity implements View.OnClickListener{

    private EditText nombre_actualizar_cliente;
    private EditText cedula_actualizar_cliente;
    private EditText pin_actualizar_cliente;
    private EditText confirmar_pin_actualizar_cliente;
    private Clientes clientes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_actualizar_clientes);
        nombre_actualizar_cliente = findViewById(R.id.edit_nombre_actualizar_cliente);
        cedula_actualizar_cliente = findViewById(R.id.edit_cedula_actualizar_cliente);
        pin_actualizar_cliente = findViewById(R.id.edit_pin_actualizar_cliente);
        confirmar_pin_actualizar_cliente = findViewById(R.id.edit_confirmar_pin_actualizar_cliente);
        findViewById(R.id.btn_confirmar_actualizar_cliente).setOnClickListener(this);
        findViewById(R.id.btn_cancelar_actualizar_cliente).setOnClickListener(this);
        clientes = new Clientes();

        Bundle extras = getIntent().getExtras();
        clientes = (Clientes) extras.getSerializable("llave11");

        if(clientes != null){
            nombre_actualizar_cliente.setText(clientes.getNombre());
            cedula_actualizar_cliente.setText(clientes.getCedula());
            pin_actualizar_cliente.setText(clientes.getPin());
            confirmar_pin_actualizar_cliente.setText(clientes.getPin());
        }
    }
    public void devolveracualizarcliente(View v){
        switch (v.getId()){
            case R.id.regresar_actualizar_corresponal:
                Intent intent = new Intent(AdminActualizarClientes.this, AdminFuncionalidades.class);
                startActivity(intent);
                finish();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_confirmar_actualizar_cliente:
                String nombre = nombre_actualizar_cliente.getText().toString();
                String cedula = cedula_actualizar_cliente.getText().toString();
                String pin = pin_actualizar_cliente.getText().toString();
                String confirmar_pin = confirmar_pin_actualizar_cliente.getText().toString();
                if (!nombre.isEmpty() && !cedula.isEmpty() && !pin.isEmpty() && !confirmar_pin.isEmpty()) {
                    if (Objects.equals(pin, confirmar_pin)) {
                        clientes.setNombre(nombre);
                        clientes.setCedula(cedula);
                        clientes.setPin(confirmar_pin);
                        Intent intent = new Intent(AdminActualizarClientes.this, AdminConfirmarDatosActualizarCliente.class);
                        intent.putExtra("llave12", clientes);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(AdminActualizarClientes.this, "ERROR PIN", Toast.LENGTH_LONG).show();
                        Intent intent3 = new Intent(AdminActualizarClientes.this, AdminConsultarCedulaClientes.class);
                        startActivity(intent3);
                        finish();
                    }
                } else {
                    Toast.makeText(AdminActualizarClientes.this, "DEBE LLENAR LOS CAMPOS OBLIGATORIOS", Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.btn_cancelar_actualizar_cliente:
                Intent intent2 = new Intent(AdminActualizarClientes.this, AdminFuncionalidades.class);
                startActivity(intent2);
                finish();
                break;
        }
    }
}