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

public class CandyActivity extends AppCompatActivity  {

        ArrayList<Product> listaProductos = new ArrayList<>();
        RecyclerView recyclerViewProductos;
        Button menu;
        ImageButton search;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_candy);

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

           /* menu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(CandyActivity.this, MenuActivity.class);
                    startActivity(intent);
                }
            });*/

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


            menu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PopupMenu popupMenu = new PopupMenu(CandyActivity.this, view);
                    popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()) {
                                case R.id.nav_home: {
                                    Intent intent = new Intent(CandyActivity.this, HogarActivity.class);
                                    startActivity(intent);
                                    break;
                                }
                                case R.id.nav_gallery: {
                                    Intent intent = new Intent(CandyActivity.this, LacteosActivity.class);
                                    startActivity(intent);
                                    break;
                                }

                                case R.id.nav_slideshow: {
                                    Intent intent = new Intent(CandyActivity.this, MeatActivity.class);
                                    startActivity(intent);
                                    break;
                                }
                                case R.id.nav_bebidas: {
                                    Intent intent = new Intent(CandyActivity.this, DrinksActivity.class);
                                    startActivity(intent);
                                    break;
                                }
                                case R.id.nav_dulces: {
                                    Intent intent = new Intent(CandyActivity.this, CandyActivity.class);
                                    startActivity(intent);
                                    break;
                                }
                                case R.id.nav_otros: {
                                    Intent intent = new Intent(CandyActivity.this, HogarActivity.class);
                                    startActivity(intent);
                                    break;
                                }
                                case R.id.nav_configuracion: {
                                    Intent intent = new Intent(CandyActivity.this, ConfigurationActivity.class);
                                    startActivity(intent);
                                    break;
                                }
                                case R.id.nav_carrito: {
                                    Intent intent = new Intent(CandyActivity.this, CarritoDeComprasActivity.class);
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
