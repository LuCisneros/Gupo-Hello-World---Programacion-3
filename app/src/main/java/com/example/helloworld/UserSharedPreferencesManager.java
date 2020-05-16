package com.example.helloworld;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class UserSharedPreferencesManager {

    private Context context;

    public UserSharedPreferencesManager(Context context) {
        this.context = context;
    }

    public void saveUser(Usuario usuario) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Usuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String usuarioString = "ERROR";

        Gson gson = new Gson();
        usuarioString = gson.toJson(usuario);

        editor.putString("usuario", usuarioString);
        editor.apply();

        Toast.makeText(context, "Usuario Almacenado Correctamente", Toast.LENGTH_SHORT).show();
    }

    public Usuario getUser() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Usuario", Context.MODE_PRIVATE);
        String usuarioString = sharedPreferences.getString("usuario", "{}");

        Usuario usuario;

        Gson gson = new Gson();
        usuario = gson.fromJson(usuarioString, Usuario.class);

        return usuario;
    }

    public void updateUser(String newPassword) {
        Usuario usuario = getUser();
        usuario.setContraseña(newPassword);
        saveUser(usuario);
    }

    public void deleteUser() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Usuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("usuario");
        editor.apply();
    }
}
