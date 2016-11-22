package ru.on_the_zero.entity;

import ru.on_the_zero.db.Controller;

import java.time.LocalDate;
import java.util.ArrayList;

import static ru.on_the_zero.entity.tools.SOP.println;

/**
 * Created by N on 20.11.2016.
 */
public class Order {

    ArrayList<Food> orderFoods = new ArrayList<>();
    ArrayList<Clothing> orderClothing = new ArrayList<>();
    ArrayList<Technics> orderTechnicses = new ArrayList<>();
    LocalDate dateBuy;

    Controller control = Controller.getInstance();

    public void showOrderProducts(){
        control.showType(orderFoods);
        control.showType(orderClothing);
        control.showType(orderTechnicses);
        println("\n общая стоимость: " + summ());
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
}
