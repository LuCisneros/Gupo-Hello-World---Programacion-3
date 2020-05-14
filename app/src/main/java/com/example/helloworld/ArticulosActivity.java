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

public class ArticulosActivity extends AppCompatActivity {

        ArrayList<Product> listaProductos = new ArrayList<>();
        RecyclerView recyclerViewProductos;
        Button menu;
        ImageButton search;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_articulos_del_hogar);

            recyclerViewProductos = findViewById(R.id.ArticulosProductos);
            menu = findViewById(R.id.menu);
            search = findViewById(R.id.imageButtonSearch);

            search.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    final Intent intent;
                    intent = new Intent(com.example.helloworld.ArticulosActivity.this, SearchActivity.class);
                    startActivity(intent);
                }
            });

            menu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(com.example.helloworld.ArticulosActivity.this, MenuActivity.class);
                    startActivity(intent);
                }
            });

            listaProductos.add(new Product("Foco", R.drawable.image_foco, 3 ));
            listaProductos.add(new Product("Hervidor Oster,1.7L",R.drawable.hervidor, 260 ));
            listaProductos.add(new Product("Toallas Fatelares", R.drawable.toalla, 30 ));
            listaProductos.add(new Product("Pilas Rayovac, AAA", R.drawable.pilas, 24 ));
            listaProductos.add(new Product("Juego Gibson Vajilla", R.drawable.vajilla, 330 ));
            listaProductos.add(new Product("Olla Tramontina, 3l ", R.drawable.olla, 300 ));
            listaProductos.add(new Product("Afeitadora", R.drawable.afeitadora, 410 ));
            listaProductos.add(new Product("Aspiradora de Mano", R.drawable.aspiradora, 350));
            listaProductos.add(new Product("Maximus,300ml", R.drawable.maximus, 21));
            listaProductos.add(new Product("Ambientador,300ml", R.drawable.ambientador, 15 ));
            listaProductos.add(new Product("Lavavajilla, 1050ml", R.drawable.lavavajilla, 18 ));
            listaProductos.add(new Product("Lustramuebles,500ml", R.drawable.lustramuebles, 19 ));


            ProductsRecyclerAdapter adapter = new ProductsRecyclerAdapter(this, listaProductos);
            adapter.setOnItemClickListener(new OnItemClickListener() {

                @Override
                public void onItemClick(Product producto) {
                    Intent intent = new Intent(com.example.helloworld.ArticulosActivity.this, ProductsActivity.class);
                    intent.putExtra("producto", producto);
                    startActivity(intent);
                }
            });
            recyclerViewProductos.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
            recyclerViewProductos.setAdapter(adapter);
        }



}
