package ru.on_the_zero.utility;

import ru.on_the_zero.db.Stock;
import ru.on_the_zero.utility.commands.Command;
import ru.on_the_zero.entity.*;

import java.util.ArrayList;

/**
 * Created by N on 20.11.2016.
 */
public class Shop {
    private static Shop ourInstance = new Shop();

    public static Shop getInstance() {
        return ourInstance;
    }

    private Shop() {
    }

    public static final boolean OPEN = true;
    public static final boolean CLOSED = false;
    private boolean shopStatus = OPEN;

    private static ArrayList<Command> commands = new ArrayList<>();
    private static Stock stock = new Stock();
    private static Basket basket = Unpacking.loadBasketFromDB();

    public Command processing(String[] messege){
        Command needCommand = null;
        for(Command command: commands) {
            if (messege[0].equals(command.getName())) {
                needCommand = command;
                break;
            }
        }
        return needCommand;
    }

    public ArrayList<Command> getCommands() {
        return commands;
    }

    public static Basket getBasket() {
        return basket;
    }

    public static void setBasket(Basket basket) {
        Shop.basket = basket;
    }

    public static Stock getStock() {
        return stock;
    }

    public boolean isShopStatus() {
        return shopStatus;
    }

    public void setShopStatus(boolean shopStatus) {
        this.shopStatus = shopStatus;
    }
}
