package ru.on_the_zero.utility.commands;

import java.io.IOException;

/**
 * Created by gendy on 02.12.16.
 */
public interface Command {

    public void action(String[] messege);

    public String getName();
}
