package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Usuario usuario;
    Button menu;
    ImageButton search;
    ImageButton arrow1;
    ImageButton arrow2;
    ImageButton arrow3;
    ImageButton arrow4;
    ImageButton arrow5;
    ImageButton arrow6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_menu);

        menu = findViewById(R.id.menu);
        search = findViewById(R.id.imageButtonSearch);
        arrow1 = findViewById(R.id.imageButtonFlecha);
        arrow2 = findViewById(R.id.imageButtonFlecha2);
        arrow3 = findViewById(R.id.imageButtonFlecha3);
        arrow4 = findViewById(R.id.imageButtonFlecha4);
        arrow5 = findViewById(R.id.imageButtonFlecha5);
        arrow6 = findViewById(R.id.imageButtonFlecha6);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Intent intent;
                intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        arrow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Intent intent;
                intent = new Intent(MainActivity.this, ProductsActivity.class);
                startActivity(intent);
            }
        });

        arrow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Intent intent;
                intent = new Intent(MainActivity.this, ProductsActivity.class);
                startActivity(intent);
            }
        });

        arrow3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Intent intent;
                intent = new Intent(MainActivity.this, ProductsActivity.class);
                startActivity(intent);
            }
        });

        arrow4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Intent intent;
                intent = new Intent(MainActivity.this, ProductsActivity.class);
                startActivity(intent);
            }
        });

        arrow5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Intent intent;
                intent = new Intent(MainActivity.this, ProductsActivity.class);
                startActivity(intent);
            }
        });

        arrow6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Intent intent;
                intent = new Intent(MainActivity.this, ProductsActivity.class);
                startActivity(intent);
            }
        });
    }
}
