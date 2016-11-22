package ru.on_the_zero;

import ru.on_the_zero.utility.Menu;

import static ru.on_the_zero.entity.tools.SOP.println;

public class Main {

    public static void main(String[] args) throws Exception {


        Menu menu = Menu.getInstance();
        String[] messege;

        menu.startShop();

        while(Menu.shopStatus){
            messege = menu.firstCommand();
            menu.secondCommand(messege);
        }
    }
}
