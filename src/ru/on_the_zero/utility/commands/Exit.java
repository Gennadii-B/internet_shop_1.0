package ru.on_the_zero.utility.commands;

import ru.on_the_zero.db.Texts;
import ru.on_the_zero.utility.Shop;

import static ru.on_the_zero.utility.SOP.println;

/**
 * Created by gendy on 02.12.16.
 */
public class Exit implements Command {

    Shop controller = Shop.getInstance();

    @Override
    public void action(String[] messege) {
        controller.setShopStatus(Shop.CLOSED);
        println(Texts.TEXT_SHOP_CLOSE);
    }

    @Override
    public String getName() {
        return "exit";
    }
}
