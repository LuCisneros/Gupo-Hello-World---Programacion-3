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

        listaProductos.add(new Product("Pan francés, 2 unidades", R.drawable.pan_frances, 6 ));
        listaProductos.add(new Product("Pan sarnita, 5 unidades", R.drawable.pan_sarnita, 7 ));
        listaProductos.add(new Product("Nescafé Tradición", R.drawable.nescafe, 35 ));
        listaProductos.add(new Product("Té Windsor", R.drawable.te, 4 ));
        listaProductos.add(new Product("Té Windsor caja grande", R.drawable.te_caja, 16 ));
        listaProductos.add(new Product("Mate de Manzanilla Windsor", R.drawable.mate_manzanilla, 14 ));
        listaProductos.add(new Product("Mate coca Windsor", R.drawable.mate_coca, 3 ));
        listaProductos.add(new Product("Mix Mate Windsor", R.drawable.mix_mate, 15 ));
        listaProductos.add(new Product("Leche Light Pil", R.drawable.leche_light, 7 ));
        listaProductos.add(new Product("Leche Pil", R.drawable.leche, 6 ));
        listaProductos.add(new Product("Leche chocolatada Pil", R.drawable.lechechoc, 8 ));
        listaProductos.add(new Product("Leche en polvo Pil", R.drawable.leche_polvo, 34 ));
        listaProductos.add(new Product("Leche en polvo Pil - Lata", R.drawable.leche_polvo_lata, 64 ));
        listaProductos.add(new Product("Aceite Fino", R.drawable.aceite_fino, 11 ));
        listaProductos.add(new Product("Aceite de oliva", R.drawable.aceite_oliva, 28 ));
        listaProductos.add(new Product("Arros Caisy Favorito", R.drawable.arroz_caisy_favorito, 10 ));
        listaProductos.add(new Product("Arros Caisy Super Económico", R.drawable.arroz_caisy_supereconomico, 7 ));
        listaProductos.add(new Product("Arros Caisy Grano de oro", R.drawable.arroz_grano_de_oro, 12 ));



        ProductsRecyclerAdapter adapter = new ProductsRecyclerAdapter(this, listaProductos);
        adapter.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(Product producto) {
                Intent intent = new Intent(MainActivity.this, ProductsActivity.class);
                intent.putExtra("producto", producto);
                startActivity(intent);
            }
        });
        recyclerViewProductos.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerViewProductos.setAdapter(adapter);
    }
}
