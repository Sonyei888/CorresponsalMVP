package com.biblioteca.corresponsal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.biblioteca.corresponsal.Cancelados.PagoCancelado;
import com.biblioteca.corresponsal.Entidades.Corresponsal;
import com.biblioteca.corresponsal.Entidades.Pago_tarjeta;

public class CorresConfirmacionPagoTarjeta extends AppCompatActivity implements View.OnClickListener {
    private Pago_tarjeta pago_tarjeta;
    private TextView nombre_cliente;
    private TextView valor;
    private TextView numero_tarjeta;
    private TextView cuota;
    private TextView nombre_tarjeta;
    private Corresponsal corresponsal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corres_confirmacion_pago_tarjeta);
        nombre_cliente = findViewById(R.id.text_nombre_confirmacion_pago);
        valor = findViewById(R.id.text_valor_confirmacion_pago);
        cuota = findViewById(R.id.text_cuotas_confirmacion_pago);
        nombre_tarjeta = findViewById(R.id.text_nombre_tarjeta);
        numero_tarjeta = findViewById(R.id.text_numero_tarjeta_confirmacion_pago);
        findViewById(R.id.btn_confirmar_confirmar_pago).setOnClickListener(this);
        findViewById(R.id.btn_cancelar_confirmar_pago).setOnClickListener(this);
        pago_tarjeta = new Pago_tarjeta();
        corresponsal = new Corresponsal();
        Bundle extras = getIntent().getExtras();
        pago_tarjeta = (Pago_tarjeta) extras.getSerializable("llave14");
        corresponsal = (Corresponsal) extras.getSerializable("llave16");
        String numero = pago_tarjeta.getNumero_tarjeta();
        char american = '3';
        char visa = '4';
        char master = '5';
        char union = '6';
        char tarjeta = (numero.charAt(0));
        if(tarjeta == american){
            nombre_tarjeta.setText("American Express");
        }else if(tarjeta == visa){
            nombre_tarjeta.setText("VISA");
        }else if(tarjeta == master){
            nombre_tarjeta.setText("MasterCard");
        }else if(tarjeta == union){
            nombre_tarjeta.setText("UnionPay");
        }else{
            nombre_tarjeta.setText("null");
        }
        if(pago_tarjeta != null){
            nombre_cliente.setText(pago_tarjeta.getNombre_cliente());
            valor.setText(pago_tarjeta.getValor_pago());
            cuota.setText(pago_tarjeta.getCuotas());
            numero_tarjeta.setText(pago_tarjeta.getNumero_tarjeta());
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_confirmar_confirmar_pago:
                String validartarjeta = nombre_tarjeta.getText().toString();
                String validar ="null";
                if (validartarjeta != validar) {
                    Intent intent = new Intent(CorresConfirmacionPagoTarjeta.this, CorresPagoConfirmarPin.class);
                    intent.putExtra("llave15", pago_tarjeta);
                    intent.putExtra("llave17", corresponsal);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(this, "ERROR TARJETA", Toast.LENGTH_SHORT).show();

                }
                break;
            case R.id.btn_cancelar_confirmar_pago:
                Intent intent2 = new Intent(CorresConfirmacionPagoTarjeta.this, PagoCancelado.class);
                startActivity(intent2);
                finish();
                break;
        }
    }
}