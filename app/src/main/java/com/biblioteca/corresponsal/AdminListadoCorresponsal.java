package com.biblioteca.corresponsal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

import com.biblioteca.corresponsal.Adaptadores.ListaCorresponsalAdapter;
import com.biblioteca.corresponsal.Model.ConsultarCorresponsalImpl;
import com.biblioteca.corresponsal.Presenter.ConsultarCorresponsalImprl;
import com.biblioteca.corresponsal.Presenter.ConsultarCorresponsalPresenter;
import com.biblioteca.corresponsal.View.ConsultarCorresponsalView;

public class AdminListadoCorresponsal extends Activity implements ConsultarCorresponsalView, SearchView.OnQueryTextListener {
    private RecyclerView listacorresponsal;
    private ConsultarCorresponsalPresenter presenter;
    private SearchView txtbuscarlistadocorres;
    private ListaCorresponsalAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_listado_corresponsal);
        listacorresponsal = findViewById(R.id.listacorresponsal);
        listacorresponsal.setLayoutManager(new LinearLayoutManager(this));
        txtbuscarlistadocorres = findViewById(R.id.search_listado_corresponsal);
        presenter = new ConsultarCorresponsalImprl(this, new ConsultarCorresponsalImpl(this));
        adapter = new ListaCorresponsalAdapter(presenter.vercorresponsal());
        listacorresponsal.setAdapter(adapter);
        txtbuscarlistadocorres.setOnQueryTextListener(this);
    }
    public void devolverlistadocorresponsal(View v){
        switch (v.getId()){
            case R.id.regresar_listado_corresponsal:
                Intent intent = new Intent(AdminListadoCorresponsal.this, AdminFuncionalidades.class);
                startActivity(intent);
                finish();
        }
    }

    @Override
    public void navigateTohome() {

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