package ru.on_the_zero.utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import static ru.on_the_zero.entity.tools.SOP.println;
/**
 * Created by N on 20.11.2016.
 */
public class Reader {
    private static Reader ourInstance = new Reader();

    public static Reader getInstance() {
        return ourInstance;
    }

    private Reader() {
    }

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public String[] readLine() throws Exception{
        String str = reader.readLine();
        String[] mass = str.split("/");
        return mass;
    }
}
