package ru.on_the_zero.utility.commands;

import ru.on_the_zero.db.Texts;
import ru.on_the_zero.utility.Shop;
import static ru.on_the_zero.utility.SOP.println;

/**
 * Created by gendy on 02.12.16.
 */
public class Add implements Command {

    @Override
    public void action(String[] messege) {
        if(Shop.getBasket() == null) println(Texts.TEXT_CREATE_NEW_ORDER);

        if(Shop.getBasket() != null && messege[1].equals("food")) {
            Shop.getBasket().getOrderFoods().add(SearchFood.find(messege));
            println(Texts.TEXT_PRODUCT_ADDED);
        }
        if(Shop.getBasket() != null && messege[1].equals("clothing")) {
            Shop.getBasket().getOrderClothing().add(SearchClothing.find(messege));
            println(Texts.TEXT_PRODUCT_ADDED);
        }
        if(Shop.getBasket() != null && messege[1].equals("technics")) {
            Shop.getBasket().getOrderTechnicses().add(SearchTechnics.find(messege));
            println(Texts.TEXT_PRODUCT_ADDED);
        }
    }

    @Override
    public String getName() {
        return "add";
    }

}
