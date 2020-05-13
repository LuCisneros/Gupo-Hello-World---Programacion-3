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

public class DrinksActivity  extends AppCompatActivity {

        ArrayList<Product> listaProductos = new ArrayList<>();
        RecyclerView recyclerViewProductos;
        Button menu;
        ImageButton search;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_drinks);

            recyclerViewProductos = findViewById(R.id.drinksProductos);
            menu = findViewById(R.id.menu);
            search = findViewById(R.id.imageButtonSearch);

            search.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    final Intent intent;
                    intent = new Intent(com.example.helloworld.DrinksActivity.this, SearchActivity.class);
                    startActivity(intent);
                }
            });

            menu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(DrinksActivity.this, MenuActivity.class);
                    startActivity(intent);
                }
            });

            listaProductos.add(new Product("Ades Frutilla, 200ml", R.drawable.image_ades, 4 ));
            listaProductos.add(new Product("Cerveza Becks",R.drawable.image_beck, 7 ));
            listaProductos.add(new Product("Canada Dry", R.drawable.image_canadadry, 8 ));
            listaProductos.add(new Product("Coca Cola, 2l", R.drawable.image_cocacola, 10 ));
            listaProductos.add(new Product("Cerveza Corona, 335 ml", R.drawable.image_corona, 13 ));
            listaProductos.add(new Product("Jugo del Valle", R.drawable.image_delvalle, 8 ));
            listaProductos.add(new Product("Fanta Uva", R.drawable.fanta, 6 ));
            listaProductos.add(new Product("Fernet Branca Menta", R.drawable.image_fernet, 74));
            listaProductos.add(new Product("Whisky Jack Daniels", R.drawable.jack, 120 ));
            listaProductos.add(new Product("Malta Real", R.drawable.malta, 6 ));
            listaProductos.add(new Product("Agua Vital con Gas", R.drawable.image_vital, 7 ));
            listaProductos.add(new Product("Vodka 1825", R.drawable.vodka, 135 ));


            ProductsRecyclerAdapter adapter = new ProductsRecyclerAdapter(this, listaProductos);
            adapter.setOnItemClickListener(new OnItemClickListener() {

                @Override
                public void onItemClick(Product producto) {
                    Intent intent = new Intent(com.example.helloworld.DrinksActivity.this, ProductsActivity.class);
                    intent.putExtra("producto", producto);
                    startActivity(intent);
                }
            });
            recyclerViewProductos.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
            recyclerViewProductos.setAdapter(adapter);
        }



}
