package com.biblioteca.corresponsal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.biblioteca.corresponsal.Cancelados.PagoCancelado;
import com.biblioteca.corresponsal.Entidades.Corresponsal;
import com.biblioteca.corresponsal.Entidades.Cuotas;
import com.biblioteca.corresponsal.Entidades.Pago_tarjeta;
import com.biblioteca.corresponsal.Entidades.SharedPreference;
import com.biblioteca.corresponsal.Model.DatosImpl;
import com.biblioteca.corresponsal.Presenter.DatosImprl;
import com.biblioteca.corresponsal.Presenter.DatosPresenter;
import com.biblioteca.corresponsal.View.DatosView;

public class CorresPagoTarjeta extends AppCompatActivity implements DatosView, View.OnClickListener, AdapterView.OnItemSelectedListener {

    Fragment fragmentInicio;
    private TextView nombre_corresponsal;
    private TextView saldo_corresponsal;
    private TextView cuenta_corresponsal;
    private EditText numero_tarjeta;
    private EditText fecha_tarjeta_mm;
    private EditText fecha_tarjeta_dd;
    private EditText nombre_cliente;
    private EditText valor_pago;
    private SharedPreference sp;
    private DatosPresenter presenter;
    private Corresponsal corresponsal;
    private Spinner spinner_pago;
    private Cuotas cuotas_1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corres_pago_tarjeta);
        nombre_corresponsal = findViewById(R.id.text_nombre_corresponsal);
        saldo_corresponsal = findViewById(R.id.text_saldo_corresponsal);
        cuenta_corresponsal = findViewById(R.id.text_cuenta_corresponsal);
        numero_tarjeta = findViewById(R.id.edit_numero_tarjeta_pago);
        fecha_tarjeta_mm = findViewById(R.id.edit_fecha_pago_mes);
        fecha_tarjeta_dd = findViewById(R.id.edit_fecha_pago_dia);
        nombre_cliente = findViewById(R.id.edit_nombre_cliente_pago);
        valor_pago = findViewById(R.id.edit_valor_pago);
        spinner_pago = findViewById(R.id.spinner_pago_tarjeta);
        String[] cuotas = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cuotas);
        spinner_pago.setAdapter(adapter);
        spinner_pago.setOnItemSelectedListener(this);
        sp = new SharedPreference(this);
        corresponsal = new Corresponsal();
        cuotas_1 = new Cuotas();
        presenter = new DatosImprl(this, new DatosImpl(this));
        String correo = sp.getCorreoCorresponsal();
        corresponsal = presenter.mostrardatos(correo);
        findViewById(R.id.btn_confirmar_pago_tarjeta).setOnClickListener(this);
        findViewById(R.id.btn_cancelar_pago_tarjeta).setOnClickListener(this);

        if(corresponsal != null){
            nombre_corresponsal.setText(corresponsal.getNombre_corresponsal());
            saldo_corresponsal.setText(corresponsal.getSaldo_corresponsal());
            cuenta_corresponsal.setText(corresponsal.getCuenta_corresponsal());
        }

    }
    public void devolverpagotarjeta(View v){
        switch (v.getId()){
            case R.id.regresar_pago_tarjeta:
                Intent intent = new Intent(CorresPagoTarjeta.this, CorresFuncionalidades.class);
                startActivity(intent);
                finish();
        }
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        cuotas_1.setNumero(text);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_confirmar_pago_tarjeta:
                Pago_tarjeta pago = new Pago_tarjeta();
                String numero = numero_tarjeta.getText().toString();
                pago.setNumero_tarjeta(numero);
                pago.setFecha_mes(fecha_tarjeta_mm.getText().toString());
                pago.setFecha_dia(fecha_tarjeta_dd.getText().toString());
                pago.setNombre_cliente(nombre_cliente.getText().toString());
                pago.setCuotas(cuotas_1.getNumero());
                String valor = valor_pago.getText().toString();
                pago.setValor_pago(valor);


                if (!valor.equals("") && !numero.equals("")) {
                    int valor_tarjeta_int = Integer.parseInt(valor);
                    if (valor_tarjeta_int > 10000 && valor_tarjeta_int < 1000000) {
                        Intent intent = new Intent(CorresPagoTarjeta.this, CorresConfirmacionPagoTarjeta.class);
                        intent.putExtra("llave16", corresponsal);
                        intent.putExtra("llave14", pago);
                        startActivity(intent);
                        finish();
                    }else {
                        Toast.makeText(this, "Error Valor", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Campos Vacios", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_cancelar_pago_tarjeta:
                Intent intent2 = new Intent(CorresPagoTarjeta.this, PagoCancelado.class);
                startActivity(intent2);
                finish();
                break;
        }
    }

    @Override
    public void navigateToHome() {
    }

}