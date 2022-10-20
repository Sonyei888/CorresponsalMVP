package com.biblioteca.corresponsal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.biblioteca.corresponsal.Adaptadores.ListaTransaccionesAdapter;
import com.biblioteca.corresponsal.Model.ConsultarTransaccionesInteractorImpl;
import com.biblioteca.corresponsal.Presenter.ConsultarTransaccionesPresenter;
import com.biblioteca.corresponsal.Presenter.ConsultarTransaccionesPresenterImprl;
import com.biblioteca.corresponsal.View.ConsultarTransaccionesView;

public class CorresHistorialTransacciones extends AppCompatActivity implements ConsultarTransaccionesView {
    private RecyclerView listatransacciones;
    private ConsultarTransaccionesPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corres_historial_transacciones);
        listatransacciones = findViewById(R.id.listatransaccion);
        listatransacciones.setLayoutManager(new LinearLayoutManager(this));
        presenter = new ConsultarTransaccionesPresenterImprl(this, new ConsultarTransaccionesInteractorImpl(this));
        ListaTransaccionesAdapter adapter = new ListaTransaccionesAdapter(presenter.vertransacciones());
        listatransacciones.setAdapter(adapter);
    }
    public void devolverlistadotransaccion(View v){
        switch (v.getId()){
            case R.id.regresar_listado_transaccion:
                Intent intent = new Intent(CorresHistorialTransacciones.this, CorresFuncionalidades.class);
                startActivity(intent);
                finish();
        }
    }

    @Override
    public void navigatetohome() {

    }
}