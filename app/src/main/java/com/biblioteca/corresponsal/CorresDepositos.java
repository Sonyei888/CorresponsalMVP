package com.biblioteca.corresponsal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.biblioteca.corresponsal.Cancelados.DepositoCancelado;
import com.biblioteca.corresponsal.Entidades.Corresponsal;
import com.biblioteca.corresponsal.Entidades.Depositos;
import com.biblioteca.corresponsal.Entidades.SharedPreference;
import com.biblioteca.corresponsal.Model.DatosImpl;
import com.biblioteca.corresponsal.Model.RetirosInteractorImpl;
import com.biblioteca.corresponsal.Presenter.DatosImprl;
import com.biblioteca.corresponsal.Presenter.DatosPresenter;
import com.biblioteca.corresponsal.Presenter.RetirosPresenterImprl;
import com.biblioteca.corresponsal.View.DatosView;
import com.biblioteca.corresponsal.View.PagoTarjetaView;

public class CorresDepositos extends AppCompatActivity implements DatosView, View.OnClickListener {
    private TextView nombre_corresponsal;
    private TextView saldo_corresponsal;
    private TextView cuenta_corresponsal;
    private EditText numero_cedula_adepositar;
    private EditText numero_cedula_quedeposita;
    private EditText monto_deposito;
    private SharedPreference sp;
    private Corresponsal corresponsal;
    private DatosPresenter presenter;
    private Depositos depositos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corres_depositos);
        nombre_corresponsal = findViewById(R.id.text_nombre_corresponsal_depositos);
        saldo_corresponsal = findViewById(R.id.text_saldo_corresponsal_depositos);
        cuenta_corresponsal = findViewById(R.id.text_cuenta_corresponsal_depositos);
        numero_cedula_adepositar = findViewById(R.id.edit_numero_cedula_adepositar);
        numero_cedula_quedeposita = findViewById(R.id.edit_numero_cedula_quedeposita);
        monto_deposito = findViewById(R.id.edit_monto_depositar);
        findViewById(R.id.btn_confirmar_deposito).setOnClickListener(this);
        findViewById(R.id.btn_cancelar_deposito).setOnClickListener(this);
        corresponsal = new Corresponsal();
        sp = new SharedPreference(this);
        presenter = new DatosImprl(this, new DatosImpl(this));
        String correo = sp.getCorreoCorresponsal();
        corresponsal = presenter.mostrardatos(correo);
        if(corresponsal != null){
            nombre_corresponsal.setText(corresponsal.getNombre_corresponsal());
            saldo_corresponsal.setText(corresponsal.getSaldo_corresponsal());
            cuenta_corresponsal.setText(corresponsal.getCuenta_corresponsal());
        }
    }
    public void devolverdepositos(View v){
        switch (v.getId()){
            case R.id.regresar_depositos:
                Intent intent = new Intent(CorresDepositos.this, CorresFuncionalidades.class);
                startActivity(intent);
                finish();
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_confirmar_deposito:
                depositos = new Depositos();
                String numero_adepositar = numero_cedula_adepositar.getText().toString();
                String numero_quedeposita = numero_cedula_quedeposita.getText().toString();
                String monto_depositar = monto_deposito.getText().toString();
                String nit = corresponsal.getNit_corresponsal();

                if(!numero_quedeposita.isEmpty() && !numero_adepositar.isEmpty() && !monto_depositar.isEmpty()){
                    AlertDialog.Builder alerta = new AlertDialog.Builder(CorresDepositos.this);
                    alerta.setMessage(R.string.alertdialogdeposito)
                            .setCancelable(false)
                            .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    depositos.setNumero_adepositar(numero_adepositar);
                                    depositos.setNumero_quedeposita(numero_quedeposita);
                                    depositos.setMonto_deposito(monto_depositar);
                                    Intent intent2 = new Intent(CorresDepositos.this, CorresConfirmacionDeposito.class);
                                    intent2.putExtra("llave21", depositos);
                                    startActivity(intent2);
                                    finish();
                                }
                            })
                            .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    int monto_int = Integer.parseInt(monto_depositar);
                                    int monto_total_int = monto_int - 1000;

                                    String monto_final = Integer.toString(monto_total_int);
                                    depositos.setNumero_adepositar(numero_adepositar);
                                    depositos.setNumero_quedeposita(numero_quedeposita);
                                    depositos.setMonto_deposito(monto_final);
                                    Intent intent2 = new Intent(CorresDepositos.this, CorresConfirmacionDeposito.class);
                                    intent2.putExtra("llave21", depositos);
                                    startActivity(intent2);
                                    finish();
                                }
                            });
                    alerta.show();
                }else{
                    Toast.makeText(this, "Campos Vacios", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_cancelar_deposito:
                Intent intent2 = new Intent(CorresDepositos.this, DepositoCancelado.class);
                startActivity(intent2);
                finish();
                break;
        }
    }
    @Override
    public void navigateToHome() {

    }
}