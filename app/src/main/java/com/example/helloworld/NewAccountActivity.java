package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class NewAccountActivity extends AppCompatActivity {

    Button back;
    Button create;
    ProgressBar progressBar;
    EditText nombre;
    EditText mail;
    EditText contraseña;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_create_new_account);

        back = findViewById(R.id.atras);
        create = findViewById(R.id.crear);
        nombre = findViewById(R.id.nombre);
        mail = findViewById(R.id.mail);
        contraseña = findViewById(R.id.contraseña);
        progressBar = findViewById(R.id.progressBar);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);

                Intent intent = new Intent(NewAccountActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);

                Intent intent = new Intent(NewAccountActivity.this, MainActivity.class);
                startActivity(intent);

                Usuario user = new Usuario(nombre.getText().toString(), contraseña.getText().toString());
                intent.putExtra("user", user);

            }
        });
    }

    protected void onRestart() {
        super.onRestart();
        progressBar.setVisibility(View.INVISIBLE);
    }

}
