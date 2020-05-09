package com.example.helloworld;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarritoDeComprasActivity extends AppCompatActivity {

    RecyclerView carritoDeCompras;
    CartSharedPreferencesManager cartSharedPreferencesManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito_de_compras);

        carritoDeCompras = findViewById(R.id.carritoDeCompras);

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
    }
}

