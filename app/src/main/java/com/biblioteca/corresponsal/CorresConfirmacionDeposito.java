package com.biblioteca.corresponsal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.biblioteca.corresponsal.Cancelados.DepositoCancelado;
import com.biblioteca.corresponsal.Entidades.Clientes;
import com.biblioteca.corresponsal.Entidades.Depositos;
import com.biblioteca.corresponsal.Entidades.Transacciones;
import com.biblioteca.corresponsal.Exitosa.DepositoExitoso;
import com.biblioteca.corresponsal.Model.DepositosInteractorImpl;
import com.biblioteca.corresponsal.Model.TransaccionesInteractorImpl;
import com.biblioteca.corresponsal.Presenter.DepositoPresenter;
import com.biblioteca.corresponsal.Presenter.DepositosPresenterImpl;
import com.biblioteca.corresponsal.Presenter.TransaccionesPresenter;
import com.biblioteca.corresponsal.Presenter.TransaccionesPresenterImprl;
import com.biblioteca.corresponsal.View.DepositoView;
import com.biblioteca.corresponsal.View.TransaccionesView;

import java.util.Objects;

public class CorresConfirmacionDeposito extends AppCompatActivity implements TransaccionesView, DepositoView, View.OnClickListener {
    private Depositos depositos;
    private Clientes clientes;
    private TextView cedula_quedeposita;
    private TextView cedula_adepositar;
    private TextView monto_deposito;
    private DepositoPresenter presenter;
    private Transacciones transacciones;
    private TransaccionesPresenter presenter_transaccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corres_confirmacion_deposito);
        cedula_quedeposita = findViewById(R.id.text_numero_cedula_quedeposita);
        cedula_adepositar = findViewById(R.id.text_numero_cedula_adepositar);
        monto_deposito = findViewById(R.id.text_monto_desposito);
        findViewById(R.id.btn_confirmar_datos_depositos).setOnClickListener(this);
        findViewById(R.id.btn_cancelar_datos_depositos).setOnClickListener(this);
        depositos = new Depositos();
        clientes = new Clientes();
        transacciones = new Transacciones();
        Bundle extras = getIntent().getExtras();
        depositos = (Depositos) extras.getSerializable("llave21");
        if(depositos != null){
            cedula_quedeposita.setText(depositos.getNumero_quedeposita());
            cedula_adepositar.setText(depositos.getNumero_adepositar());
            monto_deposito.setText(depositos.getMonto_deposito());
        }
        presenter = new DepositosPresenterImpl(this, new DepositosInteractorImpl(this));
        presenter_transaccion = new TransaccionesPresenterImprl(this, new TransaccionesInteractorImpl(this));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_confirmar_datos_depositos:
                String cedula = depositos.getNumero_adepositar();
                int monto_deposito2= Integer.parseInt(depositos.getMonto_deposito());
                clientes = presenter.validarcedula(cedula);
                String cedula_cliente = clientes.getCedula();
                int saldo_clientes = Integer.parseInt(clientes.getSaldo());
                int saldo_total = saldo_clientes + monto_deposito2;
                String saldo = Integer.toString(saldo_total);
                transacciones.setTipo_transaccion("Deposito");
                transacciones.setMonto_trasaccion(depositos.getMonto_deposito());
                transacciones.setNumero_cedula(clientes.getCedula());
                transacciones.setNumero_tarjeta(clientes.getCedula());
                transacciones.setValor("0");
                if(Objects.equals(cedula_cliente, cedula)){
                    boolean correcto = presenter.editarsaldo(cedula, saldo, clientes);
                    if (correcto) {
                        presenter_transaccion.insertTransaccion(transacciones);
                        Toast.makeText(this, "Deposito Exitoso", Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(CorresConfirmacionDeposito.this, DepositoExitoso.class);
                        startActivity(intent2);
                        finish();
                    } else {
                        Toast.makeText(this, "Error Deposito", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(this, "Cliente no Encontrado", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.btn_cancelar_datos_depositos:
                Intent intent2 = new Intent(CorresConfirmacionDeposito.this, DepositoCancelado.class);
                startActivity(intent2);
                finish();
                break;
        }
    }

    @Override
    public void nextTohome() {

    }

    @Override
    public void navigateTohome() {

    }
}