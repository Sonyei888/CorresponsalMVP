package com.biblioteca.corresponsal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.biblioteca.corresponsal.Fragments.InicioAdminFragment;
import com.biblioteca.corresponsal.Fragments.InicioFragment;

public class AdminFuncionalidades extends AppCompatActivity implements View.OnClickListener{

    Fragment fragmentInicioAdmin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_funcionalidades);
        fragmentInicioAdmin = new InicioAdminFragment(this);

        getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragmentsAdministrador, fragmentInicioAdmin).commit();
    }

    public void mostrarpopupadmin(View view){
        ImageView img = findViewById(R.id.menu_popup_admin);
        PopupMenu pu = new PopupMenu(this, img);

        pu.getMenuInflater().inflate(R.menu.menupopupadmin, pu.getMenu());
        pu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item_actualizar_clientes:
                        Intent intent2 = new Intent(AdminFuncionalidades.this, AdminConsultarCedulaClientes.class);
                        startActivity(intent2);
                        return true;
                    case R.id.item_actualizar_corresponsal:
                        Intent intent1 = new Intent(AdminFuncionalidades.this, AdminConsultarCorresponsal.class);
                        startActivity(intent1);
                        return true;
                    case R.id.item_cerrar_sesion_admin:
                        Toast.makeText(AdminFuncionalidades.this, "Cerrando Sesion...", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(AdminFuncionalidades.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                        return true;
                }
                return false;
            }
        });
        pu.show();
    }

    @Override
    public void onClick(View v) {

    }
}