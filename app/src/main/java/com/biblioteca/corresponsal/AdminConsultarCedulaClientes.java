package com.biblioteca.corresponsal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.biblioteca.corresponsal.Entidades.Clientes;
import com.biblioteca.corresponsal.Model.ConsultarClientesImpl;
import com.biblioteca.corresponsal.Model.ConsultarCorresponsalImpl;
import com.biblioteca.corresponsal.Presenter.ConsultarClientesImprl;
import com.biblioteca.corresponsal.Presenter.ConsultarClientesPresenter;
import com.biblioteca.corresponsal.Presenter.ConsultarCorresponsalImprl;
import com.biblioteca.corresponsal.View.ConsultarClientesView;

public class AdminConsultarCedulaClientes extends Activity implements ConsultarClientesView, View.OnClickListener{

    private EditText cedula_consultar_clientes;
    private Clientes clientes;
    private ConsultarClientesPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_consultar_cedula_clientes);
        cedula_consultar_clientes = findViewById(R.id.edit_cedula_consultar_cliente);
        findViewById(R.id.btn_confirmar_consultar_cliente).setOnClickListener(this);
        findViewById(R.id.btn_actualizar_consultar_cliente).setOnClickListener(this);
        clientes = new Clientes();
    }
    public void devolverconsultarcedulaclientes(View v){
        switch (v.getId()){
            case R.id.regresar_concultar_corresponsal:
                Intent intent = new Intent(AdminConsultarCedulaClientes.this, AdminFuncionalidades.class);
                startActivity(intent);
                finish();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_confirmar_consultar_cliente:
                String cedula = cedula_consultar_clientes.getText().toString();
                presenter = new ConsultarClientesImprl(this, new ConsultarClientesImpl(this));
                clientes = presenter.mostrarclinetes(cedula);
                if(clientes != null){
                    Intent intent = new Intent(AdminConsultarCedulaClientes.this, AdminMostrarConsultaClientes.class);
                    intent.putExtra("llave10", clientes);
                    startActivity(intent);
                }else{
                    Toast.makeText(this, "Clientes no registrado", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_actualizar_consultar_cliente:
                String cedula1 = cedula_consultar_clientes.getText().toString();
                presenter = new ConsultarClientesImprl(this, new ConsultarClientesImpl(this));
                clientes = presenter.mostrarclinetes(cedula1);
                if(clientes != null){
                    Intent intent = new Intent(AdminConsultarCedulaClientes.this, AdminActualizarClientes.class);
                    intent.putExtra("llave11", clientes);
                    startActivity(intent);
                }else{
                    Toast.makeText(this, "Clientes no registrado", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void navigatetohome() {

    }
}