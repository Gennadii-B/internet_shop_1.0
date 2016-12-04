package ru.on_the_zero.utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static ru.on_the_zero.utility.SOP.println;
/**
 * Created by N on 20.11.2016.
 */
public class Reader {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String[] readLine() throws Exception{
        String str = reader.readLine();
        String[] mass = str.split("/");
        return mass;
    }
}
