package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class UbicacionActivity extends AppCompatActivity {

    Button ingresarUbicacion;
    ImageButton back;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ubicacion);

        ingresarUbicacion = findViewById(R.id.ingresarUbicacion);
        back = findViewById(R.id.goBack2);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Intent intent;
                intent = new Intent(UbicacionActivity.this, PagoActivity.class);
                startActivity(intent);
            }
        });

        ingresarUbicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(UbicacionActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

