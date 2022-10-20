package com.biblioteca.corresponsal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.biblioteca.corresponsal.Entidades.Corresponsal;
import com.biblioteca.corresponsal.Model.ActualizarCorresponsalImpl;
import com.biblioteca.corresponsal.Presenter.ActualizarCorresponsalImprl;
import com.biblioteca.corresponsal.Presenter.ActualizarCorresponsalPresenter;
import com.biblioteca.corresponsal.View.ActualizarCorresponsalView;

public class AdminConsultarHabilitarCorresponsal extends Activity implements ActualizarCorresponsalView, View.OnClickListener{
    private Corresponsal corresponsal;
    private TextView nombre_corresponsal;
    private TextView nit_corresponsal;
    private TextView saldo_corresponsal;
    private TextView correo_corresponsal;
    private ActualizarCorresponsalPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_consultar_habilitar_corresponsal);
        nombre_corresponsal = findViewById(R.id.nombre_corresponsal_habilitar);
        nit_corresponsal = findViewById(R.id.numero_nit_corresponsal_habilitar);
        saldo_corresponsal = findViewById(R.id.saldo_corresponsal_habilitar);
        correo_corresponsal = findViewById(R.id.corre_corresponsal_habilitar);
        findViewById(R.id.btn_habilitar_confirmar_habilitar).setOnClickListener(this);
        findViewById(R.id.btn_deshabilitar_confirmar_habilitar).setOnClickListener(this);
        corresponsal = new Corresponsal();
        presenter = new ActualizarCorresponsalImprl(this, new ActualizarCorresponsalImpl(this));

        Bundle extras = getIntent().getExtras();
        corresponsal = (Corresponsal) extras.getSerializable("llave7");

        if(corresponsal != null){
            nombre_corresponsal.setText(corresponsal.getNombre_corresponsal());
            nit_corresponsal.setText(corresponsal.getNit_corresponsal());
            saldo_corresponsal.setText(corresponsal.getSaldo_corresponsal());
            correo_corresponsal.setText(corresponsal.getCorreo_corresponsal());
        }
    }
    public void devolverhabilitarcorresponsal(View v){
        switch (v.getId()){
            case R.id.regresar_habilitar_corresponsal:
                Intent intent = new Intent(AdminConsultarHabilitarCorresponsal.this, AdminFuncionalidades.class);
                startActivity(intent);
                finish();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_habilitar_confirmar_habilitar:
                int nit1 = corresponsal.getId_corresponsal();
                presenter.editarestadohabilitar(nit1, corresponsal);
                Toast.makeText(this, "Habilitado", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AdminConsultarHabilitarCorresponsal.this, AdminFuncionalidades.class);
                startActivity(intent);
                break;
            case R.id.btn_deshabilitar_confirmar_habilitar:
                int nit2 = corresponsal.getId_corresponsal();
                presenter.editarestadodeshabilitar(nit2, corresponsal);
                Toast.makeText(this, "Deshabilitado", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(AdminConsultarHabilitarCorresponsal.this, AdminFuncionalidades.class);
                startActivity(intent1);
                break;
        }
    }

    @Override
    public void navigateTohome() {

    }

    @Override
    public void navigateToCorresponsalhabilitar() {

    }

    @Override
    public void navigateToCorresponsaldeshabilitar() {

    }
}