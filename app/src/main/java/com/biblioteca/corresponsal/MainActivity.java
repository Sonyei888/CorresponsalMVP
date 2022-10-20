package com.biblioteca.corresponsal;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.biblioteca.corresponsal.DbCorresponsal.DbCorresponsal;

public class MainActivity extends AppCompatActivity {
    Button btncrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btncrear = findViewById(R.id.button);
        btncrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbCorresponsal dbCorresponsal = new DbCorresponsal(MainActivity.this);
                SQLiteDatabase db = dbCorresponsal.getWritableDatabase();

                if (db != null) {
                    Toast.makeText(MainActivity.this, "Base de datos creeda", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}