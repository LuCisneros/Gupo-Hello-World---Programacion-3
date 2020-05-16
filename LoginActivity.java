package com.example.helloworld;


import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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
    Switch adminSwitch;
    Button loginButton;
    Button createNewAccount;
    EditText editTextUsername;
    EditText editTextPassword;
    ProgressBar progressBar;
    CheckBox cbRememberMe;

    int requestCodeIngresar = 1;
    UserSharedPreferencesManager userSharedPreferencesManager;


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
                intent.putExtra("adminEnabled", adminSwitch.isChecked());

                Usuario user = new Usuario(editTextUsername.getText().toString(), editTextPassword.getText().toString());
                intent.putExtra("user", user);

                UsuarioSingleton.getInstance().usuario = user;

                if (cbRememberMe.isChecked()) {
                    userSharedPreferencesManager.saveUser(user);
                } else {
                    userSharedPreferencesManager.deleteUser();
                }


                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivityForResult(intent, requestCodeIngresar);
                    }
                }, 2000);
                animarProgressBar();
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
    }

         adminSwitch.OnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()){
                public void onCheckedChanged(CompoundButton compoundButton, boolean checked){
                if (checked) {
                    Log.d("TEST", "SWITCH -> TRUE");
                } else {
                    Log.d("TEST", "SWITCH -> FALSE");
                }
            }
        });

        private void animarProgressBar() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, 100);
        valueAnimator.setDuration(2000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                progressBar .setProgress((int) valueAnimator.getAnimatedValue());
            }
        });
        valueAnimator.start();
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
