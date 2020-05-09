package com.example.helloworld;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class Product implements Serializable {

    @Expose
    String name;

    @Expose
    int image;

    @Expose
    int price;

    public Product(String name, int image, int price) {
        this.name = name;
        this.image = image;
        this.price = price;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getImage() {

        return image;
    }

    public void setImage(int image) {

        this.image = image;
    }

    public int getPrice() {

        return price;
    }

    public void setPrice(int price) {

        this.price = price;
    }
}
