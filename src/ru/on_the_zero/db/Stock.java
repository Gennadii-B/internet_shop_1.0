package ru.on_the_zero.db;

import ru.on_the_zero.entity.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by N on 20.11.2016.
 */
public class Stock {
    private static Stock ourInstance = new Stock();

    static Stock getInstance() {
        return ourInstance;
    }

    private Stock() {
        init();
    }

    private ArrayList<Food> productsFood = new ArrayList<>();
    private ArrayList<Clothing> productsClothing = new ArrayList<>();
    private ArrayList<Technics> productsTechnics = new ArrayList<>();
    private ArrayList<Order> Orders = new ArrayList<>();


    ArrayList<Order> getOrders() {
        return Orders;
    }

    ArrayList<Food> getProductsFood() {
        return productsFood;
    }

    ArrayList<Clothing> getProductsClothing() {
        return productsClothing;
    }

    ArrayList<Technics> getProductsTechnics() {
        return productsTechnics;
    }

    static int id = 1;

    void init(){
        Random random = new Random();

        String[] namesFood = new String[]{"Гречка", "Молоко", "Конфеты", "Хлеб", "Бананы"};
        String[]  namesClothing = new String[]{"Рубашка", "Носки", "Шапка", "Трусы", "Брюки"};
        String[]  namesTechnics = new String[]{"Калькулятор", "Эл. Весы", "Лампа", "Наушники", "Веб камера"};

        for(int i = 0; i < 5; i++){
            productsFood.add(new Food(namesFood[i]));
            productsFood.get(i).setId(id++);
            productsFood.get(i).setPrice(random.nextInt(150) + 50);
            productsFood.get(i).setAmount((float)(random.nextInt(8) + 1));
            productsFood.get(i).setDateMake(LocalDate.of(2016, 10, 21));
            productsFood.get(i).setDateValid(LocalDate.of(2017, 2, 10));

            productsClothing.add(new Clothing(namesClothing[i]));
            productsClothing.get(i).setId(id++);
            productsClothing.get(i).setPrice(random.nextInt(450) + 50);
            productsClothing.get(i).setAmount((random.nextInt(8) + 1));
            productsClothing.get(i).setColor("Green");
            productsClothing.get(i).setSize(47);

            productsTechnics.add(new Technics(namesTechnics[i]));
            productsTechnics.get(i).setId(id++);
            productsTechnics.get(i).setPrice(random.nextInt(350) + 50);
            productsTechnics.get(i).setAmount((random.nextInt(8) + 1));
            productsTechnics.get(i).setGuarantee(true);

        }
    }
}
