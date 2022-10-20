package com.biblioteca.corresponsal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.biblioteca.corresponsal.Entidades.SharedPreference;
import com.biblioteca.corresponsal.Entidades.Usuarios;
import com.biblioteca.corresponsal.Metodos.MtdLogin;
import com.biblioteca.corresponsal.Model.LoginInteractorImpl;
import com.biblioteca.corresponsal.Presenter.LoginPresenter;
import com.biblioteca.corresponsal.Presenter.LoginPresenterImpl;
import com.biblioteca.corresponsal.View.LoginView;

public class LoginActivity extends Activity implements LoginView ,View.OnClickListener {
    private EditText edit_email;
    private EditText edit_contrasena;
    private Button btn_ingresar;
    private LoginPresenter presenter;
    private Usuarios usuarios;
    private MtdLogin mtdLogin;
    private SharedPreference sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edit_email = findViewById(R.id.edit_user_name);
        edit_contrasena = findViewById(R.id.edit_password);

        findViewById(R.id.btningresar).setOnClickListener(this);

        presenter = new LoginPresenterImpl(this, new LoginInteractorImpl(this));
        usuarios = new Usuarios();
        mtdLogin = new MtdLogin(this);
        sp = new SharedPreference(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btningresar:
                String usuario = edit_email.getText().toString();
                String contraseña = edit_contrasena.getText().toString();
                usuarios.setCorreo(usuario);
                usuarios.setContrasena(contraseña);
                presenter.validateCredentials(usuarios);
                sp.setCorreoCorresponsal(usuario);
                /*mtdLogin.insertUsuario(usuarios);*/
                break;
        }
    }

    @Override
    public void setEmailError() {
        edit_email.setError("Error Email");
    }

    @Override
    public void setPasswordError() {
        edit_contrasena.setError("Error Contrasena");
    }

    @Override
    public void navigateToCorresponsal() {
        Toast.makeText(this, "Ingresando...", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(LoginActivity.this, CorresFuncionalidades.class);
        startActivity(intent);
    }

    @Override
    public void navigateToBanco() {
        Toast.makeText(this, "Ingresando...", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(LoginActivity.this, AdminFuncionalidades.class);
        startActivity(intent);
    }

}