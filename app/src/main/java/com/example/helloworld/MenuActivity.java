package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    Button home;
    Button milk;
    Button meat;
    Button bebidas;
    Button dulces;
    Button configuracion;
    Button carrito;
    Button salir;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu);

        home = findViewById(R.id.home);
        milk = findViewById(R.id.milk);
        meat = findViewById(R.id.meat);
        bebidas = findViewById(R.id.bebidas);
        dulces = findViewById(R.id.dulces);
        configuracion = findViewById(R.id.configuracion);
        carrito = findViewById(R.id.carrito);
        salir = findViewById(R.id.salir);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Intent intent;
                intent = new Intent(MenuActivity.this, ArticulosActivity.class);
                startActivity(intent);
            }
        });

        milk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Intent intent;
                intent = new Intent(MenuActivity.this, LacteosActivity.class);
                startActivity(intent);
            }
        });

        meat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Intent intent;
                intent = new Intent(MenuActivity.this, MeatActivity.class);
                startActivity(intent);
            }
        });

        bebidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Intent intent;
                intent = new Intent(MenuActivity.this, DrinksActivity.class);
                startActivity(intent);
            }
        });

        dulces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Intent intent;
                intent = new Intent(MenuActivity.this, CandyActivity.class);
                startActivity(intent);
            }
        });

        configuracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Intent intent;
                intent = new Intent(MenuActivity.this, ConfigurationActivity.class);
                startActivity(intent);
            }
        });

        carrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Intent intent;
                intent = new Intent(MenuActivity.this, CarritoDeComprasActivity.class);
                startActivity(intent);
            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Intent intent;
                intent = new Intent(MenuActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
