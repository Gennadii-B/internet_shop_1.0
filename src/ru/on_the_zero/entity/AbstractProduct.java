package ru.on_the_zero.entity;

import static ru.on_the_zero.entity.tools.SOP.println;
/**
 * Created by N on 20.11.2016.
 */
public abstract class AbstractProduct {
    private String name;
    private int id;
    private int price;

    public void showInfo(){
        println(id + ". " + name + " /// Цена: " + price);

    }

    public AbstractProduct(String name) {
        this.name = name;
    }

    public AbstractProduct(String name, int id, int price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
