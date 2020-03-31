package ru.appline.autotests.pages;

import java.io.Serializable;

public class Product implements Serializable {

    private String name;
    private String price;

    public Product(String name, String price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getName() + " " + getPrice();
    }

}
