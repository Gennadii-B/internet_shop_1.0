package ru.on_the_zero.utility.commands;

import ru.on_the_zero.db.Texts;
import ru.on_the_zero.utility.Shop;

import java.time.LocalDate;

/**
 * Created by gendy on 03.12.16.
 */
public class Pay implements Command{

    @Override
    public void action(String[] messege) {
        Shop.getBasket().setDateBuy(LocalDate.now());
        Shop.getStock().getBaskets().add(Shop.getBasket());
        Shop.setBasket(null);
        System.out.println(Texts.TEXT_BUY_CLOSED);
    }

    @Override
    public String getName() {
        return "pay";
    }
}
