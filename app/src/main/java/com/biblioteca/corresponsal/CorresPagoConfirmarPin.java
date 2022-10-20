package com.biblioteca.corresponsal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.biblioteca.corresponsal.Cancelados.PagoCancelado;
import com.biblioteca.corresponsal.Entidades.Corresponsal;
import com.biblioteca.corresponsal.Entidades.Pago_tarjeta;
import com.biblioteca.corresponsal.Entidades.SharedPreference;
import com.biblioteca.corresponsal.Entidades.Transacciones;
import com.biblioteca.corresponsal.Exitosa.PagoExitoso;
import com.biblioteca.corresponsal.Model.PagoTarjetaInteractorImpl;
import com.biblioteca.corresponsal.Model.TransaccionesInteractorImpl;
import com.biblioteca.corresponsal.Presenter.DatosPresenter;
import com.biblioteca.corresponsal.Presenter.PagoTarjetaPresenter;
import com.biblioteca.corresponsal.Presenter.PagoTarjetaPresenterImpl;
import com.biblioteca.corresponsal.Presenter.TransaccionesPresenter;
import com.biblioteca.corresponsal.Presenter.TransaccionesPresenterImprl;
import com.biblioteca.corresponsal.View.DatosView;
import com.biblioteca.corresponsal.View.PagoTarjetaView;
import com.biblioteca.corresponsal.View.TransaccionesView;

import java.util.Objects;

public class CorresPagoConfirmarPin extends AppCompatActivity implements TransaccionesView, DatosView, PagoTarjetaView, View.OnClickListener {
    private Pago_tarjeta pago_tarjeta;
    private Corresponsal corresponsal;
    private EditText pin_confirmar_pago;
    private PagoTarjetaPresenter presenter;
    private Transacciones transacciones;
    private SharedPreference sp;
    private DatosPresenter presenterdatos;
    private TransaccionesPresenter presenter_transaccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corres_pago_confirmar_pin);
        pin_confirmar_pago = findViewById(R.id.edit_pin_confirmar_pago);
        pago_tarjeta = new Pago_tarjeta();
        corresponsal = new Corresponsal();
        transacciones = new Transacciones();
        Bundle extras = getIntent().getExtras();
        pago_tarjeta = (Pago_tarjeta) extras.getSerializable("llave15");
        corresponsal = (Corresponsal) extras.getSerializable("llave17");
        findViewById(R.id.btn_aceptar_pin_confirmar_pago).setOnClickListener(this);
        findViewById(R.id.btn_cancelar_pin_confirmar_pago).setOnClickListener(this);
        presenter = new PagoTarjetaPresenterImpl(this, new PagoTarjetaInteractorImpl(this));
        presenter_transaccion = new TransaccionesPresenterImprl(this, new TransaccionesInteractorImpl(this));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_aceptar_pin_confirmar_pago:
                String confirmar_pin = pin_confirmar_pago.getText().toString();
                String nit = corresponsal.getNit_corresponsal();
                String pin = corresponsal.getContraseña_corresponsal();
                int valorint = Integer.parseInt(pago_tarjeta.getValor_pago() );
                int saldoint = Integer.parseInt(corresponsal.getSaldo_corresponsal());
                int saldototal = valorint + saldoint;
                String saldo = Integer.toString(saldototal);
                transacciones.setTipo_transaccion("Venta con tarjeta");
                transacciones.setNumero_tarjeta(pago_tarjeta.getNumero_tarjeta());
                transacciones.setMonto_trasaccion(pago_tarjeta.getValor_pago());
                transacciones.setNumero_cedula(pago_tarjeta.getNumero_tarjeta());
                transacciones.setValor("0");
                if (!confirmar_pin.isEmpty()) {
                    if(Objects.equals(pin, confirmar_pin)){
                        Toast.makeText(this, "PIN correcto", Toast.LENGTH_SHORT).show();
                        presenter.insertpago(pago_tarjeta);
                        presenter.editarsaldo(nit, saldo, corresponsal);
                        presenter_transaccion.insertTransaccion(transacciones);
                        Intent intent2 = new Intent(CorresPagoConfirmarPin.this, PagoExitoso.class);
                        startActivity(intent2);
                        finish();
                    }else{
                        Toast.makeText(this, "PIN incorrecto", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Campo vacio", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_cancelar_pin_confirmar_pago:
                Intent intent2 = new Intent(CorresPagoConfirmarPin.this, PagoCancelado.class);
                startActivity(intent2);
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
    public void navigateToHome() {

    }
}