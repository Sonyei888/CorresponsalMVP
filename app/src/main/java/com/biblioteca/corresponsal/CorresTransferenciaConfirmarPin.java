package com.biblioteca.corresponsal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.biblioteca.corresponsal.Cancelados.TransferenciaCancelada;
import com.biblioteca.corresponsal.Entidades.Clientes;
import com.biblioteca.corresponsal.Entidades.Corresponsal;
import com.biblioteca.corresponsal.Entidades.Transacciones;
import com.biblioteca.corresponsal.Entidades.Transferencias;
import com.biblioteca.corresponsal.Exitosa.TransferenciaExitosa;
import com.biblioteca.corresponsal.Model.TransaccionesInteractorImpl;
import com.biblioteca.corresponsal.Model.TransferenciaInteractorImpl;
import com.biblioteca.corresponsal.Presenter.TransaccionesPresenter;
import com.biblioteca.corresponsal.Presenter.TransaccionesPresenterImprl;
import com.biblioteca.corresponsal.Presenter.TransferenciaPresenter;
import com.biblioteca.corresponsal.Presenter.TransferenciaPresenterImpl;
import com.biblioteca.corresponsal.View.TransaccionesView;
import com.biblioteca.corresponsal.View.TransferenciaView;

import java.util.Objects;

public class CorresTransferenciaConfirmarPin extends AppCompatActivity implements TransaccionesView, TransferenciaView, View.OnClickListener{

    private Transferencias transferencias;
    private Corresponsal corresponsal;
    private EditText pin_confirmar_transferencia;
    private Clientes cliente1, cliente2;
    private TransferenciaPresenter presenter;
    private Transacciones transacciones;
    private TransaccionesPresenter presenter_transaccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corres_transferencia_confirmar_pin);
        pin_confirmar_transferencia = findViewById(R.id.edit_pin_confirmar_transferencia);
        transferencias = new Transferencias();
        corresponsal = new Corresponsal();
        cliente1 = new Clientes();
        cliente2 = new Clientes();
        transacciones = new Transacciones();
        Bundle extras = getIntent().getExtras();
        transferencias = (Transferencias) extras.getSerializable("llave23");
        corresponsal = (Corresponsal) extras.getSerializable("llave24");
        cliente1 = (Clientes) extras.getSerializable("llave25");
        cliente2 = (Clientes) extras.getSerializable("llave26");
        findViewById(R.id.btn_aceptar_pin_confirmar_transferencia).setOnClickListener(this);
        findViewById(R.id.btn_cancelar_pin_confirmar_transferencia).setOnClickListener(this);
        presenter = new TransferenciaPresenterImpl(this, new TransferenciaInteractorImpl(this));
        presenter_transaccion = new TransaccionesPresenterImprl(this, new TransaccionesInteractorImpl(this));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_aceptar_pin_confirmar_transferencia:
                String pin_corresponsal = corresponsal.getContraseña_corresponsal();
                String pin = pin_confirmar_transferencia.getText().toString();
                String cedula1 = cliente1.getCedula();
                String cedula2 = cliente2.getCedula();
                String nit = corresponsal.getNit_corresponsal();
                int saldototal = Integer.parseInt(transferencias.getMonto_transferir());
                int saldo = Integer.parseInt(transferencias.getMonto_transferir()) - 1000;
                int saldo1 = Integer.parseInt(cliente1.getSaldo());
                int saldo2 = Integer.parseInt(cliente2.getSaldo());
                int saldoc1 = saldo1 + saldo;
                int saldoc2 = saldo2 - saldototal;
                String saldo_cliente1 = Integer.toString(saldoc1);
                String saldo_cliente2 = Integer.toString(saldoc2);
                transacciones.setTipo_transaccion("Transferencia");
                transacciones.setMonto_trasaccion(transferencias.getMonto_transferir());
                transacciones.setNumero_tarjeta(transferencias.getNumero_quetransfiere());
                transacciones.setNumero_cedula(transferencias.getNumero_quetransfiere());
                transacciones.setValor("1000");
                if(!pin.isEmpty()){
                    if(Objects.equals(pin, pin_corresponsal)){
                        boolean correcto = presenter.editarsaldocliente1(cedula1, saldo_cliente1, cliente1);
                        presenter.editarsaldocliente2(cedula2, saldo_cliente2, cliente2);
                        presenter.editarsaldcorresponsal(nit, corresponsal);
                        if (correcto) {
                            presenter_transaccion.insertTransaccion(transacciones);
                            Toast.makeText(this, "Transferencia Exitosa", Toast.LENGTH_SHORT).show();
                            Intent intent2 = new Intent(CorresTransferenciaConfirmarPin.this, TransferenciaExitosa.class);
                            startActivity(intent2);
                            finish();
                        } else {
                            Toast.makeText(this, "Error transferencia", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(this, "PIN incorrecto", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(this, "Campo vacio", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_cancelar_pin_confirmar_transferencia:
                Intent intent2 = new Intent(CorresTransferenciaConfirmarPin.this, TransferenciaCancelada.class);
                startActivity(intent2);
                finish();
                break;
        }
    }

    @Override
    public void navigateTohome() {
    }
}