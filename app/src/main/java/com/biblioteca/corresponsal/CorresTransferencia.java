package com.biblioteca.corresponsal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.biblioteca.corresponsal.Cancelados.TransferenciaCancelada;
import com.biblioteca.corresponsal.Entidades.Clientes;
import com.biblioteca.corresponsal.Entidades.Corresponsal;
import com.biblioteca.corresponsal.Entidades.SharedPreference;
import com.biblioteca.corresponsal.Entidades.Transferencias;
import com.biblioteca.corresponsal.Model.DatosImpl;
import com.biblioteca.corresponsal.Model.DepositosInteractorImpl;
import com.biblioteca.corresponsal.Presenter.DatosImprl;
import com.biblioteca.corresponsal.Presenter.DatosPresenter;
import com.biblioteca.corresponsal.Presenter.DepositoPresenter;
import com.biblioteca.corresponsal.Presenter.DepositosPresenterImpl;
import com.biblioteca.corresponsal.View.DatosView;
import com.biblioteca.corresponsal.View.DepositoView;

import java.util.Objects;

public class CorresTransferencia extends AppCompatActivity implements DatosView, DepositoView, View.OnClickListener{

    private TextView nombre_corresponsal;
    private TextView saldo_corresponsal;
    private TextView cuenta_corresponsal;
    private EditText numero_cedula_atransferir;
    private EditText numero_cedula_quetransfiere;
    private EditText monto_transferir;
    private SharedPreference sp;
    private Corresponsal corresponsal;
    private DatosPresenter presenter;
    private Transferencias transferencias;
    private DepositoPresenter presenter1;
    private Clientes cliente1, cliente2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corres_transferencia);
        nombre_corresponsal = findViewById(R.id.text_nombre_corresponsal_transferencia);
        saldo_corresponsal = findViewById(R.id.text_saldo_corresponsal_transferencia);
        cuenta_corresponsal = findViewById(R.id.text_cuenta_corresponsal_transferencia);
        numero_cedula_atransferir = findViewById(R.id.edit_numero_cedula_atransferir);
        numero_cedula_quetransfiere = findViewById(R.id.edit_numero_cedula_quetransfiere);
        monto_transferir = findViewById(R.id.edit_monto_transferir);
        findViewById(R.id.btn_confirmar_transferencia).setOnClickListener(this);
        findViewById(R.id.btn_cancelar_transferencia).setOnClickListener(this);
        corresponsal = new Corresponsal();

        cliente1 = new Clientes();
        cliente2 = new Clientes();
        sp = new SharedPreference(this);
        presenter = new DatosImprl(this, new DatosImpl(this));
        String correo = sp.getCorreoCorresponsal();
        corresponsal = presenter.mostrardatos(correo);
        if(corresponsal != null){
            nombre_corresponsal.setText(corresponsal.getNombre_corresponsal());
            saldo_corresponsal.setText(corresponsal.getSaldo_corresponsal());
            cuenta_corresponsal.setText(corresponsal.getCuenta_corresponsal());
        }
        presenter1 = new DepositosPresenterImpl(this, new DepositosInteractorImpl(this));
    }
    public void devolverdtransferencia(View v){
        switch (v.getId()){
            case R.id.regresar_transferencia:
                Intent intent = new Intent(CorresTransferencia.this, CorresFuncionalidades.class);
                startActivity(intent);
                finish();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_confirmar_transferencia:
                transferencias = new Transferencias();
                String numero_atransferir = numero_cedula_atransferir.getText().toString();
                String numero_quetransfiere = numero_cedula_quetransfiere.getText().toString();
                String monto_transferencia = monto_transferir.getText().toString();
                cliente1 = presenter1.validarcedula(numero_atransferir);
                cliente2 = presenter1.validarcedula(numero_quetransfiere);
                if (!numero_atransferir.isEmpty() && !numero_quetransfiere.isEmpty() && !monto_transferencia.isEmpty()) {
                    String cedula_cliente1 = cliente1.getCedula();
                    String cedula_cliente2 = cliente2.getCedula();
                    if (Objects.equals(cedula_cliente1, numero_atransferir) && Objects.equals(cedula_cliente2, numero_quetransfiere)) {
                        transferencias.setNumero_atransferir(numero_atransferir);
                        transferencias.setNumero_quetransfiere(numero_quetransfiere);
                        transferencias.setMonto_transferir(monto_transferencia);
                        Intent intent = new Intent(CorresTransferencia.this, CorresTransferenciaConfirmarPin.class);
                        intent.putExtra("llave23", transferencias);
                        intent.putExtra("llave24", corresponsal);
                        intent.putExtra("llave25", cliente1);
                        intent.putExtra("llave26", cliente2);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(this, "Clientes no encontrados", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Campos vacios", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_cancelar_transferencia:
                Intent intent2 = new Intent(CorresTransferencia.this, TransferenciaCancelada.class);
                startActivity(intent2);
                finish();
                break;
        }
    }

    @Override
    public void nextTohome() {

    }
    @Override
    public void navigateToHome() {
    }

}