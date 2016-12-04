package ru.on_the_zero;

import ru.on_the_zero.db.Texts;
import ru.on_the_zero.utility.commands.Command;
import ru.on_the_zero.utility.Reader;
import ru.on_the_zero.utility.*;

import static ru.on_the_zero.utility.SOP.println;

public class Main {

    public static void main(String[] args) throws Exception {

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

        while(shop.isShopStatus()){
            messege = Reader.readLine();
            command = shop.processing(messege);
            command.action(messege);
        }

        packing.pack();
    }
}
