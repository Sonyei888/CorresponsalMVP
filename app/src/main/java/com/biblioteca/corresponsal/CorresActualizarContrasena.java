package com.biblioteca.corresponsal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.biblioteca.corresponsal.Cancelados.ActualizarCorresCancelado;
import com.biblioteca.corresponsal.Entidades.Corresponsal;
import com.biblioteca.corresponsal.Model.ActualizarCorresponsalImpl;
import com.biblioteca.corresponsal.Presenter.ActualizarCorresponsalImprl;
import com.biblioteca.corresponsal.Presenter.ActualizarCorresponsalPresenter;
import com.biblioteca.corresponsal.View.ActualizarCorresponsalView;

import java.util.Objects;

public class CorresActualizarContrasena extends AppCompatActivity implements ActualizarCorresponsalView, View.OnClickListener {
    private EditText contraseña_actual;
    private EditText contraseña_nueva;
    private EditText confirmar_contraseña;
    private Corresponsal corresponsal;
    private ActualizarCorresponsalPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corres_actualizar_contrasena);
        contraseña_actual = findViewById(R.id.edit_contrasena_actual);
        contraseña_nueva = findViewById(R.id.edit_contrasena_nueva);
        confirmar_contraseña = findViewById(R.id.edit_confirmar_contrasena);
        findViewById(R.id.btn_confirmar_contrasena).setOnClickListener(this);
        findViewById(R.id.btn_cancelar_contrasena).setOnClickListener(this);
        corresponsal = new Corresponsal();
        presenter = new ActualizarCorresponsalImprl(this, new ActualizarCorresponsalImpl(this));
        Bundle extras = getIntent().getExtras();
        corresponsal = (Corresponsal) extras.getSerializable("llave26");
    }
    public void devolveracualizarcontrasena(View v){
        switch (v.getId()){
            case R.id.regresar_actualizar_contraseña:
                Intent intent = new Intent(CorresActualizarContrasena.this, CorresFuncionalidades.class);
                startActivity(intent);
                finish();
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_confirmar_contrasena:
                String contrasena_actual = corresponsal.getContraseña_corresponsal();
                int nit1 = corresponsal.getId_corresponsal();
                String confirmar_contrasena_actual = contraseña_actual.getText().toString();
                String contrasena_nueva = contraseña_nueva.getText().toString();
                String confirmar_contrasena_nueva = confirmar_contraseña.getText().toString();
                if(Objects.equals(contrasena_actual, confirmar_contrasena_actual)){
                    if (Objects.equals(contrasena_nueva, confirmar_contrasena_nueva)) {
                        corresponsal.setContraseña_corresponsal(contrasena_nueva);
                        presenter.editarCorresponsal(nit1, corresponsal);
                        Intent intent = new Intent(CorresActualizarContrasena.this, CorresFuncionalidades.class);
                        Toast.makeText(this, "Actualizando...", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        finish();
                    }else {
                        Toast.makeText(this, "Contraseñas diferentes", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(this, "Contraseña Actual Incorrecta", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_cancelar_contrasena:
                Intent intent = new Intent(CorresActualizarContrasena.this, ActualizarCorresCancelado.class);
                startActivity(intent);
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