package ru.on_the_zero;

import ru.on_the_zero.db.Texts;
import ru.on_the_zero.entity.Basket;
import ru.on_the_zero.utility.commands.Command;
import ru.on_the_zero.utility.Reader;
import ru.on_the_zero.utility.*;

import static ru.on_the_zero.utility.SOP.println;


public class Main {

    public static void main(String[] args) throws Exception {

        //******** Postgres ***********
        DaoBaseController daoBaseController = DaoBaseController.getInstance();
        daoBaseController.RegDriverManager();
        daoBaseController.connect();
        //*****************************

        String[] messege;
        Command command;
        Shop shop = Shop.getInstance();
        Packing packing = new Packing();
        Unpacking unpacking = new Unpacking();
        Initializer initializer = new Initializer();

        Initializer.initCommands();
        if(unpacking.isHaveFile())unpacking.unpack();
        else initializer.initProducts();

        println(Texts.TEXT_HELLO + "\n" +
                Texts.TEXT_ALL_COMMANDS);
        if(shop.getBasket() != null)shop.getBasket().showOrderProducts();
        else shop.setBasket(new Basket());

        while(shop.isShopStatus()){
            try {
                messege = Reader.readLine();
                command = shop.processing(messege);
                command.action(messege);
            }catch(NullPointerException e){
                System.out.println("упс =)");
            }
        }
/////
        packing.packBasketDB(shop.getBasket());
        packing.pack();
        daoBaseController.close();
    }
}
