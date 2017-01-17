package ru.on_the_zero.entity;

import ru.on_the_zero.utility.commands.Show;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import static ru.on_the_zero.utility.SOP.println;

/**
 * Created by N on 20.11.2016.
 */
public class Basket implements Serializable {

    private ArrayList<Food> orderFoods = new ArrayList<>();
    private ArrayList<Clothing> orderClothing = new ArrayList<>();
    private ArrayList<Technics> orderTechnicses = new ArrayList<>();
    private LocalDate dateBuy;

    public void showOrderProducts(){
        println("\n///// [ BASKET ] /////");
       // println("номер покупки: ");
        println("товары: ");
        Show.showType(orderFoods);
        Show.showType(orderClothing);
        Show.showType(orderTechnicses);
        println("\n общая стоимость: " + summ() + "\n");
    }

    public int summ(){
        int result = 0;
        for(Food food: getOrderFoods()) result += (food.getPrice() * food.getAmount());
        for(Clothing clothing: getOrderClothing()) result += (clothing.getPrice() * clothing.getAmount());
        for(Technics technics: getOrderTechnicses()) result += (technics.getPrice() * technics.getAmount());

        return result;
    }

    public LocalDate getDateBuy() {
        return dateBuy;
    }

    public void setDateBuy(LocalDate dateBuy) {
        this.dateBuy = dateBuy;
    }

    public ArrayList<Food> getOrderFoods() {
        return orderFoods;
    }

    public ArrayList<Clothing> getOrderClothing() {
        return orderClothing;
    }

    public ArrayList<Technics> getOrderTechnicses() {
        return orderTechnicses;
    }

    public void setOrderFoods(ArrayList<Food> orderFoods) {
        this.orderFoods = orderFoods;
    }

    public void setOrderClothing(ArrayList<Clothing> orderClothing) {
        this.orderClothing = orderClothing;
    }

    public void setOrderTechnicses(ArrayList<Technics> orderTechnicses) {
        this.orderTechnicses = orderTechnicses;
    }
}
