package com.biblioteca.corresponsal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.biblioteca.corresponsal.Entidades.Clientes;
import com.biblioteca.corresponsal.Entidades.Corresponsal;
import com.biblioteca.corresponsal.Model.ConsultarClientesImpl;
import com.biblioteca.corresponsal.Presenter.ConsultarClientesImprl;
import com.biblioteca.corresponsal.Presenter.ConsultarClientesPresenter;
import com.biblioteca.corresponsal.View.ConsultarClientesView;

public class AdminConsultarClientes extends AppCompatActivity implements ConsultarClientesView, View.OnClickListener{
    private Clientes clientes;
    private TextView text_nombre;
    private TextView text_cuenta;
    private TextView text_tipo;
    private Corresponsal corresponsal;
    private ConsultarClientesPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_consultar_clientes);
        text_nombre = findViewById(R.id.text_nombre_cliente_consultar);
        text_cuenta = findViewById(R.id.text_numero_cuenta_tarjeta);
        text_tipo = findViewById(R.id.text_tipo_tarjeta_consltar);
        findViewById(R.id.btn_aceptar_consultar_cliente).setOnClickListener(this);
        clientes = new Clientes();
        corresponsal = new Corresponsal();
        Bundle extras = getIntent().getExtras();
        clientes = (Clientes) extras.getSerializable("llave4");
        presenter = new ConsultarClientesImprl(this, new ConsultarClientesImpl(this));
        clientes = presenter.mostrarclinetes(clientes.getCedula());
        if(clientes != null){
            text_nombre.setText(clientes.getNombre());
            text_cuenta.setText(clientes.getCuenta());
            String numero = clientes.getCuenta();
            char american = '3';
            char visa = '4';
            char master = '5';
            char union = '6';
            char tarjeta = (numero.charAt(0));
            if(tarjeta == american){
                text_tipo.setText("American Express");
            }else if(tarjeta == visa){
                text_tipo.setText("VISA");
            }else if(tarjeta == master){
                text_tipo.setText("MasterCard");
            }else if(tarjeta == union){
                text_tipo.setText("UnionPay");
            }else{
                text_tipo.setText("null");
            }
        }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_aceptar_consultar_cliente:
                Intent intent = new Intent(AdminConsultarClientes.this, AdminFuncionalidades.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void navigatetohome() {

    }
}