package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

        Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        TextView textViewHeader = new TextView(this);


        if (intent.hasExtra("user")) {
            usuario = (Usuario) intent.getSerializableExtra("user");
            if (usuario != null) {
                textViewHeader.setText("Feliz compra " + usuario.getUsuario() + "!");
            }
        }
    }
}
