package ru.on_the_zero.db;

import ru.on_the_zero.entity.*;

import java.util.ArrayList;

/**
 * Created by N on 20.11.2016.
 */
public class Controller {
    private static Controller ourInstance = new Controller();

    public static Controller getInstance() {
        return ourInstance;
    }

    private Controller() {
    }

    Stock stock = Stock.getInstance();

    public void orderArchivator(Order order){
        stock.getOrders().add(order);
    }

    public void showAllProducts(){
        showFood();
        showClothing();
        showTechnics();
    }

    public Food searchFood(String name){
        Food foodNeed = new Food("no Need");
        for(Food food: stock.getProductsFood()) {
            if(name.equals(food.getName())){
                foodNeed = food;
                break;
            }
        }
        return foodNeed;
    }

    public Clothing searchCloth(String str){
        Clothing clothNeed = new Clothing("no Need");
        for(Clothing cloth: stock.getProductsClothing()) {
            if(str.equals(cloth.getName())){
                clothNeed = cloth;
                break;
            }

        }
        return clothNeed;
    }

    public Technics searchTechnic(String str){
        Technics technicNeed = new Technics("no Need");
        for(Technics technic: stock.getProductsTechnics()) {
            if(str.equals(technic.getName()))
                technicNeed = technic;
            break;
        }
        return technicNeed;
    }

    public void showFood(){
        showType(stock.getProductsFood());
    }

    public void showClothing() {
        showType(stock.getProductsClothing());
    }

    public void showTechnics() {
        showType(stock.getProductsTechnics());
    }

    public void showType(ArrayList<? extends AbstractProduct> list){
        for(int i = 0; i < list.size(); i++){
            list.get(i).showInfo();
        }
    }

}
