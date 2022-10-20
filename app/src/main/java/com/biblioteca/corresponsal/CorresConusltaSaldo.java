package com.biblioteca.corresponsal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.biblioteca.corresponsal.Cancelados.ConsultaSaldoCancelada;
import com.biblioteca.corresponsal.Entidades.Clientes;
import com.biblioteca.corresponsal.Entidades.Corresponsal;
import com.biblioteca.corresponsal.Entidades.SharedPreference;
import com.biblioteca.corresponsal.Exitosa.ConsultaSaldoExitosa;
import com.biblioteca.corresponsal.Model.ActualizarClientesImpl;
import com.biblioteca.corresponsal.Model.ActualizarCorresponsalImpl;
import com.biblioteca.corresponsal.Model.ConsultarClientesImpl;
import com.biblioteca.corresponsal.Model.DatosImpl;
import com.biblioteca.corresponsal.Presenter.ActualizarClientesImprl;
import com.biblioteca.corresponsal.Presenter.ActualizarClientesPresenter;
import com.biblioteca.corresponsal.Presenter.ActualizarCorresponsalImprl;
import com.biblioteca.corresponsal.Presenter.ActualizarCorresponsalPresenter;
import com.biblioteca.corresponsal.Presenter.ConsultarClientesImprl;
import com.biblioteca.corresponsal.Presenter.ConsultarClientesPresenter;
import com.biblioteca.corresponsal.Presenter.DatosImprl;
import com.biblioteca.corresponsal.Presenter.DatosPresenter;
import com.biblioteca.corresponsal.View.ActualizarClientesView;
import com.biblioteca.corresponsal.View.ActualizarCorresponsalView;
import com.biblioteca.corresponsal.View.ConsultarClientesView;
import com.biblioteca.corresponsal.View.DatosView;

public class CorresConusltaSaldo extends AppCompatActivity implements ConsultarClientesView, ActualizarClientesView, DatosView, ActualizarCorresponsalView, View.OnClickListener {
    private EditText cedula_cliente;
    private Clientes clientes;
    private Corresponsal corresponsal;
    private SharedPreference sp;
    private ConsultarClientesPresenter presenter;
    private ActualizarClientesPresenter presenterclientes;
    private DatosPresenter presenterdatos;
    private ActualizarCorresponsalPresenter presentercorres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corres_conuslta_saldo);
        cedula_cliente = findViewById(R.id.edit_cedula_consultar_saldo);
        findViewById(R.id.btn_confirmar_consulta_saldo).setOnClickListener(this);
        findViewById(R.id.btn_cancelar_consulta_saldo).setOnClickListener(this);
        clientes = new Clientes();
        corresponsal = new Corresponsal();
        sp = new SharedPreference(this);
        String correo = sp.getCorreoCorresponsal();
        presenterdatos = new DatosImprl(this, new DatosImpl(this));
        presenter = new ConsultarClientesImprl(this, new ConsultarClientesImpl(this));
        presentercorres = new ActualizarCorresponsalImprl(this, new ActualizarCorresponsalImpl(this));
        presenterclientes = new ActualizarClientesImprl(this, new ActualizarClientesImpl(this));
        corresponsal = presenterdatos.mostrardatos(correo);
    }
    public void devolverconsultasaldo(View v){
        switch (v.getId()){
            case R.id.regresar_consulta_saldo:
                Intent intent = new Intent(CorresConusltaSaldo.this, CorresFuncionalidades.class);
                startActivity(intent);
                finish();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_confirmar_consulta_saldo:
                String cedula = cedula_cliente.getText().toString();
                clientes = presenter.mostrarclinetes(cedula);
                AlertDialog.Builder alerta = new AlertDialog.Builder(CorresConusltaSaldo.this);
                alerta.setMessage(R.string.alertdialogconsulta)
                        .setCancelable(false)
                        .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                int saldo = Integer.parseInt(clientes.getSaldo());
                                int saldot = saldo -1000;
                                int cedula = clientes.getId();
                                int nit = corresponsal.getId_corresponsal();
                                int saldocorres = Integer.parseInt(corresponsal.getSaldo_corresponsal());
                                int saldocorrest = saldocorres + 1000;
                                corresponsal.setSaldo_corresponsal(Integer.toString(saldocorrest));
                                clientes.setSaldo(Integer.toString(saldot));
                                presenterclientes.editarclientes(cedula, clientes);
                                presentercorres.editarCorresponsal(nit, corresponsal);
                                Intent intent2 = new Intent(CorresConusltaSaldo.this, ConsultaSaldoExitosa.class);
                                intent2.putExtra("llave30", clientes);
                                startActivity(intent2);
                                finish();
                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
                alerta.show();
                break;
            case R.id.btn_cancelar_consulta_saldo:
                Intent intent = new Intent(CorresConusltaSaldo.this, ConsultaSaldoCancelada.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    @Override
    public void navigatetohome() {

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

    @Override
    public void navigateToHome() {

    }
}