package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    Button loginButton;
    Switch adminSwitch;
    Button createNewAccount;
    EditText editTextUsername;
    EditText editTextPassword;
    ProgressBar progressBar;
    CheckBox cbRememberMe;
    int requestCodeIngresar = 1;

    UserSharedPreferencesManager userSharedPreferencesManager;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        loginButton = findViewById(R.id.ingresar);
        adminSwitch = findViewById(R.id.switchAdmin);
        createNewAccount = findViewById(R.id.newSesion);
        editTextUsername = findViewById(R.id.usuario);
        editTextPassword = findViewById(R.id.contraseña);
        progressBar = findViewById(R.id.progressBar);
        cbRememberMe = findViewById(R.id.cbRememberMe);

        userSharedPreferencesManager = new UserSharedPreferencesManager(this);

        if (userSharedPreferencesManager.getUser().getUsuario() != null) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("user", userSharedPreferencesManager.getUser());
            startActivity(intent);
        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);

                final Intent intent;
                intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);

                Usuario user = new Usuario(editTextUsername.getText().toString(), editTextPassword.getText().toString());
                intent.putExtra("user", user);
            }
        });

        createNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);

                Intent intent = new Intent(LoginActivity.this, NewAccountActivity.class);
                startActivity(intent);
            }
        });

        adminSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if (checked) {
                    Log.d("TEST", "SWITCH -> TRUE");
                } else {
                    Log.d("TEST", "SWITCH -> FALSE");
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == requestCodeIngresar && resultCode == RESULT_OK && data != null) {
            String nombre = data.getStringExtra("nombre");
            Toast.makeText(this, nombre + " vuelva pronto!", Toast.LENGTH_SHORT).show();
        }
    }

    protected void onRestart() {
        super.onRestart();
        progressBar.setVisibility(View.INVISIBLE);
    }
}
