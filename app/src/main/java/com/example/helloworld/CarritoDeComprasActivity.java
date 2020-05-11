package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarritoDeComprasActivity extends AppCompatActivity {

    RecyclerView carritoDeCompras;
    CartSharedPreferencesManager cartSharedPreferencesManager;

    ImageButton addProducts;
    Button comprar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito_de_compras);

        carritoDeCompras = findViewById(R.id.carritoDeCompras);
        addProducts = findViewById(R.id.addProducts);
        comprar = findViewById(R.id.realizarCompra);

        cartSharedPreferencesManager = new CartSharedPreferencesManager(this);

        ArrayList<Product> products = cartSharedPreferencesManager.getProducts();
        final ShoppingCartRecyclerAdapter adapter = new ShoppingCartRecyclerAdapter(this, products);

        adapter.setOnShoppingCartClickListener(new OnShoppingCartClickListener() {
            @Override
            public void onDeleteItemClick(Product product) {
                cartSharedPreferencesManager.deleteFromCart(product);
                adapter.updateProducts(cartSharedPreferencesManager.getProducts());
            }
        });

        carritoDeCompras.setAdapter(adapter);
        carritoDeCompras.setLayoutManager(new LinearLayoutManager(this));

        addProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Intent intent;
                intent = new Intent(CarritoDeComprasActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        comprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int total = cartSharedPreferencesManager.getTotal();

                if (total == 0){
                    Toast.makeText(CarritoDeComprasActivity.this, "El carrito está vacio", Toast.LENGTH_SHORT).show();
                }
                else {
                    final Intent intent;
                    intent = new Intent(CarritoDeComprasActivity.this, PagoActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}

