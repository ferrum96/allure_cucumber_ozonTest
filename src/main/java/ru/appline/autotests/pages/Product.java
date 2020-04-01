package ru.appline.autotests.pages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Product implements Serializable {

    public static List<Product> products = new ArrayList<>();

    private String name;
    private String price;

    public Product(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public int getIntPrice() {
        return Integer.parseInt(price.replaceAll("[^0-9]", ""));
    }

    public static void removeProducts() {
        products.clear();
    }

    @Override
    public String toString() {
        return getName() + " , " + getPrice();
    }

}
