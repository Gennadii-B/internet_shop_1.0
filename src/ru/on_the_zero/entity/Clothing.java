package ru.on_the_zero.entity;

import java.io.Serializable;

import static ru.on_the_zero.utility.SOP.println;
/**
 * Created by N on 20.11.2016.
 */
public class Clothing extends AbstractProduct implements Serializable {
    private int amount;
    private String color;
    private int size;

    public void showInfo(){
        super.showInfo();
        println("       " + "Кол-во: " + amount + " /// Цвет: " + color + " /// Размер: " + size);
    }

    public Clothing(){}

    public Clothing(String name, int id, int price, int amount, String color, int size) {
        super(name, id, price);
        this.amount = amount;
        this.color = color;
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Clothing(String name) {
        super(name);
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


}
