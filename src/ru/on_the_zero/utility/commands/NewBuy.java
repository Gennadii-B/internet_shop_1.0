package ru.on_the_zero.utility.commands;

import ru.on_the_zero.db.Texts;
import ru.on_the_zero.entity.Basket;
import ru.on_the_zero.utility.Shop;

/**
 * Created by gendy on 02.12.16.
 */
public class NewBuy implements Command {

    @Override
    public void action(String[] messege) {
        Shop.setBasket(new Basket());
        System.out.println(Texts.TEXT_CREATED_NEW_ORDER);
    }

    @Override
    public String getName() {
        return "new buy";
    }
}

