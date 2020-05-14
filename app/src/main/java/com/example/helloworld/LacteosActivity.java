package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class LacteosActivity extends AppCompatActivity {

        ArrayList<Product> listaProductos = new ArrayList<>();
        RecyclerView recyclerViewProductos;
        Button menu;
        ImageButton search;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_candy);

            recyclerViewProductos = findViewById(R.id.LacteosProductos);
            menu = findViewById(R.id.menu);
            search = findViewById(R.id.imageButtonSearch);

            search.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    final Intent intent;
                    intent = new Intent(com.example.helloworld.LacteosActivity.this, SearchActivity.class);
                    startActivity(intent);
                }
            });

            menu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(com.example.helloworld.LacteosActivity.this, MenuActivity.class);
                    startActivity(intent);
                }
            });

            listaProductos.add(new Product("Biogurt Pil", R.drawable.yogurt, 15 ));
            listaProductos.add(new Product("Crema de Leche",R.drawable.crema, 14));
            listaProductos.add(new Product("Leche de Soya", R.drawable.lechesoya, 6 ));
            listaProductos.add(new Product("Leche Condensada", R.drawable.lechecondensada, 12 ));
            listaProductos.add(new Product("Mantequilla Pil", R.drawable.mantequilla, 15 ));
            listaProductos.add(new Product("Queso Criollo", R.drawable.queso, 54 ));
            listaProductos.add(new Product("Queso Danbo", R.drawable.danbo, 14 ));
            listaProductos.add(new Product("Queso Cheddar", R.drawable.cheddar, 50));
            listaProductos.add(new Product("Leche en Polvo", R.drawable.image_lechpolvo, 44 ));
            listaProductos.add(new Product("Leche Evaporada", R.drawable.evaporada, 11 ));
            listaProductos.add(new Product("Leche con cafe", R.drawable.lechecafe, 8 ));
            listaProductos.add(new Product("Yogurt Griego", R.drawable.griego, 5 ));


            ProductsRecyclerAdapter adapter = new ProductsRecyclerAdapter(this, listaProductos);
            adapter.setOnItemClickListener(new OnItemClickListener() {

                @Override
                public void onItemClick(Product producto) {
                    Intent intent = new Intent(com.example.helloworld.LacteosActivity.this, ProductsActivity.class);
                    intent.putExtra("producto", producto);
                    startActivity(intent);
                }
            });
            recyclerViewProductos.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
            recyclerViewProductos.setAdapter(adapter);
        }



}
