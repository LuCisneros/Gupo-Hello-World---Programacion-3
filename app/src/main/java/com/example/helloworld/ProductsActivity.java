package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ProductsActivity extends AppCompatActivity {

    EditText precio;
    EditText marca;
    EditText cantidad;
    ImageButton back_arrow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_productos);

        precio = findViewById(R.id.precio);
        marca = findViewById(R.id.marca);
        back_arrow = findViewById(R.id.backArrow2);

        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Intent intent;
                intent = new Intent(ProductsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
