package ru.on_the_zero.utility;

import ru.on_the_zero.utility.commands.*;
import ru.on_the_zero.entity.Clothing;
import ru.on_the_zero.entity.Food;
import ru.on_the_zero.entity.Technics;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by gendy on 02.12.16.
 */
public class Initializer {
    static int id = 0;

    public void initProducts(){

        Random random = new Random();


        String[] namesFood = new String[]{"гречка", "молоко", "конфеты", "хлеб", "бананы"};
        String[]  namesClothing = new String[]{"рубашка", "носки", "шапка", "трусы", "брюки"};
        String[]  namesTechnics = new String[]{"калькулятор", "эл. весы", "лампа", "наушники", "веб камера"};

        for(int i = 0; i < 5; i++){
            setFood().add(new Food(namesFood[i]));
            setFood().get(i).setId(id++);
            setFood().get(i).setPrice(random.nextInt(150) + 50);
            setFood().get(i).setAmount(20);
            setFood().get(i).setDateMake(LocalDate.of(2016, 10, 21));
            setFood().get(i).setDateValid(LocalDate.of(2017, 2, 10));

            setClothing().add(new Clothing(namesClothing[i]));
            setClothing().get(i).setId(id++);
            setClothing().get(i).setPrice(random.nextInt(450) + 50);
            setClothing().get(i).setAmount(20);
            setClothing().get(i).setColor("Green");
            setClothing().get(i).setSize(47);

            setTechnics().add(new Technics(namesTechnics[i]));
            setTechnics().get(i).setId(id++);
            setTechnics().get(i).setPrice(random.nextInt(350) + 50);
            setTechnics().get(i).setAmount(20);
            setTechnics().get(i).setGuarantee(true);

        }
    }

    public static void initCommands(){
        setCom(new Add());
        setCom(new Exit());
        setCom(new Help());
        setCom(new NewBuy());
        setCom(new Show());
        setCom(new Pay());
    }

    private static void setCom(Command com){
        Shop shop = Shop.getInstance();
        shop.getCommands().add(com);
    }
    private ArrayList<Food> setFood(){
        return Shop.getStock().getProductsFood();
    }
    private ArrayList<Clothing> setClothing(){
        return Shop.getStock().getProductsClothing();
    }
    private ArrayList<Technics> setTechnics(){
        return Shop.getStock().getProductsTechnics();
    }
}
