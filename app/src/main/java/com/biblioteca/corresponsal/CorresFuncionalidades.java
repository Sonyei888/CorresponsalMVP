package com.biblioteca.corresponsal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.biblioteca.corresponsal.Entidades.Corresponsal;
import com.biblioteca.corresponsal.Entidades.SharedPreference;
import com.biblioteca.corresponsal.Fragments.InicioFragment;
import com.biblioteca.corresponsal.Model.DatosImpl;
import com.biblioteca.corresponsal.Presenter.DatosImprl;
import com.biblioteca.corresponsal.Presenter.DatosPresenter;
import com.biblioteca.corresponsal.View.DatosView;

public class CorresFuncionalidades extends AppCompatActivity implements DatosView, View.OnClickListener{

    Fragment fragmentInicio;
    private TextView nombre_corresponsal;
    private TextView saldo_corresponsal;
    private TextView cuenta_corresponsal;
    private SharedPreference sp;
    private DatosPresenter presenter;
    private Corresponsal corresponsal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corres_funcionalidades);
        fragmentInicio = new InicioFragment(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragments, fragmentInicio).commit();
        nombre_corresponsal = findViewById(R.id.text_nombre_corresponsal);
        saldo_corresponsal = findViewById(R.id.text_saldo_corresponsal);
        cuenta_corresponsal = findViewById(R.id.text_cuenta_corresponsal);
        sp = new SharedPreference(this);
        corresponsal = new Corresponsal();
        presenter = new DatosImprl(this, new DatosImpl(this));
        String correo = sp.getCorreoCorresponsal();
        corresponsal = presenter.mostrardatos(correo);

        if(corresponsal != null){
            nombre_corresponsal.setText(corresponsal.getNombre_corresponsal());
            saldo_corresponsal.setText(corresponsal.getSaldo_corresponsal());
            cuenta_corresponsal.setText(corresponsal.getCuenta_corresponsal());
        }

    }
    public void mostrarpopup(View view){
        ImageView img = findViewById(R.id.menu_popup);
        PopupMenu pu = new PopupMenu(this, img);

        pu.getMenuInflater().inflate(R.menu.menupopop, pu.getMenu());
        pu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item_actualizar_datos:
                        Intent intent3 = new Intent(CorresFuncionalidades.this, CorresActualizarContrasena.class);
                        intent3.putExtra("llave26", corresponsal);
                        startActivity(intent3);
                        return true;
                    case R.id.item_crear_cliente:
                        Intent intent2 = new Intent(CorresFuncionalidades.this, CorresCrearCliente.class);
                        startActivity(intent2);
                        return true;
                    case R.id.item_cerrar_sesion:
                        Toast.makeText(CorresFuncionalidades.this, "Cerrando Sesion...", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(CorresFuncionalidades.this, LoginActivity.class);
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

    @Override
    public void navigateToHome() {

    }
}