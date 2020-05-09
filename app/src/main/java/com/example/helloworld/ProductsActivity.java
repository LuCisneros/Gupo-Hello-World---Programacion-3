package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProductsActivity extends AppCompatActivity {

    TextView  precio;
    TextView  nombre;
    ImageView productimage;
    ImageButton back_arrow;
    Button carrito;

    CartSharedPreferencesManager cartSharedPreferencesManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_productos);

        cartSharedPreferencesManager = new CartSharedPreferencesManager(this);

        final Product producto;
        precio = findViewById(R.id.precio);
        nombre = findViewById(R.id.nombre);
        productimage = findViewById(R.id.productoImagen);
        back_arrow = findViewById(R.id.backArrow2);
        carrito = findViewById(R.id.agregarAlCarrito);


        Intent intent = getIntent();
        if (intent.hasExtra("producto")) {
            producto = (Product) intent.getSerializableExtra("producto");
            nombre.setText(producto.getName());
            precio.setText(producto.getPrice());
            productimage.setImageResource(producto.getImage());


            carrito.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    cartSharedPreferencesManager.addToCart(producto);

                    final Intent intent;
                    intent = new Intent(ProductsActivity.this, CarritoDeComprasActivity.class);
                    startActivity(intent);
                }
            });

        }

        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Intent intent;
                intent = new Intent(ProductsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
