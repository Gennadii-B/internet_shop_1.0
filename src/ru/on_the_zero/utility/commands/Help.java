package ru.on_the_zero.utility.commands;

import ru.on_the_zero.db.Texts;

/**
 * Created by gendy on 02.12.16.
 */
public class Help implements Command {

    @Override
    public void action(String[] messege) {
        System.out.println(Texts.TEXT_ALL_COMMANDS);
    }

    @Override
    public String getName() {
        return "help";
    }
}
