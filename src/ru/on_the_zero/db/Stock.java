package ru.on_the_zero.db;

import ru.on_the_zero.entity.*;

import java.util.ArrayList;

/**
 * Created by N on 20.11.2016.
 */
public class Stock {

    private ArrayList<Food> productsFood = new ArrayList<>();
    private ArrayList<Clothing> productsClothing = new ArrayList<>();
    private ArrayList<Technics> productsTechnics = new ArrayList<>();
    private ArrayList<Basket> baskets = new ArrayList<>();


    public ArrayList<Basket> getBaskets() {
        return baskets;
    }

    public ArrayList<Food> getProductsFood() {
        return productsFood;
    }

    public ArrayList<Clothing> getProductsClothing() {
        return productsClothing;
    }

    public ArrayList<Technics> getProductsTechnics() {
        return productsTechnics;
    }


    public void setProductsFood(ArrayList<Food> productsFood) {
        this.productsFood = productsFood;
    }

    public void setProductsClothing(ArrayList<Clothing> productsClothing) {
        this.productsClothing = productsClothing;
    }

    public void setProductsTechnics(ArrayList<Technics> productsTechnics) {
        this.productsTechnics = productsTechnics;
    }

    public void setBaskets(ArrayList<Basket> baskets) {
        this.baskets = baskets;
    }
}
