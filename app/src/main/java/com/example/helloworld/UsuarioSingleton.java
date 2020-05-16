package com.example.helloworld;
public class UsuarioSingleton {
    private static UsuarioSingleton instance;

    public Usuario usuario;

    private UsuarioSingleton() {
    }

    public static UsuarioSingleton getInstance() {
        if (instance == null) {
            instance = new UsuarioSingleton();
        }
        return instance;
    }
}