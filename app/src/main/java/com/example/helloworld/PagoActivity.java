package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PagoActivity extends AppCompatActivity {

    Button realizarPago;
    EditText editTextNit;
    EditText editTextNombreNit;
    TextView precioTotal;
    ImageButton back;

    CartSharedPreferencesManager cartSharedPreferencesManager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pago);

        cartSharedPreferencesManager = new CartSharedPreferencesManager(this);

        back = findViewById(R.id.goBack);
        realizarPago = findViewById(R.id.realizar);
        precioTotal = findViewById(R.id.precioTotal);
        editTextNit = findViewById(R.id.nit);
        editTextNombreNit = findViewById(R.id.nombreNit);

        precioTotal.setText(String.valueOf(cartSharedPreferencesManager.getTotal()));

        realizarPago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Intent intent;
                intent = new Intent(PagoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Intent intent;
                intent = new Intent(PagoActivity.this, CarritoDeComprasActivity.class);
                startActivity(intent);
            }
        });
    }
}

