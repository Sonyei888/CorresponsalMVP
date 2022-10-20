package com.biblioteca.corresponsal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.biblioteca.corresponsal.Cancelados.CrearClienteAdminCancelado;
import com.biblioteca.corresponsal.Entidades.Clientes;
import com.biblioteca.corresponsal.Entidades.Corresponsal;
import com.biblioteca.corresponsal.Model.CrearClienteImpl;
import com.biblioteca.corresponsal.Model.CrearClienteInteractorImpl;
import com.biblioteca.corresponsal.Presenter.CrearClienteImprl;
import com.biblioteca.corresponsal.Presenter.CrearClientePresenter;
import com.biblioteca.corresponsal.View.CrearClienteView;

public class AdminConfirmarDatosClientes extends Activity implements CrearClienteView, View.OnClickListener{

    private Clientes clientes;
    private TextView nombre_cliente;
    private TextView cedula_cliente;
    private TextView saldo_cliente;
    private CrearClientePresenter presenter;
    private Corresponsal corresponsal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_confirmar_datos_clientes);
        nombre_cliente = findViewById(R.id.nombre_cliente_confirmar_datos);
        cedula_cliente = findViewById(R.id.numero_cedula_confirmar_datos);
        saldo_cliente = findViewById(R.id.saldo_confirmar_datos);
        findViewById(R.id.btn_aceptar_confirmar_datos).setOnClickListener(this);
        findViewById(R.id.btn_cancelar_confirmar_datos).setOnClickListener(this);

        clientes = new Clientes();
        corresponsal = new Corresponsal();
        presenter = new CrearClienteImprl(this, new CrearClienteInteractorImpl(this));

        Bundle extras = getIntent().getExtras();
        clientes = (Clientes) extras.getSerializable("llave3");

        if(clientes != null){
            nombre_cliente.setText(clientes.getNombre());
            cedula_cliente.setText(clientes.getCedula());
            saldo_cliente.setText(clientes.getSaldo());
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_aceptar_confirmar_datos:
                boolean correcto = true;
                correcto = presenter.insertarCLiente(clientes);
                if (correcto == true){
                    Toast.makeText(this, "Registrando...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AdminConfirmarDatosClientes.this, AdminConsultarClientes.class);
                    intent.putExtra("llave4", clientes);
                    startActivity(intent);
                }else if(correcto == false){
                    Toast.makeText(this, "Cliente ya registrado", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(AdminConfirmarDatosClientes.this, AdminFuncionalidades.class);
                    startActivity(intent1);
                }
                break;
            case R.id.btn_cancelar_confirmar_datos:
                Intent intent2 = new Intent(AdminConfirmarDatosClientes.this, CrearClienteAdminCancelado.class);
                startActivity(intent2);
                finish();
                break;
        }
    }

    @Override
    public void setNameError() {
    }

    @Override
    public void setCedulaError() {
    }

    @Override
    public void setSaldoError() {
    }

    @Override
    public void navigateTonext() {

    }
}