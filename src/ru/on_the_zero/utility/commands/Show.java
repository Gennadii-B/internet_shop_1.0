package ru.on_the_zero.utility.commands;

import ru.on_the_zero.entity.AbstractProduct;
import ru.on_the_zero.entity.Basket;
import ru.on_the_zero.utility.Shop;

import java.util.ArrayList;

/**
 * Created by gendy on 02.12.16.
 */
public class Show implements Command {

    @Override
    public void action(String[] messege) {
        if(messege.length > 1 && messege[1].equals("all")){
            showType(Shop.getStock().getProductsFood());
            showType(Shop.getStock().getProductsClothing());
            showType(Shop.getStock().getProductsTechnics());
        }
        if(messege.length > 1 && messege[1].equals("food"))
            showType(Shop.getStock().getProductsFood());

        if(messege.length > 1 && messege[1].equals("clothing"))
            showType(Shop.getStock().getProductsClothing());

        if(messege.length > 1 && messege[1].equals("technics"))
            showType(Shop.getStock().getProductsTechnics());

        if(messege.length > 1 && Shop.getBasket() != null && messege[1].equals("basket"))
            Shop.getBasket().showOrderProducts();

        if(messege.length > 1 && messege[1].equals("orders"))
            for(Basket basket : Shop.getStock().getBaskets()){
            basket.showOrderProducts();
            }
    }

    public static void showType(ArrayList<? extends AbstractProduct> list){
        for(int i = 0; i < list.size(); i++){
            list.get(i).showInfo();
        }
    }

    @Override
    public String getName() {
        return "show";
    }
}
