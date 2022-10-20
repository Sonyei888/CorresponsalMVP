package com.biblioteca.corresponsal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.biblioteca.corresponsal.Cancelados.RetiroCancelado;
import com.biblioteca.corresponsal.Entidades.Clientes;
import com.biblioteca.corresponsal.Entidades.Corresponsal;
import com.biblioteca.corresponsal.Entidades.Retiros;
import com.biblioteca.corresponsal.Entidades.SharedPreference;
import com.biblioteca.corresponsal.Model.DatosImpl;
import com.biblioteca.corresponsal.Model.RetirosInteractor;
import com.biblioteca.corresponsal.Model.RetirosInteractorImpl;
import com.biblioteca.corresponsal.Presenter.DatosImprl;
import com.biblioteca.corresponsal.Presenter.DatosPresenter;
import com.biblioteca.corresponsal.Presenter.RetirosPresenter;
import com.biblioteca.corresponsal.Presenter.RetirosPresenterImprl;
import com.biblioteca.corresponsal.View.DatosView;
import com.biblioteca.corresponsal.View.RetirosView;

public class CorresRetiros extends AppCompatActivity implements DatosView, RetirosView, View.OnClickListener {

    private TextView nombre_corresponsal;
    private TextView saldo_corresponsal;
    private EditText numero_cedula;
    private EditText monto_retiro;
    private TextView cuenta_corresponsal;
    private Corresponsal corresponsal;
    private SharedPreference sp;
    private DatosPresenter presenter;
    private RetirosPresenter presenter_retiros;
    private Clientes clientes;
    private Retiros retiros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corres_retiros);
        nombre_corresponsal = findViewById(R.id.text_nombre_corresponsal_retiros);
        saldo_corresponsal = findViewById(R.id.text_saldo_corresponsal_retiros);
        cuenta_corresponsal = findViewById(R.id.text_cuenta_corresponsal_retiros);
        numero_cedula = findViewById(R.id.edit_numero_cedula);
        monto_retiro = findViewById(R.id.edit_monto_retiro);
        findViewById(R.id.btn_confirmar_retiro).setOnClickListener(this);
        findViewById(R.id.btn_cancelar_retiro).setOnClickListener(this);
        sp = new SharedPreference(this);
        clientes = new Clientes();
        presenter = new DatosImprl(this, new DatosImpl(this));
        presenter_retiros = new RetirosPresenterImprl(this, new RetirosInteractorImpl(this));

        String correo = sp.getCorreoCorresponsal();
        corresponsal = presenter.mostrardatos(correo);
        if(corresponsal != null){
            nombre_corresponsal.setText(corresponsal.getNombre_corresponsal());
            saldo_corresponsal.setText(corresponsal.getSaldo_corresponsal());
            cuenta_corresponsal.setText(corresponsal.getCuenta_corresponsal());
        }
    }
    public void devolverretiros(View v){
        switch (v.getId()){
            case R.id.regresar_retiros:
                Intent intent = new Intent(CorresRetiros.this, CorresFuncionalidades.class);
                startActivity(intent);
                finish();
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_confirmar_retiro:
                retiros = new Retiros();
                String campo_cedula = numero_cedula.getText().toString();
                String campo_monto = monto_retiro.getText().toString();
                clientes = presenter_retiros.mostrardatos(campo_cedula);

                if (!campo_cedula.isEmpty() && !campo_monto.isEmpty()) {
                    if (clientes != null) {
                        AlertDialog.Builder alerta = new AlertDialog.Builder(CorresRetiros.this);
                        alerta.setMessage(R.string.alertdialog)
                                .setCancelable(false)
                                .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        retiros.setNumero_cedula(campo_cedula);
                                        retiros.setMonto_retiro(campo_monto);
                                        Intent intent2 = new Intent(CorresRetiros.this, CorresConfirmacionRetiro.class);
                                        intent2.putExtra("llave19", retiros);
                                        intent2.putExtra("llave20", corresponsal);
                                        startActivity(intent2);
                                        finish();
                                    }
                                })
                                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                        alerta.show();
                    } else {
                        Toast.makeText(this, "El Cliente No Existe", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Campos Vacios", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_cancelar_retiro:
                Intent intent2 = new Intent(CorresRetiros.this, RetiroCancelado.class);
                startActivity(intent2);
                finish();
                break;

        }
    }
    @Override
    public void navigateToHome() {
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    @Override
    public void navigatetTohome() {
    }
}