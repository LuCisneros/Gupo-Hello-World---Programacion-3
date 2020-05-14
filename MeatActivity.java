package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class MeatActivity extends AppCompatActivity {

    ArrayList<Product> listaProductos = new ArrayList<>();
    RecyclerView recyclerViewProductos;
    Button menu;
    ImageButton search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_meats);

        recyclerViewProductos = findViewById(R.id.MeatProductos);
        menu = findViewById(R.id.menu);
        search = findViewById(R.id.imageButtonSearch);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Intent intent;
                intent = new Intent(MeatActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });


        listaProductos.add(new Product("Alas de Pollo", R.drawable.image_meat_alas, 32));
        listaProductos.add(new Product("Cabeza de Lomo, 1kg", R.drawable.image_meat_cabezadelomo, 52));
        listaProductos.add(new Product("Chuleta de Cerdo, 1kg", R.drawable.image_meat_chuleta, 28));
        listaProductos.add(new Product("Costilla de Res, 1kg", R.drawable.image_meat_costilla, 30));
        listaProductos.add(new Product("Filete de Pollo,1 kg", R.drawable.image_meat_filetedepollo, 38));
        listaProductos.add(new Product("Huevos, 30 unidades", R.drawable.image_meat_huevos, 18));
        listaProductos.add(new Product("Molida Especial,1kg", R.drawable.image_meat_molida, 37));
        listaProductos.add(new Product("Pollo Relleno", R.drawable.image_meat_pollorelleno, 32));
        listaProductos.add(new Product("Pollo Entero, 1kg", R.drawable.image_meat_pollo, 17));
        listaProductos.add(new Product("Tira,1Kg", R.drawable.image_meat_tira, 39));
        listaProductos.add(new Product("Trucha, 1Kg", R.drawable.image_meat_trucha, 45));
        listaProductos.add(new Product("Muslos de Pollo, 700gr", R.drawable.muslos, 28));


        ProductsRecyclerAdapter adapter = new ProductsRecyclerAdapter(this, listaProductos);
        adapter.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(Product producto) {
                Intent intent = new Intent(com.example.helloworld.MeatActivity.this, ProductsActivity.class);
                intent.putExtra("producto", producto);
                startActivity(intent);
            }
        });
        recyclerViewProductos.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerViewProductos.setAdapter(adapter);



         menu.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View view){
        PopupMenu popupMenu = new PopupMenu(MeatActivity.this, view);
        popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home: {
                        Intent intent = new Intent(MeatActivity.this, HogarActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case R.id.nav_gallery: {
                        Intent intent = new Intent(MeatActivity.this, LacteosActivity.class);
                        startActivity(intent);
                        break;
                    }

                    case R.id.nav_slideshow: {
                        Intent intent = new Intent(MeatActivity.this, MeatActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case R.id.nav_bebidas: {
                        Intent intent = new Intent(MeatActivity.this, DrinksActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case R.id.nav_dulces: {
                        Intent intent = new Intent(MeatActivity.this, CandyActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case R.id.nav_otros: {
                        Intent intent = new Intent(MeatActivity.this, HogarActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case R.id.nav_configuracion: {
                        Intent intent = new Intent(MeatActivity.this, ConfigurationActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case R.id.nav_carrito: {
                        Intent intent = new Intent(MeatActivity.this, CarritoDeComprasActivity.class);
                        startActivity(intent);
                        break;
                    }


                }
                return true;
            }
        });
        popupMenu.show();
    }
    });

}



}
