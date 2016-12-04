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
        if(Shop.getOrder() == null) println(Texts.TEXT_CREATE_NEW_ORDER);

        if(Shop.getOrder() != null && messege[1].equals("food")) {
            Shop.getOrder().getOrderFoods().add(SearchFood.find(messege));
            println(Texts.TEXT_PRODUCT_ADDED);
        }
        if(Shop.getOrder() != null && messege[1].equals("clothing")) {
            Shop.getOrder().getOrderClothing().add(SearchClothing.find(messege));
            println(Texts.TEXT_PRODUCT_ADDED);
        }
        if(Shop.getOrder() != null && messege[1].equals("technics")) {
            Shop.getOrder().getOrderTechnicses().add(SearchTechnics.find(messege));
            println(Texts.TEXT_PRODUCT_ADDED);
        }
    }

    @Override
    public String getName() {
        return "add";
    }

}
