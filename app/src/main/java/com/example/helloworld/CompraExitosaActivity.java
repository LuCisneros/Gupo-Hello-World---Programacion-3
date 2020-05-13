package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CompraExitosaActivity extends AppCompatActivity {


    Button irMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_compra_exitosa);

        irMenu = findViewById(R.id.menuPrincipal);

        irMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Intent intent;
                intent = new Intent(CompraExitosaActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}