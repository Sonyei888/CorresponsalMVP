package com.biblioteca.corresponsal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.biblioteca.corresponsal.Entidades.Corresponsal;
import com.biblioteca.corresponsal.Exitosa.ActualizarCorresponsalExitoso;
import com.biblioteca.corresponsal.Model.ActualizarCorresponsalImpl;
import com.biblioteca.corresponsal.Presenter.ActualizarCorresponsalImprl;
import com.biblioteca.corresponsal.Presenter.ActualizarCorresponsalPresenter;
import com.biblioteca.corresponsal.View.ActualizarCorresponsalView;

public class AdminConfirmarDatosActualizarCorresponsal extends Activity implements ActualizarCorresponsalView, View.OnClickListener{

    private Corresponsal corresponsal;
    private TextView nombre_corresponsal;
    private TextView nit_corresponsal;
    private TextView correo_corresponsal;
    private TextView saldo_corresponsal;
    private boolean correcto;
    private ActualizarCorresponsalPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_confirmar_datos_actualizar_corresponsal);
        nombre_corresponsal = findViewById(R.id.nombre_corresponsal_confirmar_datos_actualizar);
        nit_corresponsal = findViewById(R.id.numero_nit_corresponsal_confirmar_datos_actualizar);
        correo_corresponsal = findViewById(R.id.corre_corresponsal_confirmar_datos_actualizar);
        saldo_corresponsal = findViewById(R.id.saldo_corresponsal_confirmar_datos_actualizar);

        corresponsal = new Corresponsal();
        presenter = new ActualizarCorresponsalImprl(this, new ActualizarCorresponsalImpl(this));

        Bundle extras = getIntent().getExtras();
        corresponsal = (Corresponsal) extras.getSerializable("llave9");


        if(corresponsal != null){
            nombre_corresponsal.setText(corresponsal.getNombre_corresponsal());
            nit_corresponsal.setText(corresponsal.getNit_corresponsal());
            correo_corresponsal.setText(corresponsal.getCorreo_corresponsal());
            saldo_corresponsal.setText(corresponsal.getSaldo_corresponsal());
        }

        findViewById(R.id.btn_aceptar_confirmar_datos_corresponsal_actualizar).setOnClickListener(this);
        findViewById(R.id.btn_cancelar_confirmar_datos_corresponsal_actualizar).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_aceptar_confirmar_datos_corresponsal_actualizar:
                int nit1 = corresponsal.getId_corresponsal();
                correcto = presenter.editarCorresponsal(nit1, corresponsal);
                if(correcto){
                    Toast.makeText(this, "Actualizando...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AdminConfirmarDatosActualizarCorresponsal.this, ActualizarCorresponsalExitoso.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(this, "ERROR AL MODIFICAR REGISTRO", Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.btn_cancelar_confirmar_datos_corresponsal_actualizar:
                Intent intent2 = new Intent(AdminConfirmarDatosActualizarCorresponsal.this, AdminFuncionalidades.class);
                startActivity(intent2);
                finish();
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