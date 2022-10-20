package com.biblioteca.corresponsal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.biblioteca.corresponsal.Cancelados.RetiroCancelado;
import com.biblioteca.corresponsal.Entidades.Clientes;
import com.biblioteca.corresponsal.Entidades.Corresponsal;
import com.biblioteca.corresponsal.Entidades.Retiros;
import com.biblioteca.corresponsal.Entidades.Transacciones;
import com.biblioteca.corresponsal.Exitosa.RetirosExitoso;
import com.biblioteca.corresponsal.Model.RetirosInteractorImpl;
import com.biblioteca.corresponsal.Model.TransaccionesInteractorImpl;
import com.biblioteca.corresponsal.Presenter.RetirosPresenter;
import com.biblioteca.corresponsal.Presenter.RetirosPresenterImprl;
import com.biblioteca.corresponsal.Presenter.TransaccionesPresenter;
import com.biblioteca.corresponsal.Presenter.TransaccionesPresenterImprl;
import com.biblioteca.corresponsal.View.RetirosView;
import com.biblioteca.corresponsal.View.TransaccionesView;

public class CorresConfirmacionRetiro extends AppCompatActivity implements TransaccionesView, RetirosView, View.OnClickListener {
    private Clientes clientes;
    private TextView numero_cuenta;
    private TextView monto_retiro;
    private Corresponsal corresponsal;
    private Transacciones transacciones;
    private Retiros retiros;
    private RetirosPresenter presenter;
    private TransaccionesPresenter presenter_transaccion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corres_confirmacion_retiro);
        numero_cuenta = findViewById(R.id.text_numero_cuenta_retiro);
        monto_retiro = findViewById(R.id.text_monto_retiro);
        clientes = new Clientes();
        corresponsal = new Corresponsal();
        transacciones = new Transacciones();
        retiros = new Retiros();
        Bundle extras = getIntent().getExtras();
        retiros = (Retiros) extras.getSerializable("llave19");
        corresponsal = (Corresponsal) extras.getSerializable("llave20");
        findViewById(R.id.btn_confirmar_datos_retiro).setOnClickListener(this);
        findViewById(R.id.btn_cancelar_datos_retiro).setOnClickListener(this);
        presenter = new RetirosPresenterImprl(this, new RetirosInteractorImpl(this));
        presenter_transaccion = new TransaccionesPresenterImprl(this, new TransaccionesInteractorImpl(this));
        clientes = presenter.mostrardatos(retiros.getNumero_cedula());

        if(retiros !=null){
            numero_cuenta.setText(clientes.getCuenta());
            monto_retiro.setText(retiros.getMonto_retiro());
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_confirmar_datos_retiro:
                String monto = retiros.getMonto_retiro();
                int monto_int = Integer.parseInt(monto);
                int monto_final = monto_int + 2000;
                String nit = corresponsal.getNit_corresponsal();
                String saldo = clientes.getSaldo();
                int saldo_int = Integer.parseInt(saldo);
                String cedula_cliente = clientes.getCedula();
                transacciones.setTipo_transaccion("Retiro");
                transacciones.setMonto_trasaccion(monto);
                transacciones.setNumero_cedula(cedula_cliente);
                transacciones.setNumero_tarjeta(cedula_cliente);
                transacciones.setValor("0");
                if (monto_final <= saldo_int) {
                    presenter.editarclientes(monto, clientes);
                    presenter.editarCorresponsalSaldo(corresponsal);
                    presenter_transaccion.insertTransaccion(transacciones);
                    Toast.makeText(this, "Retiro Exitoso", Toast.LENGTH_SHORT).show();
                    Intent intent3 = new Intent(CorresConfirmacionRetiro.this, RetirosExitoso.class);
                    startActivity(intent3);
                    finish();
                } else {
                    Toast.makeText(this, "Saldo Insuficiente", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_cancelar_datos_retiro:
                Intent intent2 = new Intent(CorresConfirmacionRetiro.this, RetiroCancelado.class);
                startActivity(intent2);
                finish();
                break;
        }
    }

    @Override
    public void navigatetTohome() {

    }

    @Override
    public void navigateTohome() {

    }
}