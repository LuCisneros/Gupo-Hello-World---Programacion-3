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

public class CandyActivity extends AppCompatActivity  {

        Usuario usuario;
        ArrayList<Product> listaProductos = new ArrayList<>();
        RecyclerView recyclerViewProductos;
        Button menu;
        ImageButton search;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_main_menu);

            recyclerViewProductos = findViewById(R.id.CandyProductos);
            menu = findViewById(R.id.menu);
            search = findViewById(R.id.imageButtonSearch);

            search.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    final Intent intent;
                    intent = new Intent(com.example.helloworld.CandyActivity.this, SearchActivity.class);
                    startActivity(intent);
                }
            });

            listaProductos.add(new Product("Doritos, 400 gr", R.drawable.doritos, 8 ));
            listaProductos.add(new Product("Frac,6 unidades",R.drawable.image_candy_frac, 45 ));
            listaProductos.add(new Product("After Eight", R.drawable.after, 55 ));
            listaProductos.add(new Product("M&M", R.drawable.image_candy_mandm, 12 ));
            listaProductos.add(new Product("Mani Salado con pasas", R.drawable.image_candy_mani, 15 ));
            listaProductos.add(new Product("Galletas de Agua", R.drawable.image_galletasdeagua, 28 ));
            listaProductos.add(new Product("Ositos de Goma Mogul", R.drawable.image_candy_mogul, 2 ));
            listaProductos.add(new Product("Nachos Salados", R.drawable.image_nachos, 12));
            listaProductos.add(new Product("Galletas Oreo, 6 unidades", R.drawable.oreo, 12 ));
            listaProductos.add(new Product("Papas Pringles", R.drawable.image_papas, 15 ));
            listaProductos.add(new Product("Pipocas Act II", R.drawable.pipocas, 7 ));
            listaProductos.add(new Product("Snickers", R.drawable.snickers, 10 ));


            ProductsRecyclerAdapter adapter = new ProductsRecyclerAdapter(this, listaProductos);
            adapter.setOnItemClickListener(new OnItemClickListener() {

                @Override
                public void onItemClick(Product producto) {
                    Intent intent = new Intent(com.example.helloworld.CandyActivity.this, ProductsActivity.class);
                    intent.putExtra("producto", producto);
                    startActivity(intent);
                }
            });
            recyclerViewProductos.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
            recyclerViewProductos.setAdapter(adapter);
        }

}
