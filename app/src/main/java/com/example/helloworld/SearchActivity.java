package com.example.helloworld;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    ArrayList<Product> listaProductos = new ArrayList<>();

    EditText search;
    ListView listViewProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_search);

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
        listaProductos.add(new Product("Arroz Caisy Favorito", R.drawable.arroz_caisy_favorito, 10 ));
        listaProductos.add(new Product("Arroz Caisy Super Económico", R.drawable.arroz_caisy_supereconomico, 7 ));
        listaProductos.add(new Product("Arroz Caisy Grano de oro", R.drawable.arroz_grano_de_oro, 12 ));
        listaProductos.add(new Product("Alas de Pollo", R.drawable.image_meat_alas, 32 ));
        listaProductos.add(new Product("Cabeza de Lomo, 1kg",R.drawable.image_meat_cabezadelomo, 52 ));
        listaProductos.add(new Product("Chuleta de Cerdo, 1kg", R.drawable.image_meat_chuleta, 28 ));
        listaProductos.add(new Product("Costilla de Res, 1kg", R.drawable.image_meat_costilla, 30 ));
        listaProductos.add(new Product("Filete de Pollo,1 kg", R.drawable.image_meat_filetedepollo, 38 ));
        listaProductos.add(new Product("Huevos, 30 unidades", R.drawable.image_meat_huevos, 18));
        listaProductos.add(new Product("Molida Especial,1kg", R.drawable.image_meat_molida, 37));
        listaProductos.add(new Product("Pollo Relleno", R.drawable.image_meat_pollorelleno, 32));
        listaProductos.add(new Product("Pollo Entero, 1kg", R.drawable.image_meat_pollo, 17 ));
        listaProductos.add(new Product("Tira,1Kg", R.drawable.image_meat_tira, 39 ));
        listaProductos.add(new Product("Trucha, 1Kg", R.drawable.image_meat_trucha, 45));
        listaProductos.add(new Product("Muslos de Pollo, 700gr", R.drawable.muslos, 28));
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

        search = findViewById(R.id.searchEditText);
        listViewProductos = findViewById(R.id.lvProductos);

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable editable) {

                if (!editable.toString().isEmpty()) {
                    ArrayList<Product> listaProductosFiltrada = new ArrayList<>();

                    for (Product product : listaProductos) {
                        if (product.name.toLowerCase().contains(editable.toString().toLowerCase())) {
                            listaProductosFiltrada.add(product);
                        }
                    }

                    ProductsAdapter adapter = new ProductsAdapter(SearchActivity.this, listaProductosFiltrada);
                    listViewProductos.setAdapter(adapter);
                }
                else {
                    ProductsAdapter adapter = new ProductsAdapter(SearchActivity.this, listaProductos);
                    listViewProductos.setAdapter(adapter);
                }
            }
        });
    }
}
