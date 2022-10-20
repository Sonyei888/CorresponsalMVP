package com.biblioteca.corresponsal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.biblioteca.corresponsal.Cancelados.ConsultaCorresCancelada;
import com.biblioteca.corresponsal.Entidades.Corresponsal;
import com.biblioteca.corresponsal.Model.ConsultarCorresponsalImpl;
import com.biblioteca.corresponsal.Presenter.ConsultarCorresponsalImprl;
import com.biblioteca.corresponsal.Presenter.ConsultarCorresponsalPresenter;
import com.biblioteca.corresponsal.View.ConsultarCorresponsalView;

public class AdminConsultarCorresponsal extends Activity implements ConsultarCorresponsalView, View.OnClickListener{
    private EditText nit_consultar_corresponsal;
    private ConsultarCorresponsalPresenter presenter;
    private Corresponsal corresponsal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_consultar_corresponsal);

        nit_consultar_corresponsal = findViewById(R.id.edit_nit_consultar_corresponsal);
        findViewById(R.id.btn_confirmar_consultar_corresponsal).setOnClickListener(this);
        findViewById(R.id.btn_cancelar_consultar_corresponsal).setOnClickListener(this);
        findViewById(R.id.btn_actualizar_consultar_corresponsal).setOnClickListener(this);
        corresponsal = new Corresponsal();
    }

    public void devolverconsultarcorresponsal(View v){
        switch (v.getId()){
            case R.id.regresar_concultar_corresponsal:
                Intent intent = new Intent(AdminConsultarCorresponsal.this, AdminFuncionalidades.class);
                startActivity(intent);
                finish();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_confirmar_consultar_corresponsal:
                String nit = nit_consultar_corresponsal.getText().toString();
                presenter = new ConsultarCorresponsalImprl(this, new ConsultarCorresponsalImpl(this));
                corresponsal = presenter.mostrarcorresponsal(nit);
                if( corresponsal != null){
                    Intent intent = new Intent(AdminConsultarCorresponsal.this, AdminConsultarHabilitarCorresponsal.class);
                    intent.putExtra("llave7", corresponsal);
                    startActivity(intent);
                }else{
                    Toast.makeText(this, "Corresponsal no registrado", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_actualizar_consultar_corresponsal:
                String nit2 = nit_consultar_corresponsal.getText().toString();
                presenter = new ConsultarCorresponsalImprl(this, new ConsultarCorresponsalImpl(this));
                corresponsal = presenter.mostrarcorresponsal(nit2);
                if(corresponsal != null){
                    Intent intent = new Intent(AdminConsultarCorresponsal.this, AdminActualizarCorresponsal.class);
                    intent.putExtra("llave8", corresponsal);
                    startActivity(intent);
                }else{
                    Toast.makeText(this, "Corresponsal no registrado", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_cancelar_consultar_corresponsal:
                Intent intent2 = new Intent(AdminConsultarCorresponsal.this, ConsultaCorresCancelada.class);
                startActivity(intent2);
                finish();
                break;
        }
    }

    @Override
    public void navigateTohome() {

    }

}