package com.biblioteca.corresponsal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.biblioteca.corresponsal.Entidades.Clientes;
import com.biblioteca.corresponsal.Entidades.Corresponsal;

public class AdminMostrarConsultaClientes extends AppCompatActivity implements View.OnClickListener{
    private Clientes clientes;
    private TextView nombre_cliente;
    private TextView tipo_tarjeta;
    private TextView saldo_cliente;
    private TextView cuenta_cliente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_mostrar_consulta_clientes);
        nombre_cliente = findViewById(R.id.text_nombre_mostrar_cliente);
        saldo_cliente = findViewById(R.id.text_saldo_mostrar_clientes);
        cuenta_cliente = findViewById(R.id.text_numero_cuenta_mostrar);
        tipo_tarjeta = findViewById(R.id.text_tipo_tarjeta);
        findViewById(R.id.btn_aceptar_mostrar_cliente).setOnClickListener(this);
        clientes = new Clientes();
        Bundle extras = getIntent().getExtras();
        clientes = (Clientes) extras.getSerializable("llave10");

        if(clientes != null){
            nombre_cliente.setText(clientes.getNombre());
            saldo_cliente.setText(clientes.getSaldo());
            cuenta_cliente.setText(clientes.getCuenta());
            String numero = clientes.getCuenta();
            char american = '3';
            char visa = '4';
            char master = '5';
            char union = '6';
            char tarjeta = (numero.charAt(0));
            if(tarjeta == american){
                tipo_tarjeta.setText("American Express");
            }else if(tarjeta == visa){
                tipo_tarjeta.setText("VISA");
            }else if(tarjeta == master){
                tipo_tarjeta.setText("MasterCard");
            }else if(tarjeta == union){
                tipo_tarjeta.setText("UnionPay");
            }else{
                tipo_tarjeta.setText("null");
            }
        }
    }
    public void devolvermostrarclientes(View v){
        switch (v.getId()){
            case R.id.regresar_mostrar_cliente:
                Intent intent = new Intent(AdminMostrarConsultaClientes.this, AdminFuncionalidades.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_aceptar_mostrar_cliente:
                Intent intent2 = new Intent(AdminMostrarConsultaClientes.this, AdminFuncionalidades.class);
                startActivity(intent2);
                finish();
                break;
        }
    }
}