package com.biblioteca.corresponsal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.biblioteca.corresponsal.Cancelados.RegistroCorresCancelado;
import com.biblioteca.corresponsal.Entidades.Corresponsal;
import com.biblioteca.corresponsal.Exitosa.RegistrarCorresExitoso;
import com.biblioteca.corresponsal.Model.CrearCorresponsalInteractorImpl;
import com.biblioteca.corresponsal.Presenter.CrearCorresponsalPresenter;
import com.biblioteca.corresponsal.Presenter.CrearCorresponsalPresenterImpl;
import com.biblioteca.corresponsal.View.CrearCorresponsalView;

public class AdminConfirmarDatosCorresponsal extends Activity implements CrearCorresponsalView, View.OnClickListener{

    private Corresponsal corresponsal;
    private TextView nombre_corresponsal;
    private TextView nit_corresponsal;
    private TextView correo_corresponsal;
    private TextView contrasena_corresponsal;
    private TextView saldo_corresponsal;
    private CrearCorresponsalPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_confirmar_datos_corresponsal);
        nombre_corresponsal = findViewById(R.id.nombre_corresponsal_confirmar_datos);
        nit_corresponsal = findViewById(R.id.numero_nit_corresponsal_confirmar_datos);
        correo_corresponsal = findViewById(R.id.corre_corresponsal_confirmar_datos);
        saldo_corresponsal = findViewById(R.id.saldo_corresponsal_confirmar_datos);
        contrasena_corresponsal = findViewById(R.id.edit_contraseña_corresponsal);

        corresponsal = new Corresponsal();
        presenter = new CrearCorresponsalPresenterImpl(this, new CrearCorresponsalInteractorImpl(this));

        Bundle extras = getIntent().getExtras();
        corresponsal = (Corresponsal) extras.getSerializable("llave6");


        if(corresponsal != null){
            nombre_corresponsal.setText(corresponsal.getNombre_corresponsal());
            nit_corresponsal.setText(corresponsal.getNit_corresponsal());
            correo_corresponsal.setText(corresponsal.getCorreo_corresponsal());
            saldo_corresponsal.setText("0");
        }

        findViewById(R.id.btn_aceptar_confirmar_datos_corresponsal).setOnClickListener(this);
        findViewById(R.id.btn_cancelar_confirmar_datos_corresponsal).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_aceptar_confirmar_datos_corresponsal:
                presenter.insertarCorresponsal(corresponsal);
                break;
            case R.id.btn_cancelar_confirmar_datos_corresponsal:
                Intent intent2 = new Intent(AdminConfirmarDatosCorresponsal.this, RegistroCorresCancelado.class);
                startActivity(intent2);
                finish();
                break;
        }

    }

    @Override
    public void navigateTonext() {
        Toast.makeText(this, "Registrando...", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(AdminConfirmarDatosCorresponsal.this, RegistrarCorresExitoso.class);
        startActivity(intent);
    }

}