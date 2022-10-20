package com.biblioteca.corresponsal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.biblioteca.corresponsal.Entidades.Corresponsal;
import com.biblioteca.corresponsal.Presenter.ActualizarCorresponsalPresenter;
import com.biblioteca.corresponsal.View.ActualizarCorresponsalView;

public class AdminActualizarCorresponsal extends Activity implements ActualizarCorresponsalView, View.OnClickListener{

    private EditText nombre_actualizar_corresponsal;
    private EditText nit_actualizar_corresponsal;
    private EditText correo_actualizar_corresponsal;
    private EditText contraseña_actualizar_corresponsal;
    private Corresponsal corresponsal;
    private ActualizarCorresponsalPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_actualizar_corresponsal);
        nombre_actualizar_corresponsal = findViewById(R.id.edit_nombre_actualizar_corresponsal);
        nit_actualizar_corresponsal = findViewById(R.id.edit_nit_actualizar_corresponsal);
        correo_actualizar_corresponsal = findViewById(R.id.edit_correo_actualizar_corresponsal);
        contraseña_actualizar_corresponsal = findViewById(R.id.edit_contraseña_actualizar_corresponsal);
        findViewById(R.id.btn_confirmar_actualizar_corresponsal).setOnClickListener(this);
        findViewById(R.id.btn_cancelar_actualizar_corresponsal).setOnClickListener(this);
        corresponsal = new Corresponsal();

        Bundle extras = getIntent().getExtras();
        corresponsal = (Corresponsal) extras.getSerializable("llave8");


        if(corresponsal != null){
            nombre_actualizar_corresponsal.setText(corresponsal.getNombre_corresponsal());
            nit_actualizar_corresponsal.setText(corresponsal.getNit_corresponsal());
            correo_actualizar_corresponsal.setText(corresponsal.getCorreo_corresponsal());
            contraseña_actualizar_corresponsal.setText(corresponsal.getContraseña_corresponsal());
        }


    }

    public void devolveracualizar(View v){
        switch (v.getId()){
            case R.id.regresar_actualizar_corresponal:
                Intent intent = new Intent(AdminActualizarCorresponsal.this, AdminFuncionalidades.class);
                startActivity(intent);
                finish();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_confirmar_actualizar_corresponsal:
                int nit3 = corresponsal.getId_corresponsal();
                corresponsal.setNombre_corresponsal(nombre_actualizar_corresponsal.getText().toString());
                corresponsal.setNit_corresponsal(nit_actualizar_corresponsal.getText().toString());
                corresponsal.setCorreo_corresponsal(correo_actualizar_corresponsal.getText().toString());
                corresponsal.setContraseña_corresponsal(contraseña_actualizar_corresponsal.getText().toString());
                if(!corresponsal.getNombre_corresponsal().isEmpty() && !corresponsal.getNit_corresponsal().isEmpty() && !corresponsal.getCorreo_corresponsal().isEmpty() && !corresponsal.getContraseña_corresponsal().isEmpty()){
                        Intent intent = new Intent(AdminActualizarCorresponsal.this, AdminConfirmarDatosActualizarCorresponsal.class);
                        intent.putExtra("llave9", corresponsal);
                        startActivity(intent);
                        finish();
                }else{
                    Toast.makeText(AdminActualizarCorresponsal.this, "DEBE LLENAR LOS CAMPOS OBLIGATORIOS", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btn_cancelar_actualizar_corresponsal:
                Intent intent2 = new Intent(AdminActualizarCorresponsal.this, AdminFuncionalidades.class);
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