package com.biblioteca.corresponsal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

import com.biblioteca.corresponsal.Adaptadores.ListaClientesAdapter;
import com.biblioteca.corresponsal.Model.ConsultarClientesImpl;
import com.biblioteca.corresponsal.Presenter.ConsultarClientesImprl;
import com.biblioteca.corresponsal.Presenter.ConsultarClientesPresenter;
import com.biblioteca.corresponsal.View.ConsultarClientesView;

public class AdminListadoClientes extends Activity implements ConsultarClientesView, SearchView.OnQueryTextListener {

    private RecyclerView listaclientes;
    private ConsultarClientesPresenter presenter;
    private SearchView txtbuscarlistadoclientes;
    private ListaClientesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_listado_clientes);
        listaclientes = findViewById(R.id.listaclientes);
        txtbuscarlistadoclientes = findViewById(R.id.search_listado_clientes);
        listaclientes.setLayoutManager(new LinearLayoutManager(this));
        presenter = new ConsultarClientesImprl(this, new ConsultarClientesImpl(this));
        adapter = new ListaClientesAdapter(presenter.verclientes());
        listaclientes.setAdapter(adapter);
        txtbuscarlistadoclientes.setOnQueryTextListener(this);
    }
    public void devolverlistadoclientes(View v){
        switch (v.getId()){
            case R.id.regresar_listado_clientes:
                Intent intent = new Intent(AdminListadoClientes.this, AdminFuncionalidades.class);
                startActivity(intent);
                finish();
        }
    }

    @Override
    public void navigatetohome() {

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.filtrado(newText);
        return false;
    }
}