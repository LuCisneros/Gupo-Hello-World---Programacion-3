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

public class MainActivity extends AppCompatActivity {

    Usuario usuario;
    ArrayList<Product> listaProductos = new ArrayList<>();
    RecyclerView recyclerViewProductos;
    Button menu;
    ImageButton search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_menu);

        recyclerViewProductos = findViewById(R.id.rvProductos);
        menu = findViewById(R.id.menu);
        search = findViewById(R.id.imageButtonSearch);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Intent intent;
                intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        listaProductos.add(new Product("Paquete de pan, 5 unidades", R.drawable.images_pane, 6 ));
        listaProductos.add(new Product("Carne 1kg", R.drawable.images_carne1, 45 ));
        listaProductos.add(new Product("Bolsa de dulces", R.drawable.images_dul1, 17 ));


        ProductsRecyclerAdapter adapter = new ProductsRecyclerAdapter(this, listaProductos);
        adapter.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(Product producto) {
                Intent intent = new Intent(MainActivity.this, ProductsActivity.class);
                intent.putExtra("producto", producto);
                startActivity(intent);
            }
        });
        recyclerViewProductos.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        recyclerViewProductos.setAdapter(adapter);
    }
}
