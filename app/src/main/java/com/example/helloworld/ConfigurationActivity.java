package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;


public class ConfigurationActivity extends AppCompatActivity {

    ImageButton arrow;
    Button changeAccount;
    Button createAccount;
    Button closeAccount;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_configuracion);

        arrow = findViewById(R.id.backArrow);
        changeAccount = findViewById(R.id.cambiarCuenta);
        createAccount = findViewById(R.id.cuentaNueva);
        closeAccount = findViewById(R.id.cerrarSesion);

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ConfigurationActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        changeAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Intent intent;
                intent = new Intent(ConfigurationActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ConfigurationActivity.this, NewAccountActivity.class);
                startActivity(intent);
            }
        });

        closeAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ConfigurationActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}


